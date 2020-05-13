package com.cg.authorizationserver.resources;

import com.cg.authorizationserver.dto.SignInFailResponse;
import com.cg.authorizationserver.dto.SignInResponse;
import com.cg.authorizationserver.dto.SignInUserDTO;
import com.cg.authorizationserver.dto.SignUpUserDTO;
import com.cg.authorizationserver.models.AuthUser;
import com.cg.authorizationserver.models.Roles;
import com.cg.authorizationserver.repository.AuthUserRepository;
import com.cg.authorizationserver.repository.RolesRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/auth")
public class AuthResource {

    private final AuthUserRepository applicationUserRepository;
    private final RolesRepository rolesRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    public AuthResource(AuthUserRepository applicationUserRepository,
                        RolesRepository rolesRepository,
                        BCryptPasswordEncoder bCryptPasswordEncoder
    ) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.rolesRepository = rolesRepository;
    }

    @PostMapping("/authorize")
    public ResponseEntity<?> signIn(@Valid @RequestBody SignInUserDTO signInUserDTO) {

        try {
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    signInUserDTO.getUsername(), signInUserDTO.getPassword(), Collections.emptyList());
            // 3. Authentication manager authenticate the user, and use UserDetialsServiceImpl::loadUserByUsername() method to load the user.
            Authentication authentication = this.authenticationManager.authenticate(authToken);

//        using this to fetch all authorities
            Collection<GrantedAuthority> authenticatedUserAuthorityList =
                    ((User) authentication.getPrincipal()).getAuthorities();
            Calendar c = Calendar.getInstance();
//        10 minute expiration period
            c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + 10);
            String token = Jwts.builder()
                    .setExpiration(c.getTime())
                    .setSubject(((User) authentication.getPrincipal()).getUsername())
                    .claim("roles", authenticatedUserAuthorityList)
                    .setIssuer("healthcare")
                    .signWith(SignatureAlgorithm.HS512, "secure").compact();
            return ResponseEntity.status(200).body(new SignInResponse(token, true, authenticatedUserAuthorityList));

        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body(new SignInFailResponse(false, e.getMessage()));
        }

    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@Valid @RequestBody SignUpUserDTO signUpUserDTO) {
        try {
            if(applicationUserRepository.existsByUsername(signUpUserDTO.getUsername())){
                return ResponseEntity.badRequest().body("Error: Email is already in use!");
            }
            AuthUser authUser = new AuthUser();
            authUser.setPassword(bCryptPasswordEncoder.encode(signUpUserDTO.getPassword()));
            authUser.setUsername(signUpUserDTO.getUsername());
            authUser.setFirstName(signUpUserDTO.getFirstName());
            authUser.setLastName(signUpUserDTO.getLastName());
            authUser.setContactNo(signUpUserDTO.getContactNo());
            List<Roles> rolesList = signUpUserDTO.getRolesList().stream().map(Roles::new).collect(Collectors.toList());
            rolesRepository.saveAll(rolesList);
            authUser.setRolesList(rolesList);
            applicationUserRepository.save(authUser);
            return ResponseEntity.ok("USer Registartion Successful");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Registartion Failed");
        }


    }
}

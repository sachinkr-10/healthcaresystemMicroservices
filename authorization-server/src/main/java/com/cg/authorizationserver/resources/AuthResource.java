package com.cg.authorizationserver.resources;

import com.cg.authorizationserver.dto.SignUpUserDTO;
import com.cg.authorizationserver.models.AuthUser;
import com.cg.authorizationserver.models.Role;
import com.cg.authorizationserver.models.Roles;
import com.cg.authorizationserver.repository.AuthUserRepository;
import com.cg.authorizationserver.repository.RolesRepository;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.authentication.AuthenticationManagerFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthResource {

    private final AuthUserRepository applicationUserRepository;
    private final RolesRepository rolesRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AuthResource(AuthUserRepository applicationUserRepository,
                        RolesRepository rolesRepository,
                        BCryptPasswordEncoder bCryptPasswordEncoder
    ) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.rolesRepository = rolesRepository;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpUserDTO signUpUserDTO) {
        try {
            AuthUser authUser = new AuthUser();
            authUser.setPassword(bCryptPasswordEncoder.encode(signUpUserDTO.getPassword()));
            authUser.setUsername(signUpUserDTO.getUsername());
            List<Roles> rolesList = signUpUserDTO.getRolesList().stream().map(Roles::new).collect(Collectors.toList());
            rolesRepository.saveAll(rolesList);
            authUser.setRolesList(rolesList);
            applicationUserRepository.save(authUser);
            return ResponseEntity.ok("all good");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("failed");
        }


    }
}

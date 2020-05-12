package com.cg.authorizationserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInResponse {
    private String token;
    private boolean success;
    private Collection<GrantedAuthority> authorityList;
}

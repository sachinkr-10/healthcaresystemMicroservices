package com.cg.authorizationserver.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class SignInUserDTO {
    @NotNull
    private String username;
    @NonNull
    private String password;
}

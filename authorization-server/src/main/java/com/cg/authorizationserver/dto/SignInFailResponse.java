package com.cg.authorizationserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInFailResponse {
    private boolean success;
    private String msg;
}

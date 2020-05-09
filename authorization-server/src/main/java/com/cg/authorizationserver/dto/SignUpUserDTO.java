package com.cg.authorizationserver.dto;
import com.cg.authorizationserver.models.Role;
import com.cg.authorizationserver.models.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class SignUpUserDTO {
    private String username;
    private String password;
    List<Role> rolesList;
}

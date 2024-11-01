package com.example.demo.dto.response;


import java.util.Set;

import com.example.booking_app.entity.Permission;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleResponse {
    String name;
    String description;
    Set<PermissionResponse> permissions;

    public void setRoleId(String roleId) {
    }

    public void setRoleName(String roleName) {
    }
}

package com.wildcodeschool.webook.role.application;

import com.wildcodeschool.webook.role.domain.entity.Role;
import com.wildcodeschool.webook.role.domain.service.RoleService;
import org.springframework.web.bind.annotation.*;

@RestController
public class RoleController {
    public RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/roles/{id}")
    public Role getOneRole(@PathVariable Long id) {
        return roleService.readOne(id);
    }

    @PostMapping("/roles")
    public Role addRole(@RequestBody Role newRole) {
        return roleService.createRole(newRole);
    }
}

package com.brk.CarShare.Controllers;

import com.brk.CarShare.Entities.Role;
import com.brk.CarShare.Services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role")
@RequiredArgsConstructor
public class RoleController {

    @Autowired
    private final RoleService roleService;
    @PostMapping("/add")
    public ResponseEntity addRole(@RequestBody Role role) {
        roleService.addRole(role);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Role>> getAllRoles() {
        return ResponseEntity.ok(roleService.getAllRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity getRoleById(@PathVariable String id) {
        return ResponseEntity.ok(roleService.getRoleById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateRole(@RequestBody Role role) {
        roleService.updateRole(role);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteRole(@PathVariable String id) {
        roleService.deleteRole(id);
        return ResponseEntity.noContent().build();
    }

}

package com.brk.CarShare.Controllers;

import com.brk.CarShare.Entities.Role;
import com.brk.CarShare.Repositories.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {
    @Autowired
    private IRoleRepository roleRepo;

    @PostMapping("/addRole")
    public String saveRole(@RequestBody Role role){
        roleRepo.save(role);

        return "Added Successfully";
    }

    @GetMapping("/getAllRoles")
    public List<Role> getAllRoles() {

        return roleRepo.findAll();
    }
}

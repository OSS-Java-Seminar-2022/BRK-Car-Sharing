package com.brk.CarShare.Services;

import com.brk.CarShare.Entities.Role;
import com.brk.CarShare.Repositories.IRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleService {
    private final IRoleRepository roleRepository;

    public void addRole(Role role)
    {
        roleRepository.insert(role);
    }
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(String id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Cannot Find Role by ID - %d", id)));
    }
    public void updateRole(Role role) {
        Role savedRole = roleRepository.findById(role.getId()).orElseThrow(() -> new RuntimeException(String.format("Cannot Find Role by ID %s", role.getId())));
        savedRole.setId(role.getId());
        savedRole.setName(role.getName());

        roleRepository.save(role);
    }

    public void deleteRole(String id) {
        roleRepository.deleteById(id);
    }
}
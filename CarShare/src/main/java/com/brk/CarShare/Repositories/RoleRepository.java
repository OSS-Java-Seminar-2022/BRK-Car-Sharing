package com.brk.CarShare.Repositories;

import java.util.Optional;

import com.brk.CarShare.Entities.ERole;
import com.brk.CarShare.Entities.Role;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
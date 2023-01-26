package com.brk.CarShare.Repositories;

import com.brk.CarShare.Entities.ERole;
import com.brk.CarShare.Entities.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IRoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}

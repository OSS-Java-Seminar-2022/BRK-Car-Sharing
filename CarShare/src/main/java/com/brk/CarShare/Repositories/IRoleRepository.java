package com.brk.CarShare.Repositories;

import com.brk.CarShare.Entities.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IRoleRepository extends MongoRepository<Role, String> {
}

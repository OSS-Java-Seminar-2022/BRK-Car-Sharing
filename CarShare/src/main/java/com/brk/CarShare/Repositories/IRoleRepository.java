package com.brk.CarShare.Repositories;

import com.brk.CarShare.Entities.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface IRoleRepository extends MongoRepository<Role, String> {
}

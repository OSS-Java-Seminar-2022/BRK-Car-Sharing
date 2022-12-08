package com.brk.CarShare.Repositories;

import com.brk.CarShare.Entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUserRepository extends MongoRepository<User, String> {
}

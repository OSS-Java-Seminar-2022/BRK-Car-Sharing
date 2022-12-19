package com.brk.CarShare.Repositories;
import com.brk.CarShare.Entities.Trip;

import org.springframework.data.mongodb.repository.MongoRepository;
public interface ITripRepository extends MongoRepository<Trip,String>{
}

package com.brk.CarShare.Repositories;

import com.brk.CarShare.Entities.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface VehicleRepository extends MongoRepository<Vehicle,String> {

    @Query("{ 'make': { $regex: ?0, $options: 'i' } }")
    Page<Vehicle> findByMake(String make, Pageable pageable);

}

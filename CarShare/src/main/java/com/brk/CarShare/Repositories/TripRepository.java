package com.brk.CarShare.Repositories;

import com.brk.CarShare.Entities.Trip;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TripRepository extends MongoRepository<Trip,String>{
    List<Trip> getTripsByStartTimeBetween(String dateFrom, String dateTo);

    @Query("{ $or: [ { 'userId': { $regex: ?0, $options: 'i' } }, { 'status': { $regex: ?0, $options: 'i' } } ] }")
    Page<Trip> findBySearchTerm(String searchTerm, Pageable pageable);
}

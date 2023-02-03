package com.brk.CarShare.Repositories;

import com.brk.CarShare.Entities.SupportTicket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface SupportTicketRepository extends MongoRepository<SupportTicket, String> {
    List<SupportTicket> getSupportTicketsByDescriptionContaining(String query);
    List<SupportTicket> getSupportTicketsByTicketTimeBetween(String dateFrom, String dateTo);
    List<SupportTicket> getSupportTicketsByDescriptionContainingAndTicketTimeIsBetween(String query, String dateFrom, String dateTo);

    @Query("{$or: [{'title': {$regex : ?0, $options: 'i'}}, {'description': {$regex : ?0, $options: 'i'}}, {'status': {$regex : ?0, $options: 'i'}}]}")
    Page<SupportTicket> findByAllAttributesContainingIgnoreCase(String searchTerm, Pageable pageable);
}

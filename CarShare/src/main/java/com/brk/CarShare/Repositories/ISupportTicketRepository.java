package com.brk.CarShare.Repositories;

import com.brk.CarShare.Entities.SupportTicket;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ISupportTicketRepository extends MongoRepository<SupportTicket, String> {
    List<SupportTicket> findSupportTicketByDescriptionContains(String description);
    List<SupportTicket> findSupportTicketByDescriptionContains(String description, String dateFrom, String dateTo);
}

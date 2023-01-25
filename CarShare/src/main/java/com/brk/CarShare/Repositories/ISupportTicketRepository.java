package com.brk.CarShare.Repositories;

import com.brk.CarShare.Entities.SupportTicket;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ISupportTicketRepository extends MongoRepository<SupportTicket, String> {
    List<SupportTicket> getSupportTicketsByDescriptionContaining(String query);
    List<SupportTicket> getSupportTicketsByTicketTimeBetween(String dateFrom, String dateTo);
    List<SupportTicket> getSupportTicketsByDescriptionContainingAndTicketTimeIsBetween(String query, String dateFrom, String dateTo);
}

package com.brk.CarShare.Repositories;

import com.brk.CarShare.Entities.SupportTicket;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ISupportTicketRepository extends MongoRepository<SupportTicket, Long> {
}

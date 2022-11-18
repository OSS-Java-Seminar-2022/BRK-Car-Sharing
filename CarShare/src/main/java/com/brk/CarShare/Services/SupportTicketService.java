package com.brk.CarShare.Services;

import com.brk.CarShare.Entities.SupportTicket;
import com.brk.CarShare.Repositories.ISupportTicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SupportTicketService {
    private final ISupportTicketRepository supportTicketRepository;

    public void addSupportTicket(SupportTicket supportTicket)
    {
        supportTicketRepository.insert(supportTicket);
    }
    public List<SupportTicket> getAllSupportTickets() {
        return supportTicketRepository.findAll();
    }

    public SupportTicket getSupportTicketById(Long id) {
        return supportTicketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Cannot Find Support ticket by ID - %d", id)));
    }
    public void updateSupportTicket(SupportTicket supportTicket) {
        supportTicketRepository.save(supportTicket);
    }

    public void deleteSupportTicket(Long id) {
        supportTicketRepository.deleteById(id);
    }
}
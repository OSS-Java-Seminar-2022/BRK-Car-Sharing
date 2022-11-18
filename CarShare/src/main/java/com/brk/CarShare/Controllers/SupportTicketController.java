package com.brk.CarShare.Controllers;

import com.brk.CarShare.Entities.SupportTicket;
import com.brk.CarShare.Services.SupportTicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supportTicket")
@RequiredArgsConstructor
public class SupportTicketController {

    @Autowired
    private final SupportTicketService supportTicketService;
    @PostMapping("/addSupportTicket")
    public ResponseEntity addSupportTicket(@RequestBody SupportTicket supportTicket) {
        supportTicketService.addSupportTicket(supportTicket);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping("/getAllSupportTickets")
    public ResponseEntity<List<SupportTicket>> getAllSupportTickets() {
        return ResponseEntity.ok(supportTicketService.getAllSupportTickets());
    }

    @GetMapping("/{id}")
    public ResponseEntity getSupportTicketById(@PathVariable Long id) {
        return ResponseEntity.ok(supportTicketService.getSupportTicketById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateSupportTicket(@RequestBody SupportTicket supportTicket) {
        supportTicketService.updateSupportTicket(supportTicket);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSupportTicket(@PathVariable Long id) {
        supportTicketService.deleteSupportTicket(id);
        return ResponseEntity.noContent().build();
    }

}

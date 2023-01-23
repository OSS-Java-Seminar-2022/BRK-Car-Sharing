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
@RequestMapping("/api/supportTicket")
@RequiredArgsConstructor
public class SupportTicketController {

    @Autowired
    private final SupportTicketService supportTicketService;
    @PostMapping("/add")
    public ResponseEntity addSupportTicket(@RequestBody SupportTicket supportTicket) {
        supportTicketService.addSupportTicket(supportTicket);
        return ResponseEntity.ok("Succesfully added support ticket!");
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<SupportTicket>> getAllSupportTickets() {
        return ResponseEntity.ok(supportTicketService.getAllSupportTickets());
    }

    @GetMapping("/{id}")
    public ResponseEntity getSupportTicketById(@PathVariable String id) {
        return ResponseEntity.ok(supportTicketService.getSupportTicketById(id));
    }

    @PatchMapping("/update")
    public ResponseEntity updateSupportTicket(@RequestBody SupportTicket supportTicket) {
        supportTicketService.updateSupportTicket(supportTicket);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping("/{description}")
    ResponseEntity<List<SupportTicket>> findSupportTicketByDescriptionContains(@PathVariable String description){
        return ResponseEntity.ok(supportTicketService.findSupportTicketByDescriptionContains(description));
    }
    @GetMapping("/{description}/{dateFrom}/{dateTo}")
    ResponseEntity<List<SupportTicket>> findSupportTicketByDescriptionContains(@PathVariable String description, String dateFrom, String dateTo){
        return ResponseEntity.ok(supportTicketService.findSupportTicketByDescriptionContains(description, dateFrom, dateTo));
    }
}

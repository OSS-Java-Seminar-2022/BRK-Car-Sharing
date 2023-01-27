package com.brk.CarShare.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/key")
public class KeyController {
    @GetMapping("/generate")
    public String getKey() {
        return UUID.randomUUID().toString();
    }
}

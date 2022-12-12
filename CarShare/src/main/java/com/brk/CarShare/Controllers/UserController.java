package com.brk.CarShare.Controllers;

import com.brk.CarShare.Entities.User;
import com.brk.CarShare.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserService userService;
    public ResponseEntity addUser(@RequestBody User user){
        userService.addUser(user);
        return ResponseEntity.ok("Added user");
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {return ResponseEntity.ok(userService.getAllUsers());}
    @GetMapping("/{userId}")
    public ResponseEntity getUserById(@PathVariable String id){
        return ResponseEntity.ok(userService.getUserById(id));
    }
    @PatchMapping("/{userId}")
    public ResponseEntity updateUser (@RequestBody User user){
        userService.updateUser(user);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("/{userId}")
    public ResponseEntity deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}

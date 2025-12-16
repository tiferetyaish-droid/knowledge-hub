package com.example.knowledgehub.controller;

import com.example.knowledgehub.model.User;
import com.example.knowledgehub.service.UserService;
import com.example.knowledgehub.security.RequiresRole;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @RequiresRole("ADMIN")
    public List<User> list() {
        return userService.list();
    }

    @PostMapping
    @RequiresRole("ADMIN")
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    @PutMapping("/{id}/role")
    @RequiresRole("ADMIN")
    public void updateRole(@PathVariable Long id, @RequestParam String newRole) {
        userService.updateRole(id, newRole);
    }
}
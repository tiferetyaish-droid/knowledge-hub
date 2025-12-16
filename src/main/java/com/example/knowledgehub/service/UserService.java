package com.example.knowledgehub.service;

import com.example.knowledgehub.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();

    public User create(User user) {
        users.add(user);
        return user;
    }

    public List<User> list() {
        return users;
    }

    public void updateRole(Long userId, String role) {
        for (User u : users) {
            if (u.getId().equals(userId)) {
                u.setRole(role);
                break;
            }
        }
    }
}
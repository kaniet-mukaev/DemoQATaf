package com.demoqa.services;

import com.demoqa.data.MockDataService;
import com.demoqa.entity.User;
import lombok.Getter;

@Getter
public class InvalidUserService {

    private final MockDataService dataService = new MockDataService();

    public User generateInvalidUser() {
        String invalidEmail = dataService.generateRandomEmail();
        String invalidPassword = dataService.generateRandomPassword();
        String randomUsername = dataService.generateRandomFirstName(); // пусть будет, для консистентности
        return new User(invalidEmail, invalidPassword, randomUsername);
    }
}

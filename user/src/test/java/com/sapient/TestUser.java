package com.sapient;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sapient.contracts.IUser;
import com.sapient.entities.User;
import com.sapient.services.UserService;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestUser {

    static IUser userService;

    @BeforeAll
    public static void setup() {
        userService = new UserService();
    }

    @Test
    @DisplayName("Test creating a user")
    public void test_create_user() {
        assertTrue(userService.createUser("test@test.com", "testpassword", "test"));
    }

    @Test
    @DisplayName("Test creating another user with same email")
    public void test_create_another_user() {
        assertFalse(userService.createUser("test@test.com", "testpassword", "test"));
    }

    @Test
    @DisplayName("Test get a user")
    public void test_get_user() {
        User user = userService.getUser("test@test.com");
        assertAll(
            () -> assertEquals("test@test.com", user.getEmail()),
            () -> assertEquals("test", user.getUserName())
        );
    }

    @Test
    @DisplayName("Test validating correct user credentials")
    public void test_validate_correct_user_credentials() {
        assertTrue(userService.validateCredentials("test@test.com", "testpassword"), "Should return true when credentials are correct");
    }

    @Test
    @DisplayName("Test validating incorrect user credentials")
    public void test_validate_incorrect_user_credentials() {
        assertAll(
            () -> assertFalse(userService.validateCredentials("test@test.com", "tespassword"), "Should return false when credentials are wrong"),
            () -> assertFalse(userService.validateCredentials("test@test.om", "testpassword"), "Should return false when credentials are wrong")
        );

    }

}

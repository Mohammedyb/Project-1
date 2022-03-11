package com.example.Request.ServiceTest;

import com.example.Request.dao.UserRepository;
import com.example.Request.models.Reimbursements;
import com.example.Request.models.Users;
import com.example.Request.services.UserService;
import org.apache.catalina.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.jws.soap.SOAPBinding;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    private UserRepository repository;
    private UserService service;


    @BeforeEach
    public void initBeforeUseTest() {
        repository = mock(UserRepository.class);
        service = new UserService();
        service.setRepository(repository);
        }

    @Test
    public void shouldReturnUsersByEmail() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        String email = "mohammed.bubshait@revature.com";
        Optional<Users> users = service.getUserByEmail(email);
        assertTrue(users.equals(email));
    }


    @Test
    public void shouldReturnUsersByID() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        Long id = 2L;
        Optional<Users> users = service.getUserById(id);
        assertTrue(users.equals(id));
    }
}
package com.example.Request.ServiceTest;

import com.example.Request.dao.ReimbursementRepository;
import com.example.Request.models.Category;
import com.example.Request.models.Reimbursements;
import com.example.Request.models.Status;
import com.example.Request.models.Users;
import com.example.Request.services.ReimbursementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.jws.soap.SOAPBinding;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class ReimbursementServiceTest {
    private ReimbursementRepository repository;

    private ReimbursementService service;

    @BeforeEach
    public void initBeforeTest() {
        repository = mock(ReimbursementRepository.class);
        service = new ReimbursementService();
        service.setRepository(repository);
    }
    @Test
    public void shouldSaveReimbursements() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        Reimbursements reimbursements = new Reimbursements();
        service.saveReimbursement(reimbursements);
        assertTrue(reimbursements.equals(reimbursements));
    }

    @Test
    public void shouldReturnAllReimbursements() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        List<Reimbursements> reimbursements = service.getAllReimbursements();
        assertTrue(reimbursements.isEmpty());
    }
    @Test
    public void shouldReturnAllByID() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        Long id = 2l;
        Optional<Reimbursements> reimbursements = service.getById(id);
        assertTrue(reimbursements.equals(id));
    }
    @Test
    public void shouldReturnAllByCatergory() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        Category food = Category.FOOD;
        List<Reimbursements> reimbursements = service.getAllByCategory(food);
        assertTrue(reimbursements.equals(reimbursements));
    }
    @Test
    public void shouldReturnAllByStatus() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        Status approved = Status.APPROVED;
        List<Reimbursements> reimbursements = service.getAllByStatus(approved);
        assertTrue(reimbursements.equals(reimbursements));
    }

    @Test
    public void shouldReturnAllForEmployee() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        Users users = new Users();
        List<Reimbursements> reimbursements = service.getAllForEmployee(users);
        assertTrue(reimbursements.isEmpty());
    }
}
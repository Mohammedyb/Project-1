package com.example.Request.services;

import com.example.Request.dao.ReimbursementRepository;
import com.example.Request.dto.ReimbursementDTO;
import com.example.Request.models.Category;
import com.example.Request.models.Reimbursements;
import com.example.Request.models.Status;
import com.example.Request.models.Users;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ReimbursementService {
    public ReimbursementService() {
    }

    private ReimbursementRepository repository;
    private static final Logger logger = LoggerFactory.getLogger(ReimbursementService.class);

    @Autowired
    public ReimbursementService(ReimbursementRepository repository) {
        this.repository = repository;
    }


    public Reimbursements saveReimbursement(ReimbursementDTO dto, Users employee, Users manager) {
        Reimbursements reimburse = new Reimbursements();
        reimburse.setAmount(dto.getAmount());
        reimburse.setCategory(Category.valueOf(dto.getCategory()));
        reimburse.setEmployee(employee);
        reimburse.setManager(manager);
        reimburse.setStatus(Status.PENDING);

        saveReimbursement(reimburse);
        return reimburse;
    }

    public void saveReimbursement(Reimbursements reimbursement) {
        repository.save(reimbursement);
    }

    public List<Reimbursements> getAllReimbursements() {
        return repository.findAll();
    }

    public Optional<Reimbursements> getById(Long id) {
        return repository.findById(id);
    }

    public List<Reimbursements> getAllByCategory(Category category) {
        return repository.findAllByCategory(category);
    }

    public List<Reimbursements> getAllByStatus(Status status) {
        return repository.findAllByStatus(status);
    }

    public List<Reimbursements> getAllForEmployee(Users user) {
        switch (user.getRole()) {
            case ROLE_EMPLOYEE:
                logger.debug("Loading reimbursements created by user {}", user.getEmail());
                return getForEmployee(user);
            case ROLE_MANAGER:
                logger.debug("Loading reimbursements assigned to manager {}", user.getEmail());
                return getForManager(user);
            default:
                return Collections.emptyList();
        }
    }

    private List<Reimbursements> getForEmployee(Users user) {
        return repository.findAllByEmployee(user);
    }
    private List<Reimbursements> getForManager(Users user) {
        return repository.findAllByManager(user);
    }

    public void setRepository(ReimbursementRepository repository) {
    }
}
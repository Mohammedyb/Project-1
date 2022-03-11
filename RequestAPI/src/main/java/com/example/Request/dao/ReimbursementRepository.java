package com.example.Request.dao;


import com.example.Request.models.Category;
import com.example.Request.models.Reimbursements;
import com.example.Request.models.Status;
import com.example.Request.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface ReimbursementRepository extends JpaRepository<Reimbursements, Long> {
        List<Reimbursements> findAllByCategory(Category category);
        List<Reimbursements> findAllByStatus(Status status);
        List<Reimbursements> findAllByManager(Users user);
        List<Reimbursements> findAllByEmployee(Users user);
    }

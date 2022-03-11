package com.example.Request.controllers;

import com.example.Request.dto.ReimbursementDTO;
import com.example.Request.dto.UpdateStatusDTO;
import com.example.Request.models.Reimbursements;
import com.example.Request.models.Status;
import com.example.Request.models.Users;
import com.example.Request.services.ReimbursementService;
import com.example.Request.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("reimbursements")
public class ReimbursementController {
    @Value("${api.config.EmailApi-url:http://localhost:8081/email}")
    String api2Url;

    @Autowired
    RestTemplate restTemplate;

    private ReimbursementService reimbursementService;
    private UserService userService;


    @Autowired
    public ReimbursementController(ReimbursementService reimbursementService) {
        this.reimbursementService = reimbursementService;
    }

    @GetMapping
    public ResponseEntity getAll() {
        List<Reimbursements> allReimbursements = reimbursementService.getAllReimbursements();

        if(allReimbursements.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(allReimbursements);
    }

    @GetMapping("{id}/reimbursements")
    public ResponseEntity getMine(@PathVariable("id") Long userId) {

        Optional<Users> optUser = userService.getUserById(userId);

        if(!optUser.isPresent()) {

            return ResponseEntity.badRequest().body("User could not be found");
        }

        Users user = optUser.get();

        List<Reimbursements> userReimbursements = reimbursementService.getAllForEmployee(user);

        if(userReimbursements.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(userReimbursements);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity postReimbursements(@RequestBody ReimbursementDTO reimbursement) {
        try {
            Optional<Users>  Employee = userService.getUserByEmail(reimbursement.getEmpEmail());
            Optional<Users> Manager = userService.getUserByEmail(reimbursement.getManEmail());

            if(!Employee.isPresent() || !Manager.isPresent()) {
                return ResponseEntity.badRequest().body("Both users are required");
            }

            Reimbursements newReimbursements = reimbursementService.saveReimbursement(reimbursement, Employee.get(), Manager.get());
            return ResponseEntity.created(new URI("http://localhost:8080/reimbursements/"+newReimbursements.getId())).build();

        } catch (Exception ex) {
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @PatchMapping("{id}/update/status")
    public ResponseEntity updateStatus(@PathVariable("id") Long reimbursementId, @RequestBody UpdateStatusDTO newStatus) {
        try {
            Optional<Reimbursements> optReimb = reimbursementService.getById(reimbursementId);

            if(!optReimb.isPresent()) {
                return ResponseEntity.badRequest().body("Reimburse does not exist");
            }

            Reimbursements reimbursements = optReimb.get();
            reimbursements.setStatus(Status.valueOf(newStatus.getNewStatus()));
            reimbursementService.saveReimbursement(reimbursements);

            ResponseEntity resp = restTemplate.postForEntity(api2Url, reimbursements, null);

            if(resp.getStatusCode().is5xxServerError()) {
                return ResponseEntity.internalServerError().build();
             }

            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
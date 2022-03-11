package com.example.Email.Controller;
import com.example.Email.Model.Email;
import com.example.Email.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("email")
public class Controller {

    @Autowired
    EmailService emailService;

    public Controller(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<?> SendEmail(@RequestBody Email mail) {
        emailService.sendEmail(mail);
        return ResponseEntity.accepted().build();
    }

}
# Reimbursement System
# Project Description
The Expense Reimbursement System will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement.
# Technologies Used
    Java
    JUnit
    Spring Boot
    Spring Data
    Spring MVC
    Docker
    Postman
    Log4J
    Lombok
    Maven
    Git
    Hibernate
    PostgreSQL
    GCP Cloud SQL

# Features

    Built 2 separarte web APIs using Spring Boot, and deployed and orchestrated the applications using Docker and Docker Compose.
    Created First API = A reimbursement app with role specific controllers/services.
    Added Employee Role: can submit a reimbursement request, view all of my (employee) reimbursements.
    Added Manager Role: can view all reimbursements, approve/deny/reassign reimbursements. A manager can Approve a request or change it to Pending if the status is blank (null).
    Added Reimbursement Role: created to clear the reassign objective. Only a Reimbursement Manager has full access to updating any status.
    Created second API = Email API: Receive request to send emails to specified users. Grabs specific user emails, name, and reimbursement status API 1.
    Created Logging/Javadocs and presented using Insomnia.
    Created Service and Controller Testing using JUnit and Mockito.
    
# To-do list:
   
    Deploy into a Kubernetes cluster
    Add Monitoring/Logs/Alerts

# Getting Started

    git clone https://github.com/Mohammedyb/Project-1.git

### Usage of Reimbursement Api

    Run com.example.demo.ReimbursementApplication as a Java Application. Runs on port - 8080

### Usage of EmailApi

    Run com.example.demo.EmailApplication as a Java Application. Runs on port - 8081 

### Create new request

    http://localhost:8080/employee/newrequest

### View all request made by employee
    http://localhost:8080/employee/getbyempid/{empID}

### Gets all reimbursement requests by Employee ID{id}.
    http://localhost:8080/admin/getbyempid/{empID}

### Update status
   http://localhost:8080/admin/status/{reqid}



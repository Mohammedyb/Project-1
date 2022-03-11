package com.example.Request.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

<<<<<<< HEAD
import java.time.LocalDate;
import java.time.LocalTime;

=======
>>>>>>> 12398bc2cf7a0e89947ed801b3fb6691287b5efc

@Getter
@Setter
public class ReimbursementDTO {
    public ReimbursementDTO() {
    }

    public ReimbursementDTO(String category, Float amount, String empEmail, String manEmail) {
        this.category = category;
        this.amount = amount;
        this.empEmail = empEmail;
        this.manEmail = manEmail;
    }

    private String category;
    private Float amount;
    private String empEmail;
    private String manEmail;
<<<<<<< HEAD
}


=======
}
>>>>>>> 12398bc2cf7a0e89947ed801b3fb6691287b5efc

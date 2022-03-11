package com.example.Email.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class EmailDTO {
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    public class Email {
        private String From;
        private String To;
        private String Subject;
        private String Content;
    }
}
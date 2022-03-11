package com.example.Email.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
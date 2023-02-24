package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    
    @Pattern(regexp = "[a-zA-Z]{3,22}", message = "Name should be alphabets only and Limit 3-22 without space")
    private String studentName;
    
    @Max(value = 100, message = "Roll should be less than 100")
    @Min(value = 1, message = "Roll should be greater than 1")
    private Integer studentRoll;

    @Pattern(regexp = "[789][0-9]{9}", message = "Mobile Number should be 10 digits")
    private String studentMobile;

    @Pattern(regexp = "^(http(s?):)([/|.\\w\\s-])*\\.(?:jpg|gif|png)$", message = "Image url is not valid")
    private String imageUrl;


}


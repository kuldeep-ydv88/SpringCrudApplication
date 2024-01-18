package com.example.paginatorbackend.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.util.Date;

/**
 * This is Employee Class
 */
@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long  id;
    private String firstName;
    private String lastName;
    private String email;
    private Date dob;
    private String  gender;
    private String branch;
    private String company;
    private Boolean deleted=false;


}

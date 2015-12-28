package com.healthnet.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by Ormarr on 12/27/2015.
 */

@Entity
public class MedicalHistory {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private Date dob;

}
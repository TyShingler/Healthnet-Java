package com.healthnet.repository;

import com.healthnet.domain.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Ormarr on 12/27/2015.
 */

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {

}

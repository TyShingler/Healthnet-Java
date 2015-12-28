package com.healthnet.repository;

import com.healthnet.domain.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Ormarr on 12/28/2015.
 */
@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {

}

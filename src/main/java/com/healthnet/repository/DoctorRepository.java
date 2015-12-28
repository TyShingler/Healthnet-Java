package com.healthnet.repository;

import com.healthnet.domain.Doctor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DoctorRepository extends CrudRepository<Doctor, Long> {

}

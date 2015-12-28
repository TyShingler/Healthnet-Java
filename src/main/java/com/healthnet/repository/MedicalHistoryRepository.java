package com.healthnet.repository;

import com.healthnet.domain.MedicalHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalHistoryRepository extends CrudRepository<MedicalHistory, Long>{

}

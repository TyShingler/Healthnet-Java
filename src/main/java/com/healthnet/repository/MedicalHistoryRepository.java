package com.healthnet.repository;

import com.healthnet.domain.MedicalHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Ormarr on 12/27/2015.
 */
@Repository
public interface MedicalHistoryRepository extends CrudRepository<MedicalHistory, Long>{

}

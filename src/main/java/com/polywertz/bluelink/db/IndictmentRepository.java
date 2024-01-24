package com.polywertz.bluelink.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndictmentRepository extends CrudRepository<Indictment, Long> {
    boolean existsByIdAndChargeId(Long id, Long chargeId);
    Indictment findByIdAndChargeId(Long id, Long chargeId);
}

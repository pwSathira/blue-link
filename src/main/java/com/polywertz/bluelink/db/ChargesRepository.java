package com.polywertz.bluelink.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargesRepository extends CrudRepository<Charges, Long> {
    // Define custom query methods here
    Iterable<Charges> findByCategory(String category);
    Iterable<Charges> findByFelonyType(String felonyType);

    Iterable<Charges> findAll();
}

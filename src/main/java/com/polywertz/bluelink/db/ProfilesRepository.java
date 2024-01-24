package com.polywertz.bluelink.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfilesRepository extends CrudRepository<Profiles, Long> {
    // Define custom query methods here
    Iterable<Profiles> findByNameContainingIgnoreCase(String searchTerm);

}

// UserRepository.java
package com.polywertz.bluelink.db;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    // Define query methods here
}
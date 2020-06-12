package com.rehmanmsit.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.rehmanmsit.repository.entity.User;

/**
 *
 * @author Rehman
 *
 */

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, Long>{

}

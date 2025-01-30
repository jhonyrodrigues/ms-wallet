package com.service.dataprovider.database.repository;

import com.service.dataprovider.database.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {

    UserEntity findByLogin(String username);

}

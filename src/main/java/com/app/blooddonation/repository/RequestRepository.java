package com.app.blooddonation.repository;

import com.app.blooddonation.model.Request;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends MongoRepository<Request, String> {
}

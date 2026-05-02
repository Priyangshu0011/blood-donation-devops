package com.app.blooddonation.repository;

import com.app.blooddonation.model.Donor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonorRepository extends MongoRepository<Donor, String> {
    List<Donor> findByBloodGroupAndCity(String bloodGroup, String city);
}
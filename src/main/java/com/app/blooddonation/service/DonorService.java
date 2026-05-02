package com.app.blooddonation.service;

import com.app.blooddonation.model.Donor;
import com.app.blooddonation.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonorService {

    @Autowired
    private DonorRepository donorRepository;

    public Donor saveDonor(Donor donor) {
        if (donor == null) {
            throw new IllegalArgumentException("Donor cannot be null");
        }
        return donorRepository.save(donor);
    }

    public List<Donor> findMatching(String bloodGroup, String city) {
        return donorRepository.findByBloodGroupAndCity(bloodGroup, city);
    }
}
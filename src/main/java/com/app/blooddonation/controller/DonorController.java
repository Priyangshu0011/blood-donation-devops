package com.app.blooddonation.controller;

import com.app.blooddonation.model.Donor;
import com.app.blooddonation.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class DonorController {

    @Autowired
    private DonorService donorService;

    @PostMapping("/donor")
    public Donor addDonor(@RequestBody Donor donor) {
        return donorService.saveDonor(donor);
    }

    @GetMapping("/match")
    public List<Donor> getMatchingDonors(@RequestParam String blood, @RequestParam String city) {
        // If '+' is passed in the URL unencoded (e.g., ?blood=A+), Spring will interpret it as a space.
        // This converts any spaces back to '+' so the database query matches correctly.
        String actualBlood = blood.replace(" ", "+");
        return donorService.findMatching(actualBlood, city);
    }
}
package com.app.blooddonation.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "donors")
public class Donor {

    @Id
    private String id;
    private String name;
    private String bloodGroup;
    private String city;

    public Donor() {
    }

    public Donor(String name, String bloodGroup, String city) {
        this.name = name;
        this.bloodGroup = bloodGroup;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
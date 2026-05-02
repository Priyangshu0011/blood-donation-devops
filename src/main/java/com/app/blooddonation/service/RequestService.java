package com.app.blooddonation.service;

import com.app.blooddonation.model.Request;
import com.app.blooddonation.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    public Request saveRequest(Request request) {
        request.setStatus("PENDING");
        return requestRepository.save(request);
    }
}

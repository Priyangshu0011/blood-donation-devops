package com.app.blooddonation.controller;

import com.app.blooddonation.model.Request;
import com.app.blooddonation.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @PostMapping("/request")
    public Request createRequest(@RequestBody Request request) {
        return requestService.saveRequest(request);
    }

    @GetMapping("/test")
    public String test() {
        return "Working";
    }
}

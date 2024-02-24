package com.example.cloudhuman.controller;

import com.example.cloudhuman.models.Pro;
import com.example.cloudhuman.services.ProService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pro")
public class ProController {

    @Autowired
    private ProService service;

    @Autowired
    private ObjectMapper mapper;

    @PostMapping(value = "/validate")
    public ResponseEntity<String> evaluate(@RequestBody String json) throws Exception {
        Pro pro =  mapper.readValue(json, Pro.class);
        String response = service.assignProjectByScore(pro);
        return ResponseEntity.ok(response);
    }
}

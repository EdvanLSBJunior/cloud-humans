package com.example.cloudhuman.controller;

import com.example.cloudhuman.dto.ProDTO;
import com.example.cloudhuman.models.Pro;
import com.example.cloudhuman.services.ProjectAssignmentService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pro")
public class ProController {

    @Autowired
    private ProjectAssignmentService service;

    @PostMapping(value = "/validate")
    public ResponseEntity<Response> evaluate(@RequestBody Pro pro) throws Exception {
        Response response = service.evaluate(pro);
        return ResponseEntity.ok(response);
    }
}

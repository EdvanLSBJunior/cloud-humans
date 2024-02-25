package com.example.cloudhuman.controller;

import com.example.cloudhuman.exceptions.InvalidWritingScoreException;
import com.example.cloudhuman.models.Pro;
import com.example.cloudhuman.services.ProService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pro")
@Tag(name = "pro")
public class ProController {

    @Autowired
    private ProService service;

    @Operation(summary = "Verify indicate best project for pro" , method="POST")
    @PostMapping(value = "/validate")
    public ResponseEntity<String> evaluate(@Valid @RequestBody Pro pro, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getFieldError().getDefaultMessage());
        }

        try {
            String response = service.assignProjectByScore(pro);
            return ResponseEntity.ok(response);

        } catch (InvalidWritingScoreException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

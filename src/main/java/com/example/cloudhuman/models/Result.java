package com.example.cloudhuman.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private int score;
    private String selectedProject;
    private List<String> eligibleProjects;
    private List<String> ineligibleProjects;
}

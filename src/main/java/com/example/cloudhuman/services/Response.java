package com.example.cloudhuman.services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private int score;
    private String selectedProject;
    private List<String> eligibleProjects;
    private List<String> ineligibleProjects;

    @Override
    public String toString() {
        return "{" +
                "score=" + score +
                ", selectedProject='" + selectedProject + '\'' +
                ", eligibleProjects=" + eligibleProjects +
                ", ineligibleProjects=" + ineligibleProjects +
                '}';
    }
}

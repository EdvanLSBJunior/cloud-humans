package com.example.cloudhuman.services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ResponseHandler {
    private int score;
    private String selectedProject;
    private List<String> eligibleProjects;
    private List<String> ineligibleProjects;

    public ResponseHandler(int score, String selectedProject, List<String> eligibleProjects, List<String> ineligibleProjects) {
        this.score = score;
        this.selectedProject = selectedProject;
        this.eligibleProjects = eligibleProjects;
        this.ineligibleProjects = ineligibleProjects;
    }

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

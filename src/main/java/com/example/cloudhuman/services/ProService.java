package com.example.cloudhuman.services;

import com.example.cloudhuman.enums.Projects;
import com.example.cloudhuman.exceptions.ProIneligibleException;
import com.example.cloudhuman.models.Pro;
import com.example.cloudhuman.models.Project;
import com.example.cloudhuman.utils.UtilityRules;
import com.example.cloudhuman.services.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
//import org.apache.catalina.connector.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProService {

    private ObjectMapper mapper = new ObjectMapper();
    private List<Map<String, Object>> projects;
    @PostConstruct
    public void init() throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream("/projects.json");
        projects = mapper.readValue(inputStream, new TypeReference<List<Map<String, Object>>>(){});
    }

    public String assignProjectByScore(Pro pro) throws JsonProcessingException {
        if (!UtilityRules.isEligible(pro)) {
            throw new ProIneligibleException("Pro não é elegível devido à idade");
        }

        int score = 0;

        score += UtilityRules.calculateEducationPoints(pro.getEducationLevel());
        score += UtilityRules.calculateExperiencePoints(pro.getPastExperiences());
        score += UtilityRules.calculatePointsForInternetSpeed(pro.getInternetTest());
        score += UtilityRules.calculatePointsOfWriting(pro.getWritingScore());
        score += UtilityRules.calculatePointsForReferralCode(pro.getReferralCode());

        Project criticalProject = getCriticalProject(score);

        List<String> eligibleProjects = new ArrayList<>();
        List<String> ineligibleProjects = new ArrayList<>();

        for (Map<String, Object> project : projects) {
            int minScore = (int) project.get("minScore");
            if (score >= minScore) {
                eligibleProjects.add((String) project.get("name"));
            } else {
                ineligibleProjects.add((String) project.get("name"));
            }
        }

        Response response = new Response(
                score,
                criticalProject.getName(),
                eligibleProjects,
                ineligibleProjects
        );
//        System.out.println(response);
        return mapper.writeValueAsString(response);
//        return response.toString();
    }

    private Project getCriticalProject(int score) {
        for (Map<String, Object> project : projects) {
            int minScore = (int) project.get("minScore");
            if (score >= minScore) {
                String name = (String) project.get("name");
                return new Project(name, minScore);
            }
        }
        return null;
    }
}

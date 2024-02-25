package com.example.cloudhuman.services;

import com.example.cloudhuman.exceptions.InvalidWritingScoreException;
import com.example.cloudhuman.exceptions.ProIneligibleException;
import com.example.cloudhuman.models.Pro;
import com.example.cloudhuman.models.Project;
import com.example.cloudhuman.utils.UtilityRules;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
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

    public ProService(List<Map<String, Object>> projects) {
        this.projects = projects;
    }

    @PostConstruct
    public void init() throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream("/projects.json");
        projects = mapper.readValue(inputStream, new TypeReference<List<Map<String, Object>>>(){});
    }

    public String assignProjectByScore(Pro pro) throws JsonProcessingException {
        this.validateFieldWritingScore(pro);
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
        ResponseHandler response = new ResponseHandler(
                score,
                criticalProject.getName(),
                eligibleProjects,
                ineligibleProjects
        );
        return mapper.writeValueAsString(response);
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

    private String validateFieldWritingScore(Pro pro) {
        float writingScore = pro.getWritingScore();
        if (writingScore < 0 || writingScore > 1) {
            throw new InvalidWritingScoreException("writing_score must be between 0 and 1");
        }
        return null;
    }
}

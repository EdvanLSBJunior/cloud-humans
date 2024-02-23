package com.example.cloudhuman.services;

import com.example.cloudhuman.exceptions.ProIneligibleException;
import com.example.cloudhuman.models.Pro;
import com.example.cloudhuman.rules.AgeRule;
import com.example.cloudhuman.interfaces.utility.Utility;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectAssignmentService extends AgeRule {

    @Autowired
    private AgeRule ageRule;

    public Response evaluate(Pro pro) {
        if (!ageRule.isEligible(pro)) {
            throw new ProIneligibleException("Pro não é elegível devido à idade");
        }
        int score = 0;

        score += Utility.calculateEducationPoints(pro.getEducationLevel());
        score += Utility.calculateExperiencePoints(pro.getPastExperiences());

        return new Response(score);
    }
}

package com.example.cloudhuman.rules;

import com.example.cloudhuman.interfaces.rules.EligibilityRule;
import com.example.cloudhuman.models.Pro;

public class AgeRule implements EligibilityRule {

    @Override
    public boolean isEligible(Pro pro) {
        return pro.getAge() >= 18;
    }
}

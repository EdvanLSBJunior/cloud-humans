package com.example.cloudhuman.interfaces.rules;

import com.example.cloudhuman.models.Pro;

public interface EligibilityRule {
    boolean isEligible(Pro pro);
}

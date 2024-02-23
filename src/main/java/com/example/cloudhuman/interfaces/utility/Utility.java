package com.example.cloudhuman.interfaces.utility;

import com.example.cloudhuman.enums.EducationLevel;
import com.example.cloudhuman.models.InternetTest;
import com.example.cloudhuman.models.PastExperiences;
import com.example.cloudhuman.models.Pro;

public class Utility {
    public static int calculateEducationPoints(EducationLevel level) {
        int points = 0;
        if ("high_school".equals(level)) {
            points += 5;
        } else if ("bachelors_degree_or_high".equals(level)) {
            points += 3;
        }
        return points;
    }

    public static int calculateExperiencePoints(PastExperiences pastExperiences) {
        int points = 0;
        if (pastExperiences.isSales()) {
            points += 5;
        }
        if (pastExperiences.isSupport()) {
            points += 3;
        }
        return points;
    }

    public static int calculatePointsForInternetSpeed(InternetTest internetTest) {
        int points = 0;
        if (internetTest.getDownloadSpeed() > 50) {
            points++;
        } else if (internetTest.getDownloadSpeed() < 5) {
            points--;
        }

        if (internetTest.getUploadSpeed() > 50) {
            points++;
        } else if (internetTest.getUploadSpeed() < 5) {
            points--;
        }

        return points;
    }

    public static int calculatePointsOfWriting(Pro pro) {
        int points = 0;
        if (pro.getWritingScore() > 0.7) {
            points += 2;
        } else if (pro.getWritingScore() >= 0.3 && pro.getWritingScore() <= 0.7) {
            points++;
        } else if (pro.getWritingScore() < 0.3) {
            points--;
        }
        return points;
    }

    public static boolean validateReferralCode(String code) {
        return "token1234".equals(code);
    }

    public static int claculatePointsForReferralCode(Pro pro) {
        if (validateReferralCode(pro.getReferralCode())) {
            return 1;
        }
        return 0;
    }
}

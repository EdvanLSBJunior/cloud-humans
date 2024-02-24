package com.example.cloudhuman.utils;

import com.example.cloudhuman.models.EducationLevel;
import com.example.cloudhuman.models.InternetTest;
import com.example.cloudhuman.models.PastExperiences;
import com.example.cloudhuman.models.Pro;

public class UtilityRules {

    public static boolean isEligible(Pro pro) {
        return pro.getAge() >= 18;
    }

//    public static int calculateEducationPoints(EducationLevel level) {
//        int points = 0;
//        if ("highSchool".equals(level)) {
//            points += 1;
//        } else if ("bachelors_degree_or_high".equals(level)) {
//            points += 2;
//        }
//        return points;
//    }
public static int calculateEducationPoints(EducationLevel educationLevel) {
    int points = 0;

    if (educationLevel.isNoEducation()) {
        points = 0;
    } else if (educationLevel.isHighSchool()) {
        points = 1;
    } else if (educationLevel.isBachelorsDegreeOrHigh()) {
        points = 2;
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

    public static int calculatePointsOfWriting(float writingScore) {
        int points = 0;
        if (writingScore > 0.7) {
            points += 2;
        } else if (writingScore >= 0.3 && writingScore <= 0.7) {
            points++;
        } else if (writingScore < 0.3) {
            points--;
        }
        return points;
    }

    public static boolean validateReferralCode(String code) {
        return "token1234".equals(code);
    }

    public static int calculatePointsForReferralCode(String referralCode) {
        if (validateReferralCode(referralCode)) {
            return 1;
        }
        return 0;
    }
}

package com.example.cloudhuman.utils;

import com.example.cloudhuman.models.EducationLevel;
import com.example.cloudhuman.models.InternetTest;
import com.example.cloudhuman.models.PastExperiences;
import com.example.cloudhuman.models.Pro;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import static com.example.cloudhuman.utils.UtilityRules.*;
import static org.junit.jupiter.api.Assertions.*;

public class UtilityRulesTest {

    @InjectMocks
    private InternetTest internetTest;

    @Test
    public void testIsEligible_ValidAge() {
        Pro pro = new Pro();
        pro.setAge(18);

        boolean isEligible = isEligible(pro);

        assertTrue(isEligible);
    }

    @Test
    public void testIsEligible_InvalidAge() {
        Pro pro = new Pro();
        pro.setAge(17);

        boolean isEligible = isEligible(pro);

        assertFalse(isEligible);
    }

    @Test
    public void testCalculateEducationPoints_HighSchool() {
        EducationLevel mockEducationLevel = Mockito.mock(EducationLevel.class);
        Mockito.when(mockEducationLevel.isHighSchool()).thenReturn(true);
        Pro pro = new Pro();
        pro.setEducationLevel(mockEducationLevel);

        int points = calculateEducationPoints(pro.getEducationLevel());

        assertEquals(1, points);
    }

    @Test
    public void testCalculateEducationPoints_BachelorsDegreeOrHigh() {
        EducationLevel mockEducationLevel = Mockito.mock(EducationLevel.class);
        Mockito.when(mockEducationLevel.isBachelorsDegreeOrHigh()).thenReturn(true);
        Pro pro = new Pro();
        pro.setEducationLevel(mockEducationLevel);

        int points = calculateEducationPoints(pro.getEducationLevel());

        assertEquals(2, points);
    }

    @Test
    public void testCalculateEducationPoints_NoEducationLevel() {
        EducationLevel mockEducationLevel = Mockito.mock(EducationLevel.class);
        Mockito.when(mockEducationLevel.isNoEducation()).thenReturn(true);
        Pro pro = new Pro();
        pro.setEducationLevel(mockEducationLevel);

        int points = calculateEducationPoints(pro.getEducationLevel());

        assertEquals(0, points);
    }

    @Test
    public void testCalculateExperiencePoints_Sales() {
        PastExperiences pastExperiences = Mockito.mock(PastExperiences.class);
        Mockito.when(pastExperiences.isSales()).thenReturn(true);
        Mockito.when(pastExperiences.isSupport()).thenReturn(false);

        int points = calculateExperiencePoints(pastExperiences);

        assertEquals(5, points);
    }

    @Test
    public void testCalculateExperiencePoints_Support() {
        PastExperiences pastExperiences = Mockito.mock(PastExperiences.class);
        Mockito.when(pastExperiences.isSales()).thenReturn(false);
        Mockito.when(pastExperiences.isSupport()).thenReturn(true);

        int points = calculateExperiencePoints(pastExperiences);

        assertEquals(3, points);
    }

    @Test
    public void testCalculateExperiencePoints_SalesAndSupport() {
        PastExperiences pastExperiences = Mockito.mock(PastExperiences.class);
        Mockito.when(pastExperiences.isSales()).thenReturn(true);
        Mockito.when(pastExperiences.isSupport()).thenReturn(true);

        int points = calculateExperiencePoints(pastExperiences);

        assertEquals(8, points);
    }

    @Test
    public void testCalculatePointsForInternetSpeed() {
        // Test case 1: Download speed > 50
        InternetTest internetTest1 = new InternetTest(60, 20);
        int expectedPoints1 = 1;
        int actualPoints1 = calculatePointsForInternetSpeed(internetTest1);
        assertEquals(expectedPoints1, actualPoints1);

        // Test case 2: Download speed < 5
        InternetTest internetTest2 = new InternetTest(2, 30);
        int expectedPoints2 = -1;
        int actualPoints2 = calculatePointsForInternetSpeed(internetTest2);
        assertEquals(expectedPoints2, actualPoints2);

        // Test case 3: Upload speed > 50
        InternetTest internetTest3 = new InternetTest(20, 60);
        int expectedPoints3 = 1;
        int actualPoints3 = calculatePointsForInternetSpeed(internetTest3);
        assertEquals(expectedPoints3, actualPoints3);

        // Test case 4: Upload speed < 5
        InternetTest internetTest4 = new InternetTest(30, 2);
        int expectedPoints4 = -1;
        int actualPoints4 = calculatePointsForInternetSpeed(internetTest4);
        assertEquals(expectedPoints4, actualPoints4);
    }

    @Test
    public void testCalculatePointsOfWriting() {
        // Test case 1: Writing score > 0.7
        float writingScore1 = 0.8f;
        int expectedPoints1 = 2;
        int actualPoints1 = calculatePointsOfWriting(writingScore1);
        assertEquals(expectedPoints1, actualPoints1);

        // Test case 2: Writing score between 0.3 and 0.7
        float writingScore2 = 0.5f;
        int expectedPoints2 = 1;
        int actualPoints2 = calculatePointsOfWriting(writingScore2);
        assertEquals(expectedPoints2, actualPoints2);

        // Test case 3: Writing score < 0.3
        float writingScore3 = 0.2f;
        int expectedPoints3 = -1;
        int actualPoints3 = calculatePointsOfWriting(writingScore3);
        assertEquals(expectedPoints3, actualPoints3);

        // Test case 4: Writing score equal 0.7
        float writingScore4 = 0.7f;
        int expectedPoints4 = 1;
        int actualPoints4 = calculatePointsOfWriting(writingScore4);
        assertEquals(expectedPoints4, actualPoints4);

        // Test case 5: Writing score equal 0.3
        float writingScore5 = 0.3f;
        int expectedPoints5 = 1;
        int actualPoints5 = calculatePointsOfWriting(writingScore5);
        assertEquals(expectedPoints5, actualPoints5);
    }

    @Test
    public void testValidateReferralCode() {
        // Test with valid code
        String validCode = "token1234";
        assertTrue(validateReferralCode(validCode));

        // Test with invalid code
        String invalidCode = "invalid_code";
        assertFalse(validateReferralCode(invalidCode));

        // Test with null code
        String nullCode = null;
        assertFalse(validateReferralCode(nullCode));

        // Test with empty code
        String emptyCode = "";
        assertFalse(validateReferralCode(emptyCode));
    }

    @Test
    public void testCalculatePointsForReferralCode() {
        // Test with valid code
        String validCode = "token1234";
        int expectedPoints1 = 1;
        int actualPoints1 = calculatePointsForReferralCode(validCode);
        assertEquals(expectedPoints1, actualPoints1);

        // Test with invalid code
        String invalidCode = "invalid_code";
        int expectedPoints2 = 0;
        int actualPoints2 = calculatePointsForReferralCode(invalidCode);
        assertEquals(expectedPoints2, actualPoints2);

        // Test with null code
        String nullCode = null;
        int expectedPoints3 = 0;
        int actualPoints3 = calculatePointsForReferralCode(nullCode);
        assertEquals(expectedPoints3, actualPoints3);

        // Test with empty code
        String emptyCode = "";
        int expectedPoints4 = 0;
        int actualPoints4 = calculatePointsForReferralCode(emptyCode);
        assertEquals(expectedPoints4, actualPoints4);
    }
}

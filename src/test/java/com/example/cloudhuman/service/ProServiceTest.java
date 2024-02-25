package com.example.cloudhuman.service;

import com.example.cloudhuman.models.EducationLevel;
import com.example.cloudhuman.models.InternetTest;
import com.example.cloudhuman.models.PastExperiences;
import com.example.cloudhuman.models.Pro;
import com.example.cloudhuman.services.ProService;
import com.example.cloudhuman.services.ResponseHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ProServiceTest {

    ObjectMapper mapper = new ObjectMapper();
    InputStream inputStream = this.getClass().getResourceAsStream("/projects.json");
    List<Map<String, Object>> projects = mapper.readValue(inputStream, new TypeReference<List<Map<String, Object>>>() {});

    ProService proService = new ProService(projects);

    public ProServiceTest() throws IOException {
    }

    @Test
    public void testAssignProjectByScore_HighScore() throws JsonProcessingException {

        EducationLevel mockEducationLevel = Mockito.mock(EducationLevel.class);
        when(mockEducationLevel.isBachelorsDegreeOrHigh()).thenReturn(true);
        PastExperiences mockPastExperiences = Mockito.mock(PastExperiences.class);
        when(mockPastExperiences.isSales()).thenReturn(true);

        Pro pro = new Pro();
        pro.setAge(30);
        pro.setEducationLevel(mockEducationLevel);
        pro.setPastExperiences(mockPastExperiences);
        pro.setInternetTest(new InternetTest(55, 55));
        pro.setWritingScore(0.8f);
        pro.setReferralCode("token1234");

        ObjectMapper mapper = new ObjectMapper();

        ResponseHandler expectedResponse = new ResponseHandler(
                11,
                "calculate_dark_matter_nasa",
                List.of("calculate_dark_matter_nasa","determine_schrodinger_cat_is_alive","support_users_from_xyz","collect_information_for_xpto"),
                List.of());
        String expectedJson = mapper.writeValueAsString(expectedResponse);

        ProService mockProService = Mockito.mock(ProService.class);
        Mockito.when(mockProService.assignProjectByScore(pro)).thenReturn(String.valueOf(expectedResponse));

        String response = proService.assignProjectByScore(pro);

        assertEquals(expectedJson, response);
    }
}

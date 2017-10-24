package com.experimental.openmrs;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OpenMRS {

    private static final String PATIENT_SEARCH_TEMPLATE = "%s/ws/rest/v1/patient?identifier=%s";

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private String uri;
    private String user;
    private String password;

    public OpenMRS(String uri, String user, String password) {
        this.uri = uri;
        this.user = user;
        this.password = password;
    }

    public List<Patient> findPatients(String nameOrId) {
        try {
            HttpResponse<JsonNode> response = Unirest
                    .get(buildUri(PATIENT_SEARCH_TEMPLATE, this.uri, nameOrId))
                    .basicAuth(this.user, this.password)
                    .asJson();
            return parsePatientListResponse(response);
        } catch (UnirestException e) {
            throw new RuntimeException("Error on attempt to request patient search results", e);
        }
    }

    private static List<Patient> parsePatientListResponse(HttpResponse<JsonNode> response) {
        try {
            String responseBody = response.getBody().getObject().get("results").toString();
            Patient[] patients = OBJECT_MAPPER.readValue(responseBody, Patient[].class);
            return new ArrayList<>(Arrays.asList(patients));
        } catch (IOException e) {
            throw new RuntimeException("Could not parse response with patient list.", e);
        }
    }

    private static String buildUri(String template, Object... params) {
        return String.format(template, params);
    }
}

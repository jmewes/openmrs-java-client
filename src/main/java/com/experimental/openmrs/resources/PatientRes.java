package com.experimental.openmrs.resources;

import com.experimental.openmrs.OpenMRS;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PatientRes extends RestResource {

    private static final String PATIENT_SEARCH_TEMPLATE = "/v1/patient?identifier=%s";

    public PatientRes(OpenMRS openMRS) {
        super(openMRS);
    }

    public List<com.experimental.openmrs.Patient> findByNameOrId(String nameOrId) {
        return parsePatientListResponse(openMRS.get(PATIENT_SEARCH_TEMPLATE, nameOrId));
    }

    private static List<com.experimental.openmrs.Patient> parsePatientListResponse(HttpResponse<JsonNode> response) {
        try {
            String resultsArray = response.getBody().getObject().get("results").toString();
            com.experimental.openmrs.Patient[] patients = OpenMRS.objectMapper.readValue(resultsArray, com.experimental.openmrs.Patient[].class);
            return new ArrayList<>(Arrays.asList(patients));
        } catch (IOException e) {
            throw new RuntimeException("Could not parse response with patient list.", e);
        }
    }
}

package com.experimental.openmrs.resources;

import com.experimental.openmrs.OpenMRS;
import com.experimental.openmrs.Patient;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestResource {

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    protected final OpenMRS openMRS;

    public RestResource(OpenMRS openMRS) {
        this.openMRS = openMRS;
    }

    protected List<Patient> parsePatientListResponse(HttpResponse<JsonNode> response) {
        try {
            String resultsArray = response.getBody().getObject().get("results").toString();
            Patient[] patients = OpenMRS.objectMapper.readValue(resultsArray, Patient[].class);
            return new ArrayList<>(Arrays.asList(patients));
        } catch (IOException e) {
            throw new RuntimeException("Could not parse response with patient list.", e);
        }
    }

    protected Patient parsePatient(HttpResponse<JsonNode> response) {
        try {
            String patientJsonText = response.getBody().getObject().get("patient").toString();
            return OpenMRS.objectMapper.readValue(patientJsonText, Patient.class);
        } catch (IOException e) {
            throw new RuntimeException("Could not parse response patient list.", e);
        }
    }
}

package com.experimental.openmrs;

import com.experimental.openmrs.resources.PatientProfilResource;
import com.experimental.openmrs.resources.PatientResource;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class OpenMRS {

    public static final ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private String restBaseUrl;
    private String user;
    private String password;

    public OpenMRS(String openMRSUrl, String user, String password) {
        this.restBaseUrl = openMRSUrl + "/ws/rest";
        this.user = user;
        this.password = password;
    }

    public PatientResource patient() {
        return new PatientResource(this);
    }

    public PatientProfilResource patientProfile() {
        return new PatientProfilResource(this);
    }

    public HttpResponse<JsonNode> get(String resource, String... parameters) {
        try {
            HttpResponse<JsonNode> response = Unirest
                    .get(buildUri(resource, parameters))
                    .basicAuth(this.user, this.password)
                    .asJson();
            return response;
        } catch (UnirestException e) {
            throw new RuntimeException("Error on attempt to do GET request on " + buildUri(resource, parameters), e);
        }
    }

    public HttpResponse<JsonNode> post(String resource, String requestBody) {
        try {
            HttpResponse response = Unirest
                    .post(buildUri(resource))
                    .header("Content-Type", "application/json")
                    .basicAuth(this.user, this.password)
                    .body(new JsonNode(requestBody))
                    .asJson();
            return response;
        } catch (UnirestException e) {
            throw new RuntimeException("Error on attempt to do POST request on " + buildUri(resource), e);
        }
    }

    private String buildUri(String resource, Object... parameters) {
        return String.format(restBaseUrl + resource, parameters);
    }
}

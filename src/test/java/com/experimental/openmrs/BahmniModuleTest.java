package com.experimental.openmrs;

import com.mashape.unirest.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class BahmniModuleTest {

    @Test
    public void should_still_support_standard_api() {

        // GIVEN
        String uri = "https://ksch/openmrs";
        String user = "superman";
        String password = "Admin123";

        // WHEN
        OpenMRSBahmniImpl openMRSBahmniImpl = new OpenMRSBahmniImpl(uri, user, password);
        List<Patient> patients = openMRSBahmniImpl.patient().findByNameOrId("John");

        // THEN
        assertTrue(patients.size() > 0);
    }

    @Test
    public void should_create_patient_via_bahmni_module() {

        // GIVEN
        String uri = "https://ksch/openmrs";
        String user = "superman";
        String password = "Admin123";

        // WHEN
        OpenMRSBahmniImpl openMRSBahmniImpl = new OpenMRSBahmniImpl(uri, user, password);
        HttpResponse response = openMRSBahmniImpl.patientProfile().createPatient();

        // THEN
        Assert.assertEquals(response.getBody().toString().substring(0, 300), response.getStatus(), 200);
    }
}

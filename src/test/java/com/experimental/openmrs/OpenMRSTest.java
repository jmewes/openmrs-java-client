package com.experimental.openmrs;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;


public class OpenMRSTest {

    @Test
    public void should_find_patients() {

        // GIVEN
        String uri = "http://139.59.130.211:8081/openmrs-standalone";
        String user = "admin";
        String password = "test";

        // WHEN
        OpenMRS openMRS = new OpenMRS(uri, user, password);
        List<OpenMRSPatient> patients = openMRS.findPatients("John");

        // THEN
        assertTrue(patients.size() > 0);
    }
}

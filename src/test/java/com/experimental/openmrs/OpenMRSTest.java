package com.experimental.openmrs;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;


public class OpenMRSTest {

    @Test
    public void should_find_patients() {

        // GIVEN
        String uri = "https://ksch/openmrs";
        String user = "superman";
        String password = "Admin123";

        // WHEN
        OpenMRS openMRS = new OpenMRS(uri, user, password);
        List<Patient> patients = openMRS.findPatients("Jan");

        // THEN
        assertTrue(patients.size() > 0);
    }
}

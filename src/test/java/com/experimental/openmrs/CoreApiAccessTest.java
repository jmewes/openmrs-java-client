package com.experimental.openmrs;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class CoreApiAccessTest {

    @Test
    public void should_find_patients() {

        // GIVEN
        String uri = "https://ksch/openmrs";
        String user = "superman";
        String password = "Admin123";

        // WHEN
        OpenMRS openMRS = new OpenMRS(uri, user, password);
        List<Patient> patients = openMRS.patient().findByNameOrId("John");

        // THEN
        assertTrue(patients.size() > 0);
    }
}

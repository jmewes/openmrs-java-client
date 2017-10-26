package com.experimental.openmrs;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class CoreApiAccessTest {

    private OpenMRS openMRS;

    @Before
    public void setup() {
        String openmrsBaseUrl = System.getenv("OPENMRS_BASE_URL");
        String openmrsUserName = System.getenv("OPENMRS_USER_NAME");
        String openmrsUserPassword = System.getenv("OPENMRS_USER_PASSWORD");

        openMRS = new OpenMRS(
                checkNotNull(openmrsBaseUrl),
                checkNotNull(openmrsUserName),
                checkNotNull(openmrsUserPassword));
    }

    @Test
    public void should_find_patients() {

        // GIVEN
        // - Patient with name "Joe Doe" has been created manually (FIXME)

        // WHEN
        List<Patient> patients = openMRS.patient().findByNameOrId("John");

        // THEN
        assertTrue(patients.size() > 0);
    }

    private String checkNotNull(String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        return s;
    }
}

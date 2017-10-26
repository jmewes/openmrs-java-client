package org.test.hospital;

import org.junit.Before;
import org.test.hospital.impl.bahmnicore.CustomizedOpenMRSImpl;
import com.experimental.openmrs.Patient;
import org.junit.Test;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ApiExtensionTest {

    private CustomizedOpenMRSImpl openMRS;

    @Before
    public void setup() {
        String openmrsBaseUrl = System.getenv("OPENMRS_BASE_URL");
        String openmrsUserName = System.getenv("OPENMRS_USER_NAME");
        String openmrsUserPassword = System.getenv("OPENMRS_USER_PASSWORD");

        openMRS = new CustomizedOpenMRSImpl(
                checkNotNull(openmrsBaseUrl),
                checkNotNull(openmrsUserName),
                checkNotNull(openmrsUserPassword));
    }

    @Test
    public void should_still_support_standard_api() {

        // GIVEN
        // - Patient with name "Joe Doe" has been created manually (FIXME)

        // WHEN
        List<Patient> patients = openMRS.patient().findByNameOrId("Joe");

        // THEN
        assertTrue(patients.size() > 0);
    }

    @Test
    public void should_create_patient_via_bahmni_module() {

        // GIVEN
        String patientFirstName = randomAlienName(5);
        String patientLastName = randomAlienName(11);

        // WHEN
        Patient createdPatient = openMRS.patientProfile().createPatient(patientFirstName, patientLastName);

        // THEN
        assertEquals(String.format("%s %s", patientFirstName, patientLastName),
                createdPatient.getPerson().getPreferredName().getDisplay());
    }

    private String randomAlienName(int numberOfCharacters) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Random oracle = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append("E");
        for (int i = 0; i < numberOfCharacters - 1; i++) {
            int randIndex = oracle.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(randIndex);
            sb.append(randomChar);
        }
        return sb.toString();
    }

    private String checkNotNull(String s) {
        if (s == null) {
            throw new NullPointerException();
        }
        return s;
    }
}

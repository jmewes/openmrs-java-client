package org.test.hospital;

import org.test.hospital.impl.bahmnicore.CustomizedOpenMRSImpl;
import com.experimental.openmrs.Patient;
import org.junit.Test;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ApiExtensionTest {

    @Test
    public void should_still_support_standard_api() {

        // GIVEN
        String uri = "https://ksch/openmrs";
        String user = "superman";
        String password = "Admin123";

        // WHEN
        CustomizedOpenMRSImpl customizedOpenMRSImpl = new CustomizedOpenMRSImpl(uri, user, password);
        List<Patient> patients = customizedOpenMRSImpl.patient().findByNameOrId("John");

        // THEN
        assertTrue(patients.size() > 0);
    }

    @Test
    public void should_create_patient_via_bahmni_module() {

        // GIVEN
        String uri = "https://ksch/openmrs";
        String user = "superman";
        String password = "Admin123";
        String patientFirstName = randomAlienName(5);
        String patientLastName = randomAlienName(11);

        // WHEN
        CustomizedOpenMRSImpl customizedOpenMRSImpl = new CustomizedOpenMRSImpl(uri, user, password);
        Patient createdPatient = customizedOpenMRSImpl.patientProfile().createPatient(patientFirstName, patientLastName);

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
}

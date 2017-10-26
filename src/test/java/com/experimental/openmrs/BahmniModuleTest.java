package com.experimental.openmrs;

import com.mashape.unirest.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
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
        String patientFirstName = randomAlienName(5);
        String patientLastName = randomAlienName(11);

        // WHEN
        OpenMRSBahmniImpl openMRSBahmniImpl = new OpenMRSBahmniImpl(uri, user, password);
        Patient createdPatient = openMRSBahmniImpl.patientProfile().createPatient(patientFirstName, patientLastName);

        // THEN
        assertEquals(String.format("%s %s", patientFirstName, patientLastName),
                createdPatient.getPerson().getPreferredName().getDisplay());
    }

    private String randomAlienName(int numberOfCharacters) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Random oracle = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfCharacters; i++) {
            int randIndex = oracle.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(randIndex);
            if (i == 0) {
                randomChar = Character.toUpperCase(randomChar);
            }
            sb.append(randomChar);
        }
        return sb.toString();
    }
}

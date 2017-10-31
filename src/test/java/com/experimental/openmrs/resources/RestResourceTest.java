package com.experimental.openmrs.resources;

import com.experimental.openmrs.Patient;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RestResourceTest {

    @Test
    public void should_parse_patient_search_results() throws IOException {

        // GIVEN
        RestResource restResource = new RestResource(null);
        String patientSearchResultArray = slurpResourceFile("patient-search-result.json");

        // WHEN
        List<Patient> parsedPatients = restResource.toPatientList(patientSearchResultArray);

        // THEN
        assertEquals("Could not parse the expected number of patients", 2, parsedPatients.size());
        assertEquals("Could not parse display text for patient", "GAN203007 - John Doe", parsedPatients.get(0).toString());
    }

    private static String slurpResourceFile(String resourcePath) {
        try {
            byte[] encoded = Files.readAllBytes(getResourceAsFile("patient-search-result.json").toPath());
            return new String(encoded);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static File getResourceAsFile(String resourcePath) {
        URL resourceUrl = Thread.currentThread().getContextClassLoader().getResource(resourcePath);
        try {
            return new File(resourceUrl.toURI());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}

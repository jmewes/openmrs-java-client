package com.experimental.openmrs.resources;

import com.experimental.openmrs.OpenMRS;
import com.experimental.openmrs.Patient;

import java.util.List;

public class PatientResource extends RestResource {

    private static final String PATIENT_SEARCH_TEMPLATE = "/v1/patient?identifier=%s";

    public PatientResource(OpenMRS openMRS) {
        super(openMRS);
    }

    public List<Patient> findByNameOrId(String nameOrId) {
        return parsePatientListResponse(openMRS.get(PATIENT_SEARCH_TEMPLATE, nameOrId));
    }
}

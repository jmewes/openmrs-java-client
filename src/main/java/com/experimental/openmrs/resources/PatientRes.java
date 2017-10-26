package com.experimental.openmrs.resources;

import com.experimental.openmrs.OpenMRS;

import java.util.List;

public class PatientRes extends RestResource {

    private static final String PATIENT_SEARCH_TEMPLATE = "/v1/patient?identifier=%s";

    public PatientRes(OpenMRS openMRS) {
        super(openMRS);
    }

    public List<com.experimental.openmrs.Patient> findByNameOrId(String nameOrId) {
        return parsePatientListResponse(openMRS.get(PATIENT_SEARCH_TEMPLATE, nameOrId));
    }
}

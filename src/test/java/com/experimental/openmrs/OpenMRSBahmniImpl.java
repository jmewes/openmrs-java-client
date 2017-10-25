package com.experimental.openmrs;

import com.experimental.openmrs.bahmnicore.BahmniPatientProfile;

public class OpenMRSBahmniImpl extends OpenMRS {

    public OpenMRSBahmniImpl(String baseUrl, String user, String password) {
        super(baseUrl, user, password);
    }

    @Override
    public BahmniPatientProfile patientProfile() {
        return new BahmniPatientProfile(this);
    }
}

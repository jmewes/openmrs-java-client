package org.test.hospital.impl.bahmnicore;

import com.experimental.openmrs.OpenMRS;

public class CustomizedOpenMRSImpl extends OpenMRS {

    public CustomizedOpenMRSImpl(String baseUrl, String user, String password) {
        super(baseUrl, user, password);
    }

    @Override
    public PatientProfileResource patientProfile() {
        return new PatientProfileResource(this);
    }
}

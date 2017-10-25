package com.experimental.openmrs.resources;

import com.experimental.openmrs.OpenMRS;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestResource {

    protected static final ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    protected final OpenMRS openMRS;

    public RestResource(OpenMRS openMRS) {
        this.openMRS = openMRS;
    }

    //public JSONO
}

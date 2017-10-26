package com.experimental.openmrs.bahmnicore;

import com.experimental.openmrs.OpenMRSBahmniImpl;
import com.experimental.openmrs.Patient;
import com.experimental.openmrs.resources.PatientProfil;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public class BahmniPatientProfile extends PatientProfil {

    public BahmniPatientProfile(OpenMRSBahmniImpl openMRSBahmniImpl) {
        super(openMRSBahmniImpl);
    }

    public Patient createPatient(String firstName, String lastName) {

        String displayName = String.format("%s %s", firstName, lastName);

        //language=JSON
        String json = String.format("{\n" +
                "  \"patient\":{\n" +
                "    \"person\":{\n" +
                "      \"names\":[\n" +
                "        {\n" +
                "          \"givenName\":\"%s\",\n" +
                "          \"familyName\":\"%s\",\n" +
                "          \"display\":\"%s\",\n" +
                "          \"preferred\":false\n" +
                "        }\n" +
                "      ],\n" +
                "      \"addresses\":[\n" +
                "        {\n" +
                "          \"cityVillage\":\"KS\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"birthdate\":\"2010-10-25T17:23:26.431+0200\",\n" +
                "      \"gender\":\"F\",\n" +
                "      \"birthtime\":null,\n" +
                "      \"attributes\":[\n" +
                "        {\n" +
                "          \"attributeType\":{\n" +
                "            \"uuid\":\"82325788-3f10-11e4-adec-0800271c1b75\"\n" +
                "          },\n" +
                "          \"voided\":true\n" +
                "        },\n" +
                "        {\n" +
                "          \"attributeType\":{\n" +
                "            \"uuid\":\"8233a58a-3f10-11e4-adec-0800271c1b75\"\n" +
                "          },\n" +
                "          \"voided\":true\n" +
                "        },\n" +
                "        {\n" +
                "          \"attributeType\":{\n" +
                "            \"uuid\":\"8234e7b0-3f10-11e4-adec-0800271c1b75\"\n" +
                "          },\n" +
                "          \"voided\":true\n" +
                "        },\n" +
                "        {\n" +
                "          \"attributeType\":{\n" +
                "            \"uuid\":\"c1f4239f-3f10-11e4-adec-0800271c1b75\"\n" +
                "          },\n" +
                "          \"voided\":true\n" +
                "        },\n" +
                "        {\n" +
                "          \"attributeType\":{\n" +
                "            \"uuid\":\"c1f455e7-3f10-11e4-adec-0800271c1b75\"\n" +
                "          },\n" +
                "          \"value\":\"General\",\n" +
                "          \"hydratedObject\":\"c1fc20ab-3f10-11e4-adec-0800271c1b75\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"attributeType\":{\n" +
                "            \"uuid\":\"c1f4a004-3f10-11e4-adec-0800271c1b75\"\n" +
                "          },\n" +
                "          \"voided\":true\n" +
                "        },\n" +
                "        {\n" +
                "          \"attributeType\":{\n" +
                "            \"uuid\":\"c1f7d1f1-3f10-11e4-adec-0800271c1b75\"\n" +
                "          },\n" +
                "          \"voided\":true\n" +
                "        },\n" +
                "        {\n" +
                "          \"attributeType\":{\n" +
                "            \"uuid\":\"c1f7fd17-3f10-11e4-adec-0800271c1b75\"\n" +
                "          },\n" +
                "          \"voided\":true\n" +
                "        },\n" +
                "        {\n" +
                "          \"attributeType\":{\n" +
                "            \"uuid\":\"c1f825c9-3f10-11e4-adec-0800271c1b75\"\n" +
                "          },\n" +
                "          \"voided\":true\n" +
                "        },\n" +
                "        {\n" +
                "          \"attributeType\":{\n" +
                "            \"uuid\":\"c1f84df3-3f10-11e4-adec-0800271c1b75\"\n" +
                "          },\n" +
                "          \"voided\":true\n" +
                "        },\n" +
                "        {\n" +
                "          \"attributeType\":{\n" +
                "            \"uuid\":\"c1f8880d-3f10-11e4-adec-0800271c1b75\"\n" +
                "          },\n" +
                "          \"voided\":true\n" +
                "        },\n" +
                "        {\n" +
                "          \"attributeType\":{\n" +
                "            \"uuid\":\"3dfdc176-17fd-42b1-b5be-c7e25b78b602\"\n" +
                "          },\n" +
                "          \"value\":\"2\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"attributeType\":{\n" +
                "            \"uuid\":\"fb3c00b1-81c8-40fe-89e8-6b3344688a13\"\n" +
                "          },\n" +
                "          \"voided\":true\n" +
                "        },\n" +
                "        {\n" +
                "          \"attributeType\":{\n" +
                "            \"uuid\":\"d1314f0f-c2d9-4223-88d9-ec4d2827c9da\"\n" +
                "          },\n" +
                "          \"voided\":true\n" +
                "        },\n" +
                "        {\n" +
                "          \"attributeType\":{\n" +
                "            \"uuid\":\"9234695b-0f68-4970-aeb7-3b32d4a2b346\"\n" +
                "          },\n" +
                "          \"voided\":true\n" +
                "        },\n" +
                "        {\n" +
                "          \"attributeType\":{\n" +
                "            \"uuid\":\"35e98d04-3981-4257-a593-fadd81bfc109\"\n" +
                "          },\n" +
                "          \"voided\":true\n" +
                "        },\n" +
                "        {\n" +
                "          \"attributeType\":{\n" +
                "            \"uuid\":\"6f32179b-c6b9-465e-a278-c15da2637630\"\n" +
                "          },\n" +
                "          \"voided\":true\n" +
                "        },\n" +
                "        {\n" +
                "          \"attributeType\":{\n" +
                "            \"uuid\":\"a10fe690-1c44-4ba8-a244-8fe51f9e61f7\"\n" +
                "          },\n" +
                "          \"voided\":true\n" +
                "        }\n" +
                "      ],\n" +
                "      \"deathDate\":null,\n" +
                "      \"causeOfDeath\":\"\"\n" +
                "    },\n" +
                "    \"identifiers\":[\n" +
                "      {\n" +
                "        \"identifierSourceUuid\":\"a1a7e96e-83b3-4c1c-b0c6-f24710e62a97\",\n" +
                "        \"identifierPrefix\":\"NAT\",\n" +
                "        \"identifierType\":\"0d2ac572-8de3-46c8-9976-1f78899c599f\",\n" +
                "        \"preferred\":false,\n" +
                "        \"voided\":false\n" +
                "      },\n" +
                "      {\n" +
                "        \"identifierSourceUuid\":\"c1d8a345-3f10-11e4-adec-0800271c1b75\",\n" +
                "        \"identifierPrefix\":\"GAN\",\n" +
                "        \"identifierType\":\"81433852-3f10-11e4-adec-0800271c1b75\",\n" +
                "        \"preferred\":true,\n" +
                "        \"voided\":false\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  \"relationships\":[\n" +
                "\n" +
                "  ]\n" +
                "}", firstName, lastName, displayName);

        HttpResponse<JsonNode> response = openMRS.post("/v1/bahmnicore/patientprofile", json);
        if (response.getStatus() != 200) {
            throw new RuntimeException("Could not create patient. " + response.getBody().toString());
        }

        return parsePatient(response);
    }
}

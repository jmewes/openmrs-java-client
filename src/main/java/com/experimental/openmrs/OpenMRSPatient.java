package com.experimental.openmrs;

public class OpenMRSPatient {

    private String uuid;
    private String display;
    private OpenMRSPerson person;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public OpenMRSPerson getPerson() {
        return person;
    }

    public void setPerson(OpenMRSPerson person) {
        this.person = person;
    }
}

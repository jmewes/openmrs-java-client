package com.experimental.openmrs;

public class Patient {

    private String uuid;
    private String display;
    private Person person;

    public Patient() {

    }

    public Patient(String display) {
        this.display = display;
    }

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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        if (display != null) {
            return display;
        } else {
            return super.toString();
        }
    }
}

package com.experimental.openmrs;

public class Person {

    private String uuid;
    private String birthdate;
    private String gender;
    private Name preferredName;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Name getPreferredName() {
        return preferredName;
    }

    public void setPreferredName(Name preferredName) {
        this.preferredName = preferredName;
    }
}

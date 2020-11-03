package gt.com.model.entity;

import java.util.*;

public class PatientEntity {

    public PatientEntity() {
    }

    private int id_user;
    private int dpi;
    private String nit;
    private Date birthdate;
    private char gender;// F or M
    private String fullName;
    private String surName;
    private String address;
    private int phone;
    private int emergencyContact;
    private boolean stateNull =false;

    public boolean isStateNull() {
        return stateNull;
    }

    public void setStateNull(boolean stateNull) {
        this.stateNull = stateNull;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public int getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(int emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getDpi() {
        return dpi;
    }

    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Person;

import java.util.Date;

/**
 *
 * @author tarunangrish
 */
public class Person {
    
    private int personID;
    private String personName;
    private int personAge;
    private String status;
    private String imageDetails;
    private String identificationMark;
    private String gender;
    private static int count = 1;
    private Date registrationDate;
    private String medicalStatus;
    private double bloodPressure;
    private double pulseRate;
    private double respirationRate;
    private double bodyTemperature;
    private boolean financialAid;
    private double amount;
    private boolean requireMedicalHelp;
    private boolean isSpecialNeedsPerson;
    private boolean anyAllergies;
    private String allergyDetails;

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getPersonAge() {
        return personAge;
    }

    public void setPersonAge(int personAge) {
        this.personAge = personAge;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImageDetails() {
        return imageDetails;
    }

    public void setImageDetails(String imageDetails) {
        this.imageDetails = imageDetails;
    }

    public String getIdentificationMark() {
        return identificationMark;
    }

    public void setIdentificationMark(String identificationMark) {
        this.identificationMark = identificationMark;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Person.count = count;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getMedicalStatus() {
        return medicalStatus;
    }

    public void setMedicalStatus(String medicalStatus) {
        this.medicalStatus = medicalStatus;
    }

    public double getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(double bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public double getPulseRate() {
        return pulseRate;
    }

    public void setPulseRate(double pulseRate) {
        this.pulseRate = pulseRate;
    }

    public double getRespirationRate() {
        return respirationRate;
    }

    public void setRespirationRate(double respirationRate) {
        this.respirationRate = respirationRate;
    }

    public double getBodyTemperature() {
        return bodyTemperature;
    }

    public void setBodyTemperature(double bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }

    public boolean isFinancialAid() {
        return financialAid;
    }

    public void setFinancialAid(boolean financialAid) {
        this.financialAid = financialAid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isRequireMedicalHelp() {
        return requireMedicalHelp;
    }

    public void setRequireMedicalHelp(boolean requireMedicalHelp) {
        this.requireMedicalHelp = requireMedicalHelp;
    }

    public boolean isIsSpecialNeedsPerson() {
        return isSpecialNeedsPerson;
    }

    public void setIsSpecialNeedsPerson(boolean isSpecialNeedsPerson) {
        this.isSpecialNeedsPerson = isSpecialNeedsPerson;
    }

    public boolean isAnyAllergies() {
        return anyAllergies;
    }

    public void setAnyAllergies(boolean anyAllergies) {
        this.anyAllergies = anyAllergies;
    }

    public String getAllergyDetails() {
        return allergyDetails;
    }

    public void setAllergyDetails(String allergyDetails) {
        this.allergyDetails = allergyDetails;
    }
    
    @Override
    public String toString(){
        return String.valueOf(personID);
    }
    
}

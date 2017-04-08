package com.example.micha.entity;

/**
 * Created by micha on 04/04/2017.
 */

public class User {
    private String firstName, lastName, creditCardId, cvv, expirationDate;

    public User(String firstName, String lastName, String creditCardId, String cvv, String expirationDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.creditCardId = creditCardId;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(String creditCardId) {
        this.creditCardId = creditCardId;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName + "\n"
                + "Credit Card: " + " " +creditCardId + "\n"
                + "CVV: " + " " + cvv + "\n"
                + "Expiration Date: " + " " + expirationDate;
    }
}

package com.example.awesomeresume.entity;

public class Country {
    private int nationalityId;
    private Country birthPlace;
    private Country nationality;

    public Country() {
    }


    public Country(int nationalityId, Object o, String nationalityStr) {
    }

    public Country(int nationalityId, Country birthPlace, Country nationality) {
        this.nationalityId = nationalityId;
        this.birthPlace = birthPlace;
        this.nationality = nationality;
    }

    public Country(Object o, User user, String nationality, String birthPlace) {
    }

    public int getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(int nationalityId) {
        this.nationalityId = nationalityId;
    }

    public Country getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(Country birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Country{" +
                "nationalityId=" + nationalityId +
                ", birthPlace=" + birthPlace +
                ", nationality=" + nationality +
                '}';
    }
}

package br.com.origin.test.domain;

import br.com.origin.test.domain.enums.MaritalStatus;

import java.util.List;

public class APIRequest {

    private int age;
    private int dependents;
    private House house;
    private int income;
    private MaritalStatus maritalStatus;
    private List<Boolean> riskQuestions;
    private Vehicle vehicle;

    public int getAge() {
        return age;
    }

    public int getDependents() {
        return dependents;
    }

    public House getHouse() {
        return house;
    }

    public int getIncome() {
        return income;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public List<Boolean> getRiskQuestions() {
        return riskQuestions;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}

package br.com.origin.test.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.List;

public class ApiRequest {

    @NotNull(message = "Age can't be null")
    @Positive(message = "Age can't be negative")
    private int age;

    @NotNull(message = "Dependents can't be null")
    @Positive(message = "Dependents can't be negative")
    @Size(min = 0)
    private int dependents;

    private House house;

    @Positive(message = "Income can't be positive")
    private int income;

    @NotBlank(message = "MaritalStatus can't be empty")
    private String maritalStatus;

    private List<Integer> riskQuestions;
    private Vehicle vehicle;
}

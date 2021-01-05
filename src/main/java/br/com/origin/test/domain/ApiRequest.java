package br.com.origin.test.domain;

import br.com.origin.test.domain.enums.MaritalStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiRequest {

    @PositiveOrZero(message = "Age can't be negative.")
    private Integer age;

    @Range(min = 0)
    @PositiveOrZero(message = "Dependents can't be negative.")
    private Integer dependents;

    private House house;

    @Range(min = 0)
    @PositiveOrZero(message = "Income can't be negative.")
    private Integer income;

    @NotNull(message = "Marital Status can't be empty.")
    private MaritalStatus maritalStatus;
    private List<Integer> riskQuestions;
    private Vehicle vehicle;
}

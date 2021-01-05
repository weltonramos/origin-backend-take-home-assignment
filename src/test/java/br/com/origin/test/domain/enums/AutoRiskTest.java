package br.com.origin.test.domain.enums;

import br.com.origin.test.domain.ApiRequest;
import br.com.origin.test.domain.House;
import br.com.origin.test.domain.Vehicle;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AutoRiskTest {

    @Test
    void shouldReturnIneligible() {

        ApiRequest apiRequest = new ApiRequest(27, 0, new House(OwnershipStatus.owned), 0, MaritalStatus.single, List.of(0, 1, 0), null);
        int baseScore = apiRequest.getRiskQuestions().stream().reduce(0, Integer::sum);

        AutoRisk autoRisk = AutoRisk.calculateRisk(apiRequest, baseScore);
        assertEquals(AutoRisk.ineligible, autoRisk);
    }

    @Test
    void shouldReturnEconomic() {

        ApiRequest apiRequest = new ApiRequest(35, 2, new House(OwnershipStatus.owned), 0, MaritalStatus.married, List.of(0, 1, 0), new Vehicle(2008));
        int baseScore = apiRequest.getRiskQuestions().stream().reduce(0, Integer::sum);

        AutoRisk autoRisk = AutoRisk.calculateRisk(apiRequest, baseScore);
        assertEquals(AutoRisk.economic, autoRisk);
    }

    @Test
    void shouldReturnRegular() {

        ApiRequest apiRequest = new ApiRequest(50, 2, new House(OwnershipStatus.owned), 0, MaritalStatus.married, List.of(0, 1, 0), new Vehicle(2019));
        int baseScore = apiRequest.getRiskQuestions().stream().reduce(0, Integer::sum);

        AutoRisk autoRisk = AutoRisk.calculateRisk(apiRequest, baseScore);
        assertEquals(AutoRisk.regular, autoRisk);
    }

    @Test
    void shouldReturnResponsible() {

        ApiRequest apiRequest = new ApiRequest(58, 0, new House(OwnershipStatus.owned), 0, MaritalStatus.married, List.of(1, 1, 1), new Vehicle(2004));
        int baseScore = apiRequest.getRiskQuestions().stream().reduce(0, Integer::sum);

        AutoRisk autoRisk = AutoRisk.calculateRisk(apiRequest, baseScore);
        assertEquals(AutoRisk.responsible, autoRisk);
    }
}

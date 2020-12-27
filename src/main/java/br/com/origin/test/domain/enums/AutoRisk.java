package br.com.origin.test.domain.enums;

import br.com.origin.test.domain.ApiRequest;

import java.time.LocalDate;

public enum AutoRisk {

    economic,
    regular,
    responsible,
    ineligible;

    public static AutoRisk calculateRisk(ApiRequest request, int baseScore) {

        if (request.getVehicle() == null) {
            return AutoRisk.ineligible;
        }

        baseScore = (LocalDate.now().getYear() - request.getVehicle().getYear()) <= 5 ? baseScore += 1 : baseScore;

        if (request.getAge() < 30) {
            baseScore -= 2;
        } else if (request.getAge() <= 40) {
            baseScore -= 1;
        }

        baseScore = request.getIncome() > 200 ? baseScore -= 1 : baseScore;

        return getAutoRisk(baseScore);
    }

    private static AutoRisk getAutoRisk(int baseScore) {
        if (baseScore <= 0) return AutoRisk.economic;
        else if (baseScore <= 2) return AutoRisk.regular;
        return AutoRisk.responsible;
    }
}

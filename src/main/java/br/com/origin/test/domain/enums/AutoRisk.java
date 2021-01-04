package br.com.origin.test.domain.enums;

import br.com.origin.test.domain.ApiRequest;

import java.time.LocalDate;

public enum AutoRisk {

    economic,
    regular,
    responsible,
    ineligible;

    private static final int THIRTY_YEARS_OLD = 30;
    private static final int FORTY_YEARS_OLD = 40;
    private static final int BASE_INCOME = 200;

    public static AutoRisk calculateRisk(ApiRequest request, int baseScore) {

        if (request.getVehicle() == null) {
            return AutoRisk.ineligible;
        }

        baseScore = (LocalDate.now().getYear() - request.getVehicle().getYear()) <= 5 ? baseScore += 1 : baseScore;

        if (request.getAge() < THIRTY_YEARS_OLD) {
            baseScore -= 2;
        } else if (request.getAge() <= FORTY_YEARS_OLD) {
            baseScore -= 1;
        }

        baseScore = request.getIncome() > BASE_INCOME ? baseScore -= 1 : baseScore;

        return getAutoRisk(baseScore);
    }

    private static AutoRisk getAutoRisk(int baseScore) {
        if (baseScore <= 0) return AutoRisk.economic;
        else if (baseScore <= 2) return AutoRisk.regular;
        return AutoRisk.responsible;
    }
}

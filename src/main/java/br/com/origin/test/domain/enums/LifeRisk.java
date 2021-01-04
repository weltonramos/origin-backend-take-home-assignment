package br.com.origin.test.domain.enums;

import br.com.origin.test.domain.ApiRequest;

public enum LifeRisk {

    economic,
    regular,
    responsible,
    ineligible;

    private static final int THIRTY_YEARS_OLD = 30;
    private static final int FORTY_YEARS_OLD = 40;
    private static final int SIXTY_YEARS_OLD = 60;
    private static final int BASE_INCOME = 200;

    public static LifeRisk calculateRisk(ApiRequest request, int baseScore) {

        if (request.getAge() > SIXTY_YEARS_OLD) {
            return LifeRisk.ineligible;
        }

        if (request.getAge() < THIRTY_YEARS_OLD) {
            baseScore -= 2;
        } else if (request.getAge() <= FORTY_YEARS_OLD) {
            baseScore -= 1;
        }

        baseScore = request.getIncome() > BASE_INCOME ? baseScore -= 1 : baseScore;
        baseScore = request.getDependents() > 0 ? baseScore += 1 : baseScore;
        baseScore = request.getMaritalStatus().equals(MaritalStatus.married) ? baseScore += 1 : baseScore;

        return getLifeRisk(baseScore);
    }

    private static LifeRisk getLifeRisk(int baseScore) {
        if (baseScore <= 0) return LifeRisk.economic;
        else if (baseScore <= 2) return LifeRisk.regular;
        return LifeRisk.responsible;
    }
}

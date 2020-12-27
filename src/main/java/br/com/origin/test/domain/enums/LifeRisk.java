package br.com.origin.test.domain.enums;

import br.com.origin.test.domain.ApiRequest;

public enum LifeRisk {

    economic,
    regular,
    responsible,
    ineligible;

    public static LifeRisk calculateRisk(ApiRequest request, int baseScore) {

        if (request.getAge() > 60) {
            return LifeRisk.ineligible;
        }

        if (request.getAge() < 30) {
            baseScore -= 2;
        } else if (request.getAge() <= 40) {
            baseScore -= 1;
        }

        baseScore = request.getIncome() > 200 ? baseScore -= 1 : baseScore;
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

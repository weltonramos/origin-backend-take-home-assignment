package br.com.origin.test.domain.enums;

import br.com.origin.test.domain.ApiRequest;

public enum DisabilityRisk {

    economic,
    regular,
    responsible,
    ineligible;

    public static DisabilityRisk calculateRisk(ApiRequest request, int baseScore) {

        if (request.getIncome().equals(0) || request.getVehicle() == null || request.getHouse() == null || request.getAge() > 60) {
            return DisabilityRisk.ineligible;
        }

        if (request.getAge() < 30) {
            baseScore -= 2;
        } else if (request.getAge() <= 40) {
            baseScore -= 1;
        }

        baseScore = request.getIncome() > 200 ? baseScore -= 1 : baseScore;
        baseScore = request.getHouse().getOwnershipStatus().equals(OwnershipStatus.mortgaged) ? baseScore += 1 : baseScore;
        baseScore = request.getDependents() > 0 ? baseScore += 1 : baseScore;
        baseScore = request.getMaritalStatus().equals(MaritalStatus.married) ? baseScore += 1 : baseScore;

        return getDisabilityRisk(baseScore);
    }

    private static DisabilityRisk getDisabilityRisk(int baseScore) {
        if (baseScore <= 0) return DisabilityRisk.economic;
        else if (baseScore <= 2) return DisabilityRisk.regular;
        return DisabilityRisk.responsible;
    }
}

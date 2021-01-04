package br.com.origin.test.domain.enums;

import br.com.origin.test.domain.ApiRequest;

public enum DisabilityRisk {

    economic,
    regular,
    responsible,
    ineligible;

    private static final int THIRTY_YEARS_OLD = 30;
    private static final int FORTY_YEARS_OLD = 40;
    private static final int SIXTY_YEARS_OLD = 60;
    private static final int BASE_INCOME = 200;

    public static DisabilityRisk calculateRisk(ApiRequest request, int baseScore) {

        if (request.getIncome().equals(0) || request.getVehicle() == null || request.getHouse() == null || request.getAge() > SIXTY_YEARS_OLD) {
            return DisabilityRisk.ineligible;
        }

        if (request.getAge() < THIRTY_YEARS_OLD) {
            baseScore -= 2;
        } else if (request.getAge() <= FORTY_YEARS_OLD) {
            baseScore -= 1;
        }

        baseScore = request.getIncome() > BASE_INCOME ? baseScore -= 1 : baseScore;
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

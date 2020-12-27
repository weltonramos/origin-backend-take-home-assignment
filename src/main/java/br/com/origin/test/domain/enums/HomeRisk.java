package br.com.origin.test.domain.enums;

import br.com.origin.test.domain.ApiRequest;

public enum HomeRisk {

    economic,
    regular,
    responsible,
    ineligible;

    public static HomeRisk calculateRisk(ApiRequest request, int baseScore) {

        if (request.getHouse() == null) {
            return HomeRisk.ineligible;
        }

        if (request.getAge() < 30) {
            baseScore -= 2;
        } else if (request.getAge() <= 40) {
            baseScore -= 1;
        }

        baseScore = request.getIncome() > 200 ? baseScore -= 1 : baseScore;

        if (OwnershipStatus.mortgaged.equals(request.getHouse().getOwnershipStatus())) {
            baseScore += 1;
        }

        return getHomeRisk(baseScore);
    }

    private static HomeRisk getHomeRisk(int baseScore) {
        if (baseScore <= 0) return HomeRisk.economic;
        else if (baseScore <= 2) return HomeRisk.regular;
        return HomeRisk.responsible;
    }
}

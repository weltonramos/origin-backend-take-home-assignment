package br.com.origin.test.domain.enums;

import br.com.origin.test.domain.ApiRequest;

public enum HomeRisk {

    economic,
    regular,
    responsible,
    ineligible;

    private static final int THIRTY_YEARS_OLD = 30;
    private static final int FORTY_YEARS_OLD = 40;
    private static final int BASE_INCOME = 200;

    public static HomeRisk calculateRisk(ApiRequest request, int baseScore) {

        if (request.getHouse() == null) {
            return HomeRisk.ineligible;
        }

        if (request.getAge() < THIRTY_YEARS_OLD) {
            baseScore -= 2;
        } else if (request.getAge() <= FORTY_YEARS_OLD) {
            baseScore -= 1;
        }

        baseScore = request.getIncome() > BASE_INCOME ? baseScore -= 1 : baseScore;

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

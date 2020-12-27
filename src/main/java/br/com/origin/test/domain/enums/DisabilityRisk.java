package br.com.origin.test.domain.enums;

import br.com.origin.test.domain.ApiRequest;

public enum DisabilityRisk {

    regular,
    inelegible,
    economic;

    public static DisabilityRisk calculateRisk(ApiRequest request, int baseScore) {

        return null;
    }
}

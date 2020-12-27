package br.com.origin.test.domain.enums;

import br.com.origin.test.domain.ApiRequest;

public enum LifeRisk {

    regular,
    inelegible,
    economic;

    public static LifeRisk calculateRisk(ApiRequest request, int baseScore) {

        return null;
    }
}

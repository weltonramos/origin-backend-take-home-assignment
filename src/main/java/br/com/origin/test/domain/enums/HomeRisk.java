package br.com.origin.test.domain.enums;

import br.com.origin.test.domain.ApiRequest;

public enum HomeRisk {

    regular,
    inelegible,
    economic;

    public static HomeRisk calculateRisk(ApiRequest request, int baseScore) {

        return null;
    }
}

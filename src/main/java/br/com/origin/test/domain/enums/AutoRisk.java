package br.com.origin.test.domain.enums;

import br.com.origin.test.domain.ApiRequest;

public enum AutoRisk {

    regular,
    inelegible,
    economic;

    public static AutoRisk calculateRisk(ApiRequest request, int baseScore) {

        return null;
    }
}

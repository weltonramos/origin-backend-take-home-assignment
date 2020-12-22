package br.com.origin.test.usecase;

import br.com.origin.test.domain.ApiRequest;
import br.com.origin.test.domain.ApiResponse;
import br.com.origin.test.domain.enums.RiskType;
import org.springframework.stereotype.Service;

@Service
public class GetRiskProfileUseCase {

    public ApiResponse execute(ApiRequest request) {
        ApiResponse apiResponse = new ApiResponse();

        apiResponse.setAuto(getAutoRiskProfile(request));
        apiResponse.setDisability(getDisabilityRiskProfile(request));
        apiResponse.setHome(getHomeRiskProfile(request));
        apiResponse.setLife(getLifeRiskProfile(request));

        return apiResponse;
    }

    private RiskType getAutoRiskProfile(ApiRequest request) {
        return RiskType.economic;
    }

    private RiskType getDisabilityRiskProfile(ApiRequest request) {
        return RiskType.regular;
    }

    private RiskType getHomeRiskProfile(ApiRequest request) {
        return RiskType.inelegible;
    }

    private RiskType getLifeRiskProfile(ApiRequest request) {
        return RiskType.economic;
    }
}

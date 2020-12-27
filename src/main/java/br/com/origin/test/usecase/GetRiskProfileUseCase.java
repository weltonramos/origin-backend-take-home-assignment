package br.com.origin.test.usecase;

import br.com.origin.test.domain.ApiRequest;
import br.com.origin.test.domain.ApiResponse;
import br.com.origin.test.domain.enums.AutoRisk;
import br.com.origin.test.domain.enums.DisabilityRisk;
import br.com.origin.test.domain.enums.HomeRisk;
import br.com.origin.test.domain.enums.LifeRisk;
import org.springframework.stereotype.Service;

@Service
public class GetRiskProfileUseCase {

    public ApiResponse execute(ApiRequest request) {

        ApiResponse apiResponse = new ApiResponse();
        int baseScore = request.getRiskQuestions().stream().reduce(0, Integer::sum);

        apiResponse.setAuto(AutoRisk.calculateRisk(request, baseScore));
        apiResponse.setDisability(DisabilityRisk.calculateRisk(request, baseScore));
        apiResponse.setHome(HomeRisk.calculateRisk(request, baseScore));
        apiResponse.setLife(LifeRisk.calculateRisk(request, baseScore));

        return apiResponse;
    }
}

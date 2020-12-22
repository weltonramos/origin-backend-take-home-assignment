package br.com.origin.test.controller;

import br.com.origin.test.domain.ApiRequest;
import br.com.origin.test.domain.ApiResponse;
import br.com.origin.test.usecase.GetRiskProfileUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
public class RiskProfileController {

    @Autowired
    private GetRiskProfileUseCase getRiskProfileUseCase;

    @GetMapping("/riskprofile")
    public ResponseEntity<ApiResponse> getRiskProfile(@Valid @RequestBody ApiRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(getRiskProfileUseCase.execute(request));
    }
}

package br.com.origin.test.domain;

import br.com.origin.test.domain.enums.AutoRisk;
import br.com.origin.test.domain.enums.DisabilityRisk;
import br.com.origin.test.domain.enums.HomeRisk;
import br.com.origin.test.domain.enums.LifeRisk;
import lombok.Data;

@Data
public class ApiResponse {

    private AutoRisk auto;
    private DisabilityRisk disability;
    private HomeRisk home;
    private LifeRisk life;

}

package br.com.origin.test.domain;

import br.com.origin.test.domain.enums.AutoRisk;
import br.com.origin.test.domain.enums.DisabilityRisk;
import br.com.origin.test.domain.enums.HomeRisk;
import br.com.origin.test.domain.enums.LifeRisk;

public class ApiResponse {

    private AutoRisk auto;
    private DisabilityRisk disability;
    private HomeRisk home;
    private LifeRisk life;

    public AutoRisk getAuto() {
        return auto;
    }

    public void setAuto(AutoRisk auto) {
        this.auto = auto;
    }

    public DisabilityRisk getDisability() {
        return disability;
    }

    public void setDisability(DisabilityRisk disability) {
        this.disability = disability;
    }

    public HomeRisk getHome() {
        return home;
    }

    public void setHome(HomeRisk home) {
        this.home = home;
    }

    public LifeRisk getLife() {
        return life;
    }

    public void setLife(LifeRisk life) {
        this.life = life;
    }
}

package br.com.origin.test.domain;

import br.com.origin.test.domain.enums.RiskType;

public class ApiResponse {

    private RiskType auto;
    private RiskType disability;
    private RiskType home;
    private RiskType life;

    public RiskType getAuto() {
        return auto;
    }

    public RiskType getDisability() {
        return disability;
    }

    public RiskType getHome() {
        return home;
    }

    public RiskType getLife() {
        return life;
    }

    public void setAuto(RiskType auto) {
        this.auto = auto;
    }

    public void setDisability(RiskType disability) {
        this.disability = disability;
    }

    public void setHome(RiskType home) {
        this.home = home;
    }

    public void setLife(RiskType life) {
        this.life = life;
    }
}

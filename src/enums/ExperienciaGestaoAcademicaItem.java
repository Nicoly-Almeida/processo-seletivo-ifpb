package enums;

import interfaces.ProvaTitulos;

public enum ExperienciaGestaoAcademicaItem implements ProvaTitulos {
    DIRECAO("", 15),
    COORDENACAO("", 10),
    NENHUMA("", 0);

    private final int pontuacaoMaxima;

    ExperienciaGestaoAcademicaItem(String descricao, int pontuacaoMaxima) {
        this.pontuacaoMaxima = pontuacaoMaxima;
    }

    @Override
    public double calcularPontuacao(int semestres) {
    	if (semestres > pontuacaoMaxima) {
    		return pontuacaoMaxima;
    	}
        return semestres;
    }

    @Override
    public double getPontuacaoMaxima() {
        return pontuacaoMaxima;
    }
}

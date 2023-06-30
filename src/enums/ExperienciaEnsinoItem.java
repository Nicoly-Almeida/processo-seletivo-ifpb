package enums;

import interfaces.ProvaTitulos;

public enum ExperienciaEnsinoItem implements ProvaTitulos {
    REDE_FEDERAL("", 12),
    EDUCACAO_SUPERIOR("", 7),
    ENSINO_MEDIO("", 6);

    private final int pontuacaoMaxima;

    ExperienciaEnsinoItem(String descricao, int pontuacaoMaxima) {
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
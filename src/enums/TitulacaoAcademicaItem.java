package enums;

import interfaces.ProvaTitulos;

public enum TitulacaoAcademicaItem implements ProvaTitulos {
    ESPECIALISTA("Especialização", 10),
    MESTRE("Mestrado", 18),
    DOUTOR("Doutorado", 25);

    private final String descricao;
    private final double pontuacaoMaxima;

    TitulacaoAcademicaItem(String descricao, double pontuacaoMaxima) {
        this.descricao = descricao;
        this.pontuacaoMaxima = pontuacaoMaxima;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public double calcularPontuacao(int semestres) {
        return pontuacaoMaxima;
    }

    @Override
    public double getPontuacaoMaxima() {
        return pontuacaoMaxima;
    }
}
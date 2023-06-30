package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import enums.TitulacaoAcademicaItem;
import interfaces.ProvaTitulos;

public class Candidato {
    private String nome;
    private String rg;
    private double notaDesempenho;
    private Map<ProvaTitulos, Integer> experiencia = new HashMap<>();
    private TitulacaoAcademicaItem titulacaoAcademica;

    public Candidato(String nome, String rg, double notaDesempenho) {
        this.nome = nome;
        this.rg = rg;
        this.notaDesempenho = notaDesempenho;
    }

    public void adicionarExperiencia(ProvaTitulos dimensao, int semestres) {
        experiencia.put(dimensao, semestres);
    }

    public void setTitulacaoAcademica(TitulacaoAcademicaItem titulacaoAcademica) {
        this.titulacaoAcademica = titulacaoAcademica;
    }

    public String getNome() {
        return nome;
    }

    public String getRg() {
        return rg;
    }

    public double getNotaDesempenho() {
        return notaDesempenho;
    }

    public Map<ProvaTitulos, Integer> getExperiencia() {
        return experiencia;
    }

    public TitulacaoAcademicaItem getTitulacaoAcademica() {
        return titulacaoAcademica;
    }
}

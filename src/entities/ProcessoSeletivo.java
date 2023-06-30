package entities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import interfaces.ProvaTitulos;

public class ProcessoSeletivo {
    private int numVagas;
    private List<Candidato> candidatos = new ArrayList<>();

    public ProcessoSeletivo(int numVagas) {
        this.numVagas = numVagas;
    }

    public void adicionarCandidato(Candidato candidato) {
        candidatos.add(candidato);
    }

    public List<Candidato> classificarCandidatosAprovados() {
        List<Candidato> candidatosAprovados = new ArrayList<>();

        for (Candidato candidato : candidatos) {
            if (candidato.getNotaDesempenho() >= 70) {
                candidatosAprovados.add(candidato);
            }
        }

        candidatosAprovados.sort(Comparator.comparingDouble(this::calcularPontuacaoFinal).reversed());

        return candidatosAprovados;
    }

    
    public List<Candidato> classificarCandidatosReprovados() {
        List<Candidato> candidatosReprovados = new ArrayList<>();

        for (Candidato candidato : candidatos) {
            if (candidato.getNotaDesempenho() < 70) {
                candidatosReprovados.add(candidato);
            }
        }

        candidatosReprovados.sort(Comparator.comparingDouble(this::calcularPontuacaoFinal).reversed());

        return candidatosReprovados;
    }
    
    
    public double calcularPontuacaoFinal(Candidato candidato) {
        double pontuacaoFinal = candidato.getNotaDesempenho();

        for (Map.Entry<ProvaTitulos, Integer> entry : candidato.getExperiencia().entrySet()) {
            ProvaTitulos dimensao = entry.getKey();
            int semestres = entry.getValue();
            pontuacaoFinal += dimensao.calcularPontuacao(semestres);
        }

        return pontuacaoFinal;
    }

    public int getNumVagas() {
        return numVagas;
    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }
}
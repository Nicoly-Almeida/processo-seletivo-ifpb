import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import entities.Candidato;
import entities.ProcessoSeletivo;
import enums.ExperienciaEnsinoItem;
import enums.ExperienciaGestaoAcademicaItem;
import enums.TitulacaoAcademicaItem;
import interfaces.ProvaTitulos;

public class Application {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Informe a quantidade de vagas: ");
        int numVagas = scanner.nextInt();
        System.out.println();

        ProcessoSeletivo processoSeletivo = new ProcessoSeletivo(numVagas);

        while (adicionarCandidato()) {
            Candidato candidato = criarCandidato();
            if (candidato != null) {
                processoSeletivo.adicionarCandidato(candidato);
            }
        }

        List<Candidato> candidatosAprovados = processoSeletivo.classificarCandidatosAprovados();
        List<Candidato> candidatosReprovados = processoSeletivo.classificarCandidatosReprovados();

        exibirResultadoProcessoSeletivo(processoSeletivo, candidatosAprovados, candidatosReprovados);
    }

    private static boolean adicionarCandidato() {
        System.out.print("Deseja adicionar um candidato? (S/N): ");
        String opcao = scanner.next();
        return opcao.equalsIgnoreCase("S");
    }

    private static Candidato criarCandidato() {
        System.out.print("Informe o nome do candidato: ");
        String nome = scanner.next();

        System.out.print("Informe o RG do candidato: ");
        String rg = scanner.next();

        System.out.print("Informe a nota de desempenho do candidato: ");
        double notaDesempenho = scanner.nextDouble();

        Candidato candidato = new Candidato(nome, rg, notaDesempenho);

        if (notaDesempenho < 70) {
            System.out.println("Candidato n�o atende aos crit�rios m�nimos. Reprovado.");
            System.out.println();
            return candidato;
        }

        preencherExperiencias(candidato);
        preencherTitulacaoAcademica(candidato);
        return candidato;
    }

    private static void preencherExperiencias(Candidato candidato) {
    	System.out.println();
        System.out.println("Informe a experi�ncia do candidato:");

        preencherExperiencia(ExperienciaEnsinoItem.REDE_FEDERAL, "Rede Federal", candidato);
        preencherExperiencia(ExperienciaEnsinoItem.EDUCACAO_SUPERIOR, "Educa��o Superior", candidato);
        preencherExperiencia(ExperienciaEnsinoItem.ENSINO_MEDIO, "Ensino M�dio", candidato);
        preencherExperiencia(ExperienciaGestaoAcademicaItem.DIRECAO, "Dire��o", candidato);
        preencherExperiencia(ExperienciaGestaoAcademicaItem.COORDENACAO, "Coordena��o", candidato);
    }

    private static void preencherExperiencia(ProvaTitulos dimensao, String descricao, Candidato candidato) {
        System.out.print("- Experi�ncia em " + descricao + " (semestres): ");
        int semestres = scanner.nextInt();
        candidato.adicionarExperiencia(dimensao, semestres);
    }

    private static void preencherTitulacaoAcademica(Candidato candidato) {
        System.out.print("Informe a titula��o acad�mica do candidato: ");
        String titulacaoAcademica = scanner.next();
        candidato.setTitulacaoAcademica(TitulacaoAcademicaItem.valueOf(titulacaoAcademica.toUpperCase()));
        System.out.println();
    }

    private static void exibirResultadoProcessoSeletivo(ProcessoSeletivo processoSeletivo,
                                                       List<Candidato> candidatosAprovados,
                                                       List<Candidato> candidatosReprovados) {
        System.out.println("\n----- Resultado do Processo Seletivo -----");
        
        System.out.println();

        System.out.println("Vagas dispon�veis: " + processoSeletivo.getNumVagas());
        System.out.println("N�mero de candidatos inscritos: " + processoSeletivo.getCandidatos().size());
        System.out.println("N�mero de candidatos aprovados: " + candidatosAprovados.size());
        
        System.out.println();

        System.out.println("\n--- Candidatos Aprovados ---");
        for (Candidato candidato : candidatosAprovados) {
        	System.out.println("Nome: " + candidato.getNome());
            System.out.println("RG: " + candidato.getRg());
            System.out.println("Pontua��o Final: " + processoSeletivo.calcularPontuacaoFinal(candidato));
            System.out.println();
        }

        System.out.println("\n--- Candidatos Reprovados ---");
        for (Candidato candidato : candidatosReprovados) {
        	System.out.println("Nome: " + candidato.getNome());
            System.out.println("RG: " + candidato.getRg());
            System.out.println("Pontua��o Final: " + processoSeletivo.calcularPontuacaoFinal(candidato));
            System.out.println();
        }
    }
}
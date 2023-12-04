package com.classes.apresentacao;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.classes.dados.Aluno;
import com.classes.dados.Grupo;
import com.classes.negocio.LeituraPlanilha;
import com.classes.repositorio.GrupoRepositorio;
import com.classes.repositorio.AlunoRepositorio;

public class ProgramaInterativo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GrupoRepositorio grupo = new GrupoRepositorio();
        AlunoRepositorio aluno = new AlunoRepositorio();
        
        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Criar Grupos");
            System.out.println("2 - Listar Todos os Grupos");
            System.out.println("3 - Atualizar Grupos");
            System.out.println("4 - Deletar Grupos");
            System.out.println("5 - Analisar Alunos");
            System.out.println("6 - Sair");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (escolha) {
                case 1:
                    criarGrupos(scanner, grupo);
                    break;

                case 2:
                    System.out.println("\nLista de Todos os Grupos:");
                    for (Grupo grupoItem : grupo.obterTodosGrupos()) {
                        System.out.println(grupoItem);
                    }
                    break;

                case 3:
                    atualizarGrupos(scanner, grupo);
                    break;

                case 4:
                    excluirGrupos(scanner, grupo);
                    break;

                case 5:
                    analisarAlunos(scanner, aluno);
                    break;

                case 6:
                    System.out.println("Saindo do programa.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void criarGrupos(Scanner scanner, GrupoRepositorio grupo ) {
        int indiceAluno = 0;

        LeituraPlanilha leituraPlanilha = new LeituraPlanilha();
        
        try {
            leituraPlanilha.read(new File("src/main/resources/alunos.csv"));
        } catch (Exception e) {
            System.err.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        }

        
        System.out.println("\nQuantos grupos deseja criar?");
        int quantidadeGrupos = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha
        
        System.out.println("Quantos alunos deseja em cada grupo?");
        int quantidadeAlunosPorGrupo = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha
        System.out.println("--------------------------------------------------------------------");
        
        List<Aluno> alunos = leituraPlanilha.getAlunos(); // Obter a lista de alunos
        
        Collections.shuffle(alunos); // Embaralhar a lista de alunos
        
        // Criar grupos e adicionar o grupo na lista de grupos
        for (int i = 1; i <= quantidadeGrupos; i++) {
            Grupo novoGrupo = new Grupo(i, quantidadeGrupos, quantidadeAlunosPorGrupo);
            grupo.adicionarGrupo(novoGrupo);

            // Adicionar os alunos ao grupo
            for (int j = 0; j < quantidadeAlunosPorGrupo && j < alunos.size(); j++) {
                Aluno aluno = alunos.get(indiceAluno);
                grupo.adicionarAlunoAoGrupo(i, aluno);
                indiceAluno++;
            }
            System.out.println("Grupo criado: " + novoGrupo);
            System.out.println("--------------------------------------------------------------------");
        }
    }

    private static void atualizarGrupos(Scanner scanner, GrupoRepositorio grupo) {
        System.out.println("\nDigite o ID do grupo que deseja atualizar:");
        int idGrupo = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        System.out.println("Digite a nova quantidade de grupos:");
        int novaQuantidadeGrupos = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        System.out.println("Digite a nova quantidade de alunos por grupo:");
        int novaQuantidadeAlunosPorGrupo = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        Grupo grupoAtualizado = new Grupo(idGrupo, novaQuantidadeGrupos, novaQuantidadeAlunosPorGrupo);
        grupo.atualizarGrupo(grupoAtualizado);
        System.out.println("Grupo atualizado: " + grupoAtualizado);
    }

    private static void excluirGrupos(Scanner scanner, GrupoRepositorio grupo) {
        System.out.println("\nDigite o ID do grupo que deseja excluir:");
        int idGrupoExcluir = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        grupo.excluirGrupo(idGrupoExcluir);
        System.out.println("Grupo com ID " + idGrupoExcluir + " excluído.");
    }

    private static void analisarAlunos(Scanner scanner, AlunoRepositorio aluno) {
        while (true) {
            System.out.println("\nEscolha uma opção para Analisar Alunos:");
            System.out.println("1 - Criar aluno");
            System.out.println("2 - Ler todos alunos");
            System.out.println("3 - Atualizar aluno");
            System.out.println("4 - Deletar aluno");
            System.out.println("5 - Voltar");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (escolha) {
                case 1:
                    // Lógica para criar um novo aluno
                    AlunoRepositorio.criarAluno(scanner);
                    break;

                case 2:
                    // Lógica para ler alunos da planilha
                    AlunoRepositorio.obterTodosAlunos();
                    break;

                case 3:
                    // Lógica para atualizar um aluno existente
                    AlunoRepositorio.atualizarAluno(scanner);
                    break;

                case 4:
                    // Lógica para deletar um aluno
                    AlunoRepositorio.excluirAluno(scanner);
                    break;

                case 5:
                    return; // Voltar ao menu principal

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}

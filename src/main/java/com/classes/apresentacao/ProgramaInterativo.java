package com.classes.apresentacao;

import java.util.List;
import java.util.Scanner;

import com.classes.dados.Aluno;
import com.classes.dados.Grupo;
import com.classes.repositorio.GrupoRepositorio;


public class ProgramaInterativo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GrupoRepositorio grupo = new GrupoRepositorio();

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Criar Grupos");
            System.out.println("2 - Listar Todos os Grupos");
            System.out.println("3 - Sair");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (escolha) {
                case 1:
                    System.out.println("\nQuantos grupos deseja criar?");
                    int quantidadeGrupos = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha

                    System.out.println("Quantos alunos deseja em cada grupo?");
                    int quantidadeAlunosPorGrupo = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha

                    for (int i = 1; i <= quantidadeGrupos; i++) {
                        Grupo novoGrupo = new Grupo(i, quantidadeGrupos, quantidadeAlunosPorGrupo);
                        grupo.adicionarGrupo(novoGrupo);

                        for (int j = 1; j <= quantidadeAlunosPorGrupo; j++) {
                            // Aqui você pode adicionar lógica para adicionar alunos ao grupo
                            // (pode ser feito interativamente ou usando uma lista de alunos existentes)
                            // Exemplo: novoGrupo.adicionarAluno(new Aluno("Nome do Aluno"));
                            System.out.print("Nome do Aluno " + j + ": ");
                            String nomeAluno = scanner.nextLine();

                            // Aqui você pode criar um aluno com o nome informado
                            Aluno aluno = new Aluno(nomeAluno);

                            // Adicionar o aluno ao grupo
                            novoGrupo.adicionarAluno(aluno);
                        }

                        System.out.println("Grupo criado: " + novoGrupo);
                    }
                    break;

                case 2:
                    System.out.println("\nLista de Todos os Grupos:");
                    for (Grupo grupoItem : grupo.obterTodosGrupos()) {
                        System.out.println(grupoItem);
                    }
                    break;

                    case 3:
                    System.out.println("Saindo do programa.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}


package com.classes.apresentacao;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

import com.classes.dados.Aluno;
import com.classes.dados.Grupo;
import com.classes.negocio.AvaliacaoAluno;
import com.classes.negocio.LeituraPlanilha;
import com.classes.repositorio.GrupoRepositorio;


public class ProgramaInterativo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GrupoRepositorio grupo = new GrupoRepositorio();
        LeituraPlanilha leituraPlanilha = new LeituraPlanilha();
        int indiceAluno = 0;

        while (true) {
            System.out.println("\nEscolha uma opçao:");
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

                    try {
                        leituraPlanilha.read(new File("src/main/resources/alunos.csv"));
                    } catch (Exception e) {
                        System.err.println("Erro ao ler o arquivo CSV: " + e.getMessage());
                    }

                    List<Aluno> listaDeAlunos = leituraPlanilha.getAlunos(); // Obter a lista de alunos

                    Collections.shuffle(listaDeAlunos); // Embaralhar a lista de alunos

                    // Criar grupos e adicionar o grupo na lista de grupos
                    for (int i = 1; i <= quantidadeGrupos; i++) {
                        Grupo novoGrupo = new Grupo(i, quantidadeGrupos, quantidadeAlunosPorGrupo);
                        grupo.adicionarGrupo(novoGrupo); 

                    // Adicionar os alunos ao grupo
                    for (int j = 0; j < quantidadeAlunosPorGrupo && j < listaDeAlunos.size(); j++) {
                        Aluno aluno = listaDeAlunos.get(indiceAluno);
                        GrupoRepositorio.adicionarAlunoAoGrupo(i, aluno); 
                        indiceAluno++; 
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


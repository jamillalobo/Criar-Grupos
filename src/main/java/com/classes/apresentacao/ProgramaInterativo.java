package com.classes.apresentacao;

import java.util.List;
import java.util.Scanner;

import com.classes.dados.Aluno;
import com.classes.repositorio.AlunoRepositorio;

public class ProgramaInterativo {
    public static void main(String[] args) {
        AlunoRepositorio AlunoRepositorio = new AlunoRepositorio();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Adicionar aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Atualizar aluno");
            System.out.println("4 - Excluir aluno");
            System.out.println("5 - Sair");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (choice) {
                case 1:
                    System.out.println("Digite o nome do aluno:");
                    String name = scanner.nextLine();
                    System.out.println("Digite a idade do aluno:");
                    int age = scanner.nextInt();
                    AlunoRepositorio.adicionarAluno(new Aluno());
                    System.out.println("Aluno adicionado com sucesso!");
                    break;

                case 2:
                    List<Aluno> alunos = AlunoRepositorio.obterTodosAlunos();
                    alunos.forEach(System.out::println);
                    break;

                case 3:
                    System.out.println("Digite o ID do aluno a ser atualizado:");
                    int studentId = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha
                    System.out.println("Digite o novo nome do aluno:");
                    String newName = scanner.nextLine();
                    AlunoRepositorio.atualizarAluno(null);
                    System.out.println("Aluno atualizado com sucesso!");
                    break;

                case 4:
                    System.out.println("Digite o ID do aluno a ser excluído:");
                    int studentToDelete = scanner.nextInt();
                    AlunoRepositorio.removerAluno(id);
                    System.out.println("Aluno excluído com sucesso!");
                    break;

                case 5:
                    System.out.println("Saindo do programa...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static String getId() {
        return null;
    }
}

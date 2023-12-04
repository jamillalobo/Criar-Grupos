package com.classes.repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.classes.dados.Aluno;
import com.classes.negocio.LeituraPlanilha;

public class AlunoRepositorio {
    private static List<Aluno> alunos;

    public AlunoRepositorio() {
        AlunoRepositorio.alunos = new ArrayList<>();
    }

    // CREATE
    public static void criarAluno(Scanner scanner) {
            System.out.println("Criando novo aluno...");

            System.out.print("ID do aluno: ");
            String id = scanner.nextLine();

            System.out.print("Nome do aluno: ");
            String nome = scanner.nextLine();

            System.out.print("Idade do aluno: ");
            int idade = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            System.out.print("Experiência profissional do aluno: ");
            int expprofissional = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            System.out.print("Gênero do aluno: ");
            String genero = scanner.nextLine();

            System.out.print("Primeira graduação do aluno (responder com true ou false): ");
            String primeiraGraduacao = scanner.nextLine();

            System.out.print("Perfil do aluno: ");
            String perfil = scanner.nextLine();

            Aluno novoAluno = new Aluno(id, nome, idade, expprofissional, genero, primeiraGraduacao, perfil);
            adicionarAluno(novoAluno);

            System.out.println("Aluno criado com sucesso!");
        }

    private static void adicionarAluno(Aluno novoAluno) {
        LeituraPlanilha leituraPlanilha = new LeituraPlanilha();
        List<Aluno> listaDeAlunos = leituraPlanilha.getAlunos(); // Obter a lista de alunos

        for (Aluno aluno : listaDeAlunos) {
            if (aluno.getId().equals(novoAluno.getId())) {
                alunos.add(novoAluno);
                return;
            }
        }
    }

    // READ
    public Aluno obterAlunoPorId(int id) {
        for (Aluno aluno : alunos) {
            if (aluno.getId().equals(String.valueOf(id))) {
                return aluno;
            }
        }
        return null;
    }

    // READ ALL
    public static List<Aluno> obterTodosAlunos() {
        

        return new ArrayList<>(alunos);
    }

    // UPDATE
    public static Aluno atualizarAluno(Scanner scanner) {
        System.out.print("ID do aluno: ");
        String id = scanner.nextLine();
        
        System.out.print("Nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Idade do aluno: ");
        int idade = scanner.nextInt();

        System.out.print("Experiência profissional do aluno: ");
        int expprofissional = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        System.out.print("Gênero do aluno: ");
        String genero = scanner.nextLine();

        System.out.print("Primeira graduação do aluno (responder com true ou false): ");
        String primeiraGraduacao = scanner.nextLine();

        System.out.print("Perfil do aluno: ");
        String perfil = scanner.nextLine();

        Aluno alunoAtualizado = new Aluno(id, nome, idade, expprofissional, genero, primeiraGraduacao, perfil);
        
        return alunoAtualizado;
        
    }

    // DELETE
    public static void excluirAluno(Scanner scanner) {
        System.out.print("ID do aluno: ");
        String id = scanner.nextLine();

        alunos.removeIf(aluno -> aluno.getId().equals(String.valueOf(id)));
        System.out.println("Aluno com ID " + id + " excluído.");
    }

}


package com.classes.repositorio;

import java.util.ArrayList;
import java.util.List;

import com.classes.dados.Aluno;

public class AlunoRepositorio {
    private List<Aluno> alunos;

    // Construtor que inicializa a lista de alunos
    public AlunoRepositorio() {
        this.alunos = new ArrayList<>();
    }

    // Método para adicionar um aluno
    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    // Método para obter um aluno pelo ID
    public Aluno obterAlunoPorId(String id) {
        for (Aluno aluno : alunos) {
            if (aluno.getId().equals(id)) {
                return aluno;
            }
        }
        return null; // Retorna null se o aluno não for encontrado
    }

    // Método para atualizar os dados de um aluno
    public void atualizarAluno(Aluno alunoAtualizado) {
        for (int i = 0; i < alunos.size(); i++) {
            Aluno aluno = alunos.get(i);
            if (aluno.getId().equals(alunoAtualizado.getId())) {
                alunos.set(i, alunoAtualizado);
                break;
            }
        }
    }

    // Método para remover um aluno pelo ID
    public void removerAluno(String id) {
        alunos.removeIf(aluno -> aluno.getId().equals(id));
    }

    // Método para obter todos os alunos
    public List<Aluno> obterTodosAlunos() {
        return alunos;
    }
}

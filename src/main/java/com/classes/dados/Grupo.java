package com.classes.dados;

import java.util.ArrayList;
import java.util.List;


public class Grupo {
    private int id;
    private int quantidadeGrupos;
    private int quantidadeAlunosPorGrupo;
    private List<Aluno> alunos;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getQuantidadeGrupos() {
        return quantidadeGrupos;
    }
    public void setQuantidadeGrupos(int quantidadeGrupos) {
        this.quantidadeGrupos = quantidadeGrupos;
    }
    public int getQuantidadeAlunosPorGrupo() {
        return quantidadeAlunosPorGrupo;
    }
    public void setQuantidadeAlunosPorGrupo(int quantidadeAlunosPorGrupo) {
        this.quantidadeAlunosPorGrupo = quantidadeAlunosPorGrupo;
    }

    // constructor
    public Grupo(int id, int quantidadeGrupos, int quantidadeAlunosPorGrupo) {
        this.id = id;
        this.quantidadeGrupos = quantidadeGrupos;
        this.quantidadeAlunosPorGrupo = quantidadeAlunosPorGrupo;
        this.alunos = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno) {
        if (alunos.size() < quantidadeAlunosPorGrupo) {
            alunos.add(aluno);
            System.out.println("Aluno " + aluno.getNome() + " adicionado ao Grupo " + id);
        } else {
            System.out.println("O Grupo " + id + " já atingiu o limite de alunos.");
        }
    }

    @Override
    public String toString() {
        return "Grupo{" +
                "id=" + id +
                ", quantidadeGrupos=" + quantidadeGrupos +
                ", quantidadeAlunosPorGrupo=" + quantidadeAlunosPorGrupo +
                ", alunos=" + alunos +
                '}';
    }
}

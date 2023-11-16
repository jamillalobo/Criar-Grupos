package com.classes.alunos;
import java.util.List;

import com.classes.avaliacao.AvaliacaoAluno;

import java.io.File;

public class Main {
    private List<Aluno> alunos;
    public static void main(String[] args) throws Exception {
        RegistroAluno reader = new RegistroAluno();
        reader.read(new File("src/main/resources/alunos.csv"));
        List<Aluno> alunos = reader.getAlunos();

        for (Aluno aluno : alunos) {
            AvaliacaoAluno avaliacao = new AvaliacaoAluno(aluno);
            avaliacao.avaliar();
        }
    }
}

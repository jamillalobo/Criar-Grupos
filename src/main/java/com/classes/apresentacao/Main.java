package com.classes.apresentacao;
import java.util.List;

import com.classes.dados.Aluno;
import com.classes.negocio.AvaliacaoAluno;
import com.classes.negocio.RegistroAluno;

import java.io.File;

public class Main {
    private List<Aluno> alunos;
    private List<AvaliacaoAluno> alunosComPonto;


    public static void main(String[] args) throws Exception {
        RegistroAluno reader = new RegistroAluno();
        reader.read(new File("src/main/resources/alunos.csv"));
        List<Aluno> alunos = reader.getAlunos();

        for (Aluno aluno : alunos) {
            AvaliacaoAluno avaliacao = new AvaliacaoAluno(aluno);
            avaliacao.avaliar();
        }

        // List<AvaliacaoAluno> alunosComPonto = new AvaliacaoAluno().getAlunosComPonto();
    }
}

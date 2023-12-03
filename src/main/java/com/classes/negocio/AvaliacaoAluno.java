package com.classes.negocio;

import java.util.List;


import com.classes.dados.Aluno;
import com.classes.dados.Avaliacao;

public class AvaliacaoAluno implements Avaliacao {
  int nota_idade;
  int nota_expprofissional;
  int nota_primeiragraducao;
  int nota_perfil;
  int score;
  int codscore;
  int codigo;
  Aluno alunos;

  @Override
  public void avaliarIdade() {
    if (alunos.getIdade() < 20) {
            nota_idade = 10;
        } else if (alunos.getIdade() >= 20 && alunos.getIdade() <= 25) {
          nota_idade = 100;
        } else if (alunos.getIdade() > 25 && alunos.getIdade() <= 30) {
          nota_idade = 200;        } 
        else {
          nota_idade = 300; 
        }
  }

  @Override
  public void avaliarExperienciaProfissional() {
    if (alunos.isExpprofissional() < 12) {
      nota_expprofissional = 10;
        } else if (alunos.isExpprofissional() >= 12 && alunos.isExpprofissional() <= 36) {
          nota_expprofissional = 100;
        } else if (alunos.isExpprofissional() > 36 && alunos.isExpprofissional() <= 120) {
          nota_expprofissional = 200;        } 
        else {
          nota_expprofissional = 300;	
        }
  }

  @Override
  public void avaliarPrimeiraGraduacao() {
    if (alunos.getPrimeiraGraduacao().equals("true")) {
      nota_primeiragraducao = 10;
    } else {
      nota_primeiragraducao = 100;		
    }
  }

  @Override
  public void avaliarPerfil() {
    if (alunos.getPerfil().equals("NF")) {
            nota_perfil = 1;
        } else if (alunos.getPerfil().equals("NT")) {
          nota_perfil = 2;
        } else if (alunos.getPerfil().equals("SJ")) {
          nota_perfil = 3;        
        } else {
          nota_perfil = 4; 
        }
  }		

  @Override
  public void avaliarScore() {
    score = nota_idade + nota_expprofissional + nota_primeiragraducao;
    if (score < 100) {
            codscore = 100;
        } else if (score >= 100 && score <= 200) {
          codscore = 200;
        } else if (score > 200 && score <= 300) {
          codscore = 300;}
    else if (score > 300 && score <= 400) {
          codscore = 400;   
    }
        else {
          codscore = 500; 
        }
  }

  @Override
  public void codigoEstudante() {
    codigo = codscore + nota_perfil;

  }

  public AvaliacaoAluno(Aluno alunos) {
    this.alunos = alunos;
  }

  public void avaliar() {
    avaliarIdade();
    avaliarExperienciaProfissional();
    avaliarPrimeiraGraduacao();
    avaliarPerfil();
    avaliarScore();
    codigoEstudante();
    System.out.println("Avaliação do aluno: " + alunos.getNome());
    // System.out.println("Nota idade: " + nota_idade);
    // System.out.println("Nota experiência profissional: " + nota_expprofissional);
    // System.out.println("Nota primeira graduacao: " + nota_primeiragraducao);
    // System.out.println("Nota perfil: " + nota_perfil);
    // System.out.println("Score: " + score);
    System.out.println("Código do estudante: " + codigo);
  }

  // criar metodo para retornar todos os codigos de estudantes
  public List<AvaliacaoAluno> getAlunosComPonto() {
    avaliar();
    return null;
  }
}



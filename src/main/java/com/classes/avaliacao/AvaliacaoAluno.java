package com.classes.avaliacao;

public class AvaliacaoAluno implements Avaliacao {
  int idade;
  int expprofissional;
  int nota_idade;
  int nota_expprofissional;
  boolean primeiragraduacao;
  int nota_primeiragraducao;
  String perfil;
  int nota_perfil;
  int score;
  int codscore;
  int codigo;

  @Override
  public void avaliarIdade() {
    if (idade < 20) {
            nota_idade = 10;
        } else if (idade >= 20 && idade <= 25) {
          nota_idade = 100;
        } else if (idade > 25 && idade <= 30) {
          nota_idade = 200;        } 
        else {
          nota_idade = 300; 
        }
  }

  @Override
  public void avaliarExperienciaProfissional() {
    if (expprofissional < 12) {
      nota_expprofissional = 10;
        } else if (expprofissional >= 12 && expprofissional <= 36) {
          nota_expprofissional = 100;
        } else if (expprofissional > 36 && expprofissional <= 120) {
          nota_expprofissional = 200;        } 
        else {
          nota_expprofissional = 300;	
        }
  }

  @Override
  public void avaliarPrimeiraGraduacao() {
    if (primeiragraduacao == true) {
      nota_primeiragraducao = 10;
    }
        else {
          nota_primeiragraducao = 100;		
  }
    }

  @Override
  public void avaliarPerfil() {
    if (perfil.equals("NF")) {
            nota_perfil = 1;
        } else if (perfil.equals("NT")) {
          nota_perfil = 2;
        } else if (perfil.equals("SJ")) {
          nota_perfil = 3;        } 
        else {
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
}

interface Avaliacao {
  void avaliarIdade();
  void avaliarExperienciaProfissional();
  void avaliarPrimeiraGraduacao();
  void avaliarPerfil();
  void avaliarScore();
  void codigoEstudante();
}

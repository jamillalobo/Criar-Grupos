package com.classes.dados;

public class Aluno {
    // atributos aluno
    private String id;
    private String nome;
    private int idade;
    private String genero;
    private int expprofissional;
    private String primeiraGraduacao;
    private String perfil;
    
    // construtor aluno
    public Aluno(String id, String nome, int idade, int expprofissional, String genero, String primeiraGraduacao, String perfil) {
        this.id = id;  
        this.nome = nome;
        this.idade = idade;
        this.expprofissional = expprofissional;
        this.genero = genero;
        this.primeiraGraduacao = primeiraGraduacao;
        this.perfil = perfil;
    }

    // get e set alunos
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int isExpprofissional() {
        return expprofissional;
    }

    public void setExpprofissional(int expprofissional) {
        this.expprofissional = expprofissional;
    }

    public String getPrimeiraGraduacao() {
        return primeiraGraduacao;
    }

    public void setPrimeiraGraduacao(String primeiraGraduacao) {
        this.primeiraGraduacao = primeiraGraduacao;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", experienciaProfissional=" + expprofissional +
                ", genero=" + genero +
                ", primeiraGraducao=" + primeiraGraduacao +
                ", perfil=" + perfil +
                '}';
    }
}

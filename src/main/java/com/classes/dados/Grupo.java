package com.classes.dados;

public class Grupo {
    private int id;
    private int quantidadeGrupos;
    private int quantidadeAlunosPorGrupo;

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
    }
}

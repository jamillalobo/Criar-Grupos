package com.classes.repositorio;

import java.util.ArrayList;
import java.util.List;

import com.classes.dados.Aluno;
import com.classes.dados.Grupo;

public class GrupoRepositorio {

    private static List<Grupo> grupos;

    public GrupoRepositorio() {
        GrupoRepositorio.grupos = new ArrayList<>();
    }

    // CREATE
    public void adicionarGrupo(Grupo grupo) {
        grupos.add(grupo);
    }

    // READ
    public Grupo obterGrupoPorId(int id) {
        for (Grupo grupo : grupos) {
            if (grupo.getId() == id) {
                return grupo;
            }
        }
        return null;
    }

    public List<Grupo> obterTodosGrupos() {
        return new ArrayList<>(grupos);
    }

    // UPDATE
    public void atualizarGrupo(Grupo grupoAtualizado) {
        for (int i = 0; i < grupos.size(); i++) {
            if (grupos.get(i).getId() == grupoAtualizado.getId()) {
                grupos.set(i, grupoAtualizado);
                return;
            }
        }
    }

    // DELETE
    public void excluirGrupo(int id) {
        grupos.removeIf(grupo -> grupo.getId() == id);
    }

    // ADICIONAR ALUNO
    public void adicionarAlunoAoGrupo(int grupoId, Aluno aluno) {
        for (Grupo grupo : grupos) {
            if (grupo.getId() == grupoId) {
                grupo.adicionarAluno(aluno);
                return;
            }
        }
        System.out.println("Grupo com ID " + grupoId + " não encontrado.");
    }
}


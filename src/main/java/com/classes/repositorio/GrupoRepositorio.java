package com.classes.repositorio;

import java.util.ArrayList;
import java.util.List;

import com.classes.dados.Aluno;
import com.classes.dados.Grupo;

public class GrupoRepositorio {

    private List<Grupo> grupos;

    public GrupoRepositorio() {
        this.grupos = new ArrayList<>();
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


    
    // public static void main(String[] args) {
    //     GrupoRepositorio grupoRepository = new GrupoRepositorio();

    //     // Exemplo de utilização
    //     Grupo grupo1 = new Grupo(1, 3, 5);
    //     grupoRepository.adicionarGrupo(grupo1);

    //     Grupo grupo2 = new Grupo(2, 2, 4);
    //     grupoRepository.adicionarGrupo(grupo2);

    //     // Listar todos os grupos
    //     List<Grupo> todosGrupos = grupoRepository.obterTodosGrupos();
    //     System.out.println("Todos os grupos: " + todosGrupos);

    //     // Obter um grupo por ID
    //     Grupo grupoEncontrado = grupoRepository.obterGrupoPorId(1);
    //     System.out.println("Grupo encontrado: " + grupoEncontrado);

    //     // Atualizar um grupo
    //     Grupo grupoAtualizado = new Grupo(1, 4, 6);
    //     grupoRepository.atualizarGrupo(grupoAtualizado);
    //     System.out.println("Grupo atualizado: " + grupoRepository.obterGrupoPorId(1));

    //     // Excluir um grupo
    //     grupoRepository.excluirGrupo(2);
    //     System.out.println("Grupos após exclusão: " + grupoRepository.obterTodosGrupos());
    // }
}


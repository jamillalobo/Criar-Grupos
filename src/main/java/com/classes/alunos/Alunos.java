package com.classes.alunos;

import java.io.File;

public class Alunos {
    public static void main(String[] args) throws Exception {
        RegistroAluno reader = new RegistroAluno();
        reader.read(new File("src/main/resources/alunos.csv"));
    }
}

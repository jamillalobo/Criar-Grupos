package com.classes.negocio;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;

import com.classes.dados.Aluno;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class LeituraPlanilha {
    private List<Aluno> alunos = new ArrayList<Aluno>();

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void read(File file) throws Exception {

        String [] record;
        CSVReader csvReader = null;

        try {
            csvReader = new CSVReaderBuilder(new FileReader(file))
                .withCSVParser(new CSVParserBuilder()
                    .withSeparator(',')
                    .build())
                .build();

            int currentLine = 0;

            csvReader.readNext();

            while ((record = csvReader.readNext()) != null) {

                System.out.println(
                    String.format(
                        "Line %d | id: %s | nome: %s | idade: %s | expprofissional: %s | genero: %s | primeiraGraduacao: %s | perfil: %s |", 
                        currentLine, 
                        record[0],  // Assuming record[0] is the value for id
                        record[1],  // Assuming record[1] is the value for nome
                        record[2],  // Assuming record[2] is the value for idade
                        record[3],  // Assuming record[3] is the value for expprofissional
                        record[4],  // Assuming record[4] is the value for genero
                        record[5],  // Assuming record[5] is the value for primeiraGraduacao
                        record[6]   // Assuming record[6] is the value for perfil
                    )
                );
                currentLine++;

                alunos.add(new Aluno(
                    record[0],  // Assuming record[0] is the value for id
                    record[1],  // Assuming record[1] is the value for nome
                    Integer.parseInt(record[2]),  // Assuming record[2] is the value for idade
                    Integer.parseInt(record[3]),  // Assuming record[3] is the value for expprofissional
                    record[4],  // Assuming record[4] is the value for genero
                    record[5],  // Assuming record[5] is the value for primeiraGraduacao
                    record[6]   // Assuming record[6] is the value for perfil
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error na leitura do arquivo CSV");
        } finally {
            //Close the reader
            if (csvReader != null) {
                csvReader.close();
            }
        }
    }
}

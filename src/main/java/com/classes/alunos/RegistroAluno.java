package com.classes.alunos;

import java.io.File;
import java.io.FileReader;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class RegistroAluno {

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

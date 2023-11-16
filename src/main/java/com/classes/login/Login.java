package com.classes.login;

import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
import java.util.Scanner;
import java.io.File;
/**
- como atualizar o arquivo de texto sem apagar as informações que estão ali
- menu principal e menu secundário
- adicionar critério no registro? p/ adm?

 * 
 */
public class Login 
{

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Ask_User();
    }


        public static void Ask_User()
            {

                String username, password;
                int choice;

                System.out.println("Por favor insira sua escolha: ");
                System.out.println("1 - Registrar");
                System.out.println("2 - Login ");

                choice = input.nextInt();

                if(choice == 1 )
                {
                    //register
                    Register();

                } else if (choice == 2) 
                {
                    //login
                    Loginn();

                } else
                {
                    System.out.print("Usuário ou senha incorretos. Tente novamente!");
                }
            }

        public static void Register()
            {
                Scanner input = new Scanner(System.in);
                String usn, pass;
                try 
                {
                FileWriter writer = new FileWriter("src/database/user.txt");
                System.out.println("==== REGISTRO USUÁRIO =====");
                System.out.print("Usuário: ");
                usn = input.nextLine();

                System.out.print("Senha: ");
                pass = input.nextLine();



                writer.write(usn + "-" + pass);
                writer.close();

                System.out.print("Registro efetuado com sucesso!");


                }
                catch (IOException ex){
                    System.out.print("Ocorreu um erro");
                }
            }

            public static void Loginn()
            {

                Scanner input = new Scanner(System.in);
                String _user, _pass;
                boolean _found = false;

                try {
                    File myobj = new File("src/database/user.txt");
                    Scanner myreader = new Scanner(myobj);

                    System.out.println("===== LOGIN =====");
                    System.out.print("Usuário: ");
                    String user = input.nextLine();

                    System.out.print("Senha: ");
                    String pass = input.nextLine();


                    while(myreader.hasNextLine())
                    {
                        String data = myreader.nextLine();
                        String[] acc = data.split("-");
                        _user = acc[0];
                        _pass = acc[1];

                        if (_user.equals(user) && _pass.equals(pass))
                        {
                            _found = true;
                        }
                    }

                    if (_found == true)
                    {
                        System.out.println("Login realizado com Sucesso!");
                    }
                    else
                    {
                        System.out.println("Acesso negado! Usuário ou senha inválidos.");
                    }

                    myreader.close();



                } catch (IOException ex) {
                    System.out.print("Ocorreu um erro!");
                }

            }

}



package br.ufrn.bti.banco1000.controller;

import java.util.Scanner;

import br.ufrn.bti.banco1000.model.Cliente;

public class UsuarioController {
    
    public Cliente cadastrar() {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe seu nome: ");
        String nome = scanner.nextLine();

        System.out.println("Informe seu CPF: ");
        String cpf = scanner.nextLine();
        
        String email = null;
        boolean valido = false;
        while (!valido) {
            System.out.println("Informe seu email: ");
            email = scanner.nextLine();
            if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                System.out.println("Email inválido");
            }
            else{
                valido = true;
            }
        }
        
        System.out.println("Informe seu telefone: ");
        String telefone = scanner.nextLine();

        Cliente cliente = new Cliente(nome, cpf, email, telefone);
        System.out.println("Cadastro realizado com sucesso!");
        
        return cliente;
    }
}

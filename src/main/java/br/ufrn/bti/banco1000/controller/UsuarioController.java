package br.ufrn.bti.banco1000.controller;

import br.ufrn.bti.banco1000.model.Cliente;

public class UsuarioController {
    
    public Cliente cadastrar() {
        

        String nome;
        String cpf;
        String email;
        String telefone;
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("Email inválido");
        }
        


        Cliente cliente = new Cliente(nome, cpf, email, telefone);
        return cliente;
    }
}

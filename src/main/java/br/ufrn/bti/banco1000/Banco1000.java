/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.ufrn.bti.banco1000;

import java.util.ArrayList;
import java.util.Scanner;

import br.ufrn.bti.banco1000.controller.ContaController;
import br.ufrn.bti.banco1000.controller.UsuarioController;
import br.ufrn.bti.banco1000.model.Cliente;
import br.ufrn.bti.banco1000.model.Conta;

/**
 *
 * @author vinicius
 */
public class Banco1000 {

    public static void main(String[] args) {
        
        UsuarioController uController = new UsuarioController();
        ContaController conController = new ContaController();

        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Conta> contas = new ArrayList<>();

        Cliente cliente = null;
        Conta conta = null;
        int opcao = 4;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n--------- Bem-vindo ao Banco 1000! ---------\n\n");
        
        while (opcao != 0) {  
            
            System.out.println("Escolha a opção desejada abaixo:\n");
            
            System.out.println("0 - Sair");
            System.out.println("1 - Realizar Cadastro");
            System.out.println("2 - Logar na conta");
            System.out.println("3 - Criar Conta");
            
            opcao = scanner.nextInt();
            
            switch (opcao) {
                case 0:
                    System.out.println("Saindo...");
                    break;
                case 1:
                    cliente = uController.cadastrar();
                    clientes.add(cliente);
                    break;
                case 2:
                    if(cliente != null){
                       Conta contaLogada = conController.logar(cliente, contas);
                    }
                    else{
                        System.out.println("Cliente não cadastrado.");
                    }
                    break;
                case 3:
                    if(cliente != null){
                        conta = conController.criarConta(cliente);
                        contas.add(conta);
                    }
                    else{
                        System.out.println("Cliente não cadastrado.");
                    }
                    break;
                default:
                throw new AssertionError();
            }
        
        }

    }
}

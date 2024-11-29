package br.ufrn.bti.banco1000.controller;

import java.util.ArrayList;
import java.util.Scanner;

import br.ufrn.bti.banco1000.model.Cliente;
import br.ufrn.bti.banco1000.model.Conta;

public class ContaController {

    public Conta criarConta(Cliente cliente){

        Scanner scanner = new Scanner(System.in);
        int numeroDaAgencia = 1;
        int numeroDaConta = numeroDaAgencia * 2;

        System.out.println("Escolha o tipo de conta que deseja possuir:\n1 - Poupança\n2 - Corrente");
        int tipoConta = 0;
        String tipoDeContaTexto = "";

        while (tipoConta != 1 && tipoConta != 2) {
            System.out.print("Digite o número correspondente ao tipo de conta: ");
            tipoConta = scanner.nextInt();
            scanner.nextLine();

            if (tipoConta == 1) {
                tipoDeContaTexto = "poupanca";
            } else if (tipoConta == 2) {
                tipoDeContaTexto = "corrente";
            } else {
                System.out.println("Valor inválido. Por favor, escolha 1 para Poupança ou 2 para Corrente.");
                tipoConta = 0;
            }
        }

        System.out.println("Digite uma senha numérica que deseja possuir em sua conta:");
        int senha = scanner.nextInt();

        //pedir dados do usuario pra criar conta
        Conta conta = new Conta();
        conta.setNome(cliente.getNome());
        conta.setCliente(cliente);
        conta.setAgencia(numeroDaAgencia + 1);
        conta.setNumeroConta(numeroDaConta);
        conta.setTipo(tipoDeContaTexto);
        conta.setSenha(senha);

        System.out.println("Conta criada com sucesso!");

        return conta;
    }

    public Conta logar(Cliente cliente, ArrayList<Conta> contas){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        String nome = scanner.nextLine();
        Conta contaLogada = null;

        for(Conta conta : contas){
            if(conta.getNome().equals(nome)){
                contaLogada = conta;
                break;
            }
        }

        if(contaLogada == null){
            System.out.println("Conta não encontrada.");
            return null;
        }        

        System.out.println("Digite sua senha: ");
        int senha = scanner.nextInt();

        if(contaLogada.getSenha() != senha){
            System.out.println("Senha inválida.");
            return null;
        }

        System.out.println("Login bem-sucedido! Bem-Vindo " + contaLogada.getNome());

        System.out.println("0 - Sair");
        System.out.println("1 - Visualizar Extrato");
        System.out.println("2 - Realizar Depósito");
        System.out.println("3 - Realizar Saque");
        System.out.println("4 - Realizar Transferência\n");
    
            int escolha = scanner.nextInt();
    
        switch (escolha) {
            case 0:
                System.out.println("Saindo...");
                break;
            case 1:
                break;
            case 2:           
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                throw new AssertionError();
        }

        return contaLogada;
    }
}

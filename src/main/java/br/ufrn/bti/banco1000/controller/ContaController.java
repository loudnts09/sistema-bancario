package br.ufrn.bti.banco1000.controller;

import java.util.ArrayList;
import java.util.Scanner;

import br.ufrn.bti.banco1000.model.Cliente;
import br.ufrn.bti.banco1000.model.Conta;

public class ContaController {

    private static int ultimoNumeroDaConta = 1000;

    public Conta criarConta(Cliente cliente){

        Scanner scanner = new Scanner(System.in);
        int numeroDaAgencia = 2828;
        int numeroDaConta = gerarNumeroDaConta();

        System.out.println("Escolha o tipo de conta que deseja possuir:\n1 - Poupança\n2 - Corrente");
        int tipoConta = 0;
        String tipoDeContaTexto = "";

        while (tipoConta != 1 && tipoConta != 2) {
            System.out.print("Digite o número correspondente ao tipo de conta: ");
            tipoConta = scanner.nextInt();
            scanner.nextLine();

            if(tipoConta == 1) {
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

        Conta conta = new Conta();
        conta.setNome(cliente.getNome());
        conta.setCliente(cliente);
        conta.setAgencia(numeroDaAgencia);
        conta.setNumeroConta(numeroDaConta);
        conta.setTipo(tipoDeContaTexto);
        conta.setSenha(senha);

        System.out.println("Conta criada com sucesso! Segue abaixo a visualização de seus dados pessoais.\n");

        System.out.println(
            "Nome: " + cliente.getNome() +
            "\nNumero: " + cliente.getTelefone() +
            "\nCPF: " + cliente.getCpf() +
            "\nEmail: " + cliente.getEmail() +
            "\nAgencia:" + conta.getAgencia() +
            "\nNumero da Conta: " + conta.getNumConta() +
            "\nTipo de conta: " + conta.getTipo() +
            "\nSenha: " + conta.getSenha()
            );
        

        return conta;
    }

    public Conta logar(Cliente cliente, ArrayList<Conta> contas){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        String nome = scanner.nextLine();
        Conta contaLogada = null;
        Conta destinatario = null;
        int escolha = 20;

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

        while(escolha != 0){
            System.out.println("\n0 - Sair");
            System.out.println("1 - Visualizar Extrato");
            System.out.println("2 - Realizar Depósito");
            System.out.println("3 - Realizar Saque");
            System.out.println("4 - Realizar Transferência");
            System.out.println("5 - Ver Saldo\n");
        
            escolha = scanner.nextInt();
            if(escolha > 5 ||  escolha < 0){
                System.out.println("Por favor selecione uma opção válida.");
                continue;
            }
        
            switch (escolha) {
                case 0:
                    System.out.println("Saindo...");
                    break;
                case 1:
                    contaLogada.exibirExtrato();
                    break;
                case 2:
                    System.out.println("Qual  valor deseja depositar? ");
                    int valor = scanner.nextInt();
                    if(valor <= 0){
                        System.out.println("Digite um valor válido.");
                    }
                    else{
                        contaLogada.depositar(valor);
                        System.out.println("Valor depositado com sucesso!");
                    }
                    break;
                case 3:
                    System.out.println("Qual valor deseja sacar? (insira o valor positivo)");
                    valor = scanner.nextInt();
                    if(valor <= 0){
                        System.out.println("Digite um valor válido.");
                    }
                    else{
                        contaLogada.sacar(valor);
                        System.out.println("Valor retirado com sucesso!");
                    }
                    break;
                case 4:
                    System.out.println("Digite o número da conta destinatária.");
                    int numeroDaContaDestino = scanner.nextInt();
                    for(Conta conta2 : contas){
                        if(conta2.getNumConta() == numeroDaContaDestino){
                            destinatario = conta2;
                            break;
                        }
                    }

                    if(destinatario == null){
                        System.out.println("Destinatário inválido");
                    }
                    else{
                        System.out.println("Qual valo deseja transferir? ");
                        valor = scanner.nextInt();
                        contaLogada.transferir(destinatario, valor);
                    }
                    break;
                case 5:
                    double saldo = contaLogada.getSaldo();
                    System.out.println("Saldo: " + String.format("%.2f", saldo));
                    break;
                default:
                    throw new AssertionError();
                }
        }
        return contaLogada;
    }

    private synchronized int gerarNumeroDaConta(){
        return ultimoNumeroDaConta++;
    }
}

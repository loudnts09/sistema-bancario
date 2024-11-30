/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufrn.bti.banco1000.model;

import java.util.ArrayList;

public class Conta {
    private String cpf;
    private Cliente cliente;
    private int agencia;
    private int numeroConta;
    private String tipo;
    private int senha;
    private double saldo = 0;
    private ArrayList<Movimentacao> movimentacao = new ArrayList<>();

    public Conta() {
    }
    
    public Conta(String cpf, int agencia, int numeroConta, String tipo, int senha, double saldo) {
        this.cpf = cpf;
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.tipo = tipo;
        this.senha = senha;
        this.saldo = saldo;
    }

    public int getNumConta(){
        return this.numeroConta;
    }   
    
    public void depositar(double valor) {
        this.saldo = this.saldo + valor;
        this.movimentacao.add(new Movimentacao("FORMA", this.cliente, "DEPOSITO", valor));
    }
    
    public void sacar(double valor) {
        if (this.saldo - valor >= 0) {
            this.saldo = this.saldo - valor;
            this.movimentacao.add(new Movimentacao("FORMA", this.cliente, "SAQUE", 
            valor));
        }
        else{
            System.out.println("Valor para saque indisponível.");
        }
    }
    
    public void transferir(Conta destinatario, double valor) {
        
        if (this.saldo - valor >= 0) {
           this.sacar(valor);
           destinatario.depositar(valor);
           destinatario.movimentacao.add(new Movimentacao("FORMA", this.cliente,"ENTRADA POR TRANSFERENCIA", valor));
           this.movimentacao.add(new Movimentacao("FORMA", this.cliente,"SAIDA POR TRANSFERENCIA", valor));
        }
        else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void exibirExtrato() {
        System.out.println("---- Extrato de Movimentações ----");
        if (movimentacao.isEmpty()) {
            System.out.println("Nenhuma movimentação registrada.");
        } else {
            for (Movimentacao m : movimentacao) {
                System.out.println(m);
            }
        }
        System.out.println("----------------------------------");
    }
    
    public String getCpf() {
        return this.cpf;
    }    
    
    public double getSaldo() {
        return this.saldo;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public ArrayList<Movimentacao> getMovimentacao() {
        return movimentacao;
    }
    
}

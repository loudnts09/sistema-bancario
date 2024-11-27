/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufrn.bti.banco1000.model;

import java.util.ArrayList;

public class Conta {
    private String nome;
    private Cliente cliente;
    private int agencia;
    private int numeroConta;
    private String tipo;
    private int senha;
    private double saldo;
    private ArrayList<Movimentacao> movimentacao = new ArrayList();

    public Conta(String nome, int agencia, int numeroConta, String tipo, int senha, double saldo, ArrayList movimentacao) {
        this.nome = nome;
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.tipo = tipo;
        this.senha = senha;
        this.saldo = saldo;
        this.movimentacao = movimentacao;
    }
    public int getNumConta(){
        return this.numeroConta;
    }
    public Conta(String nome, int agencia, int numeroConta, String tipo, int senha, double saldo) {
        this.nome = nome;
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.tipo = tipo;
        this.senha = senha;
        this.saldo = saldo;
    }
    
    public void depositar(double valor) {
        this.saldo = this.saldo + valor;
        this.movimentacao.add(new Movimentacao("FORMA", this.cliente, "DEPOSITO", 
            valor));
        
    }
    
    public void sacar(double valor) {
        if (this.saldo - valor >= 0) {
            this.saldo = this.saldo - valor;
            this.movimentacao.add(new Movimentacao("FORMA", this.cliente, "SAQUE", 
            valor));
            
        }
    }
    
    public void transferir(int agencia, int numeroConta, double valor) {
        if (this.saldo - valor >= 0) {
           this.saldo = this.saldo - valor; 
        }
    }
    
    public void transferir(Conta conta, double valor) {
        
         if (this.saldo - valor >= 0) {
           this.sacar(valor);
           conta.depositar(valor);
           conta.movimentacao.add(new Movimentacao("FORMA", this.cliente, 
                   "ENTRADA POR TRANSFERENCIA", valor));
           this.movimentacao.add(new Movimentacao("FORMA", this.cliente, 
                   "SAIDA POR TRANSFERENCIA", valor));
        }
    }
    
    public String getNome() {
        return this.nome;
    }    
    
    public double getSaldo() {
        return this.saldo;
    }
    
    @Override
    public boolean equals(Object o){
        return false;
    }
    
    @Override
    public String toString()
    {
        return "";
    }
}

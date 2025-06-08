/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gerenciadebanco;

import java.util.Scanner;

/**
 *
 * @author JOAO E ANA BEATRIZ
 */
class  Cliente{
    private String nome;
    private String sobrenome;
    private String cpf;
    private String extrato;
    private double saldo;
    
    public Cliente (String nome, String sobrenome,String cpf){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.extrato = "";
        this.saldo = 0.0;
    }
    
    //Metodo da classe cliente
    public void consultarSaldo(){
        System.out.println("Seu saldo atual R$ " + saldo);
} //Fim metodo consultarSaldo
    
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            extrato += "Depósito de R$" + valor + " -  em --/--/2025, às 00:00h\n";
            System.out.println("Deposito de R$ " + valor + " realizado com sucesso.");       
        } else {
            System.out.println("Valor de deposito invalido.");
        }
    } //fim do metodo depositar
    
    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            extrato += "Saque de R$" + valor + " - em --/--/2025, às 00:00h\n";
            System.out.println("Saque de R$ " + valor + " realizado com sucesso");
            
        } else {
            System.out.println("Saldo insuficiente ou valor do saldo ivalido");
        }    
    } //Fim do metodo sacar
    
    public void consultarExtrato(){
        System.out.println("====EXTRATO====");
        System.out.println(extrato);
    } //Fim do metodo consultarExtrato
} //Fim da classe cliente

public class GerenciaDeBanco{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe seu nome por favor");
        String nome = scanner.nextLine();
        System.out.println("Informe seu sobrenome por favor");
        String sobrenome = scanner.nextLine();
        System.out.println("Informe seu cpf por favor");
        String cpf = scanner.nextLine();
        //instanciando um objeto da classe cliente
        Cliente cliente = new Cliente(nome, sobrenome, cpf);
        
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n O que deseja :");
            System.out.println("1 - Consultar saldo");
            System.out.println("2 - Fazer deposito");
            System.out.println("3 - Fazer saque");
            System.out.println("4 - Consultar extrato");
            System.out.println("5 - Encerrar aplicacao\n\n");
            
            int escolha = scanner.nextInt();
            switch (escolha) {
                case 1:
                    cliente.consultarSaldo();
                    break;
                    
                case 2:
                    System.out.println("informe o valor a ser depositado:");
                    if (scanner.hasNextDouble()) {
                        double valorDeposito = scanner.nextDouble();
                        cliente.depositar(valorDeposito);
                    
                    } else {
                        System.out.println("Caractere inválido! Por favor insira apenas números.");
                        scanner.next();
                        
                    }
                    break;
                    
                case 3:
                    System.out.println("Informe o valor a ser sacado:");
                    if (scanner.hasNextDouble()){
                    double valorSaque = scanner.nextDouble();
                    cliente.sacar(valorSaque);
                    
                    } else {
                        System.out.println("Caractere inválido! Por favor, insira apenas números.");
                        scanner.next();
                        
                    }
                    break;
                    
                case 4:
                    cliente.consultarExtrato();
                    break;
                    
                case 5:
                    continuar = false;
                    System.out.println("Encerrando a aplicacao, ate breve");
                    break;
                    
                default:
                    System.out.println("Opcao invalida, tente novamente.");
                    
            }
        }
        scanner.close();
    }   
}

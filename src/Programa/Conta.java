package Programa;

import utilitarios.Utils;

public class Conta {

    private static int contadorDeContas =1;


    private int numeroConta;
    private Pessoa pessoa;
    private Double saldo = 0.0;

    public Conta( Pessoa pessoa) {
        this.numeroConta = contadorDeContas;
        this.pessoa = pessoa;
        contadorDeContas++;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    public String toString(){
        return"\nNumero da conta: " + this.getNumeroConta()+
                "\nNome: " + this.pessoa.getNome()+
                "\nCPF: " +  this.pessoa.getCpf()+
                "\nEmail: " + this.pessoa.getEmail() +
                "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
                "\n";

    }
    public void depositar(Double valor) {
        if(valor > 0) {
            setSaldo(getSaldo() + valor);
            System.out.println("Seu deposito foi realizado com sucesso");
        }else{
            System.out.println("Nao foi possivel realizar o deposito");
        }
    }
    public void sacar(Double valor){
        if(valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saque realizado com sucesso!");
        }else {
            System.out.println("Nao foi possivel realizar o saque!");
        }
    }

    public void transferir(Conta contaParaDeposito, Double valor) {
        if(valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            System.out.println("Transferencia realizada com sucesso");
        }else {
            System.out.println("Nao foi possivel realizar a transferencia");
        }
    }
}


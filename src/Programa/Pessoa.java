package Programa;

public class Pessoa {
    private static  int counter = 1;

    private String nome;
    private String cpf;
    private String email;
    private int id;



    public Pessoa(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.id = counter ++;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return  "\nID: " + this.id +
                "\nNome: "+ this.getNome() +
                "\nCPF: "+ this.getCpf() +
                "\nE-mail: "+ this.getEmail();

    }
}

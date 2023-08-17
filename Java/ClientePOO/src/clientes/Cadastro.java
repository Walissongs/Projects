package clientes;

import java.io.Serializable;

public class Cadastro implements Serializable {
    private int codigo;
    private String nome;
    public static int codigoStatic = 1;

    public Cadastro() {
        this("");
    }

    public Cadastro(String nome) {
        this.codigo = codigoStatic++;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Cadastro - Código: " + codigo + ", Nome: " + nome;
    }
}

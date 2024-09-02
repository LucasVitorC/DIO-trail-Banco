package Banco;

import java.util.Date;

public class Cliente {

    private static int contador = 101;
    private int codigo;
    private String nome;
    private Date dataCadastro;
    private String email;

    public Cliente(String nome, String email) {
		this.codigo = Cliente.contador++;
		this.nome = nome;
		this.email = email;
		this.dataCadastro = new Date();
	}

    public int getCodigo() {
		return this.codigo;
	}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataCadastro() {
        return this.dataCadastro;
    }

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    @Override
    public String toString() {
        return String.format("Código: %d\nNome: %s\nE-mail: %s\nData de Cadastro: %s",
                codigo, nome, email, dataCadastro);
    }
}

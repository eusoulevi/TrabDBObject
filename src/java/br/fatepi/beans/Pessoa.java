
package br.fatepi.beans;

import java.util.Objects;

/**
 *
 * @author levi.soares
 */
public class Pessoa {
    private String nome;
    private String sexo;
    private long cpf;    
    private Endereco endereco;
    
    public Pessoa () {}
    
    public Pessoa (String nome) {
        this.nome = nome;
    }

    public Pessoa (String nome, String sexo, long cpf) {
        this(nome);
        this.sexo = sexo;
        this.cpf = cpf;
    }

    public Pessoa (String nome, String sexo, long cpf, Endereco endereco) {
        this(nome, sexo, cpf);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public long getCpf() {
        return this.cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.nome);
        hash = 67 * hash + Objects.hashCode(this.sexo);
        hash = 67 * hash + (int) (this.cpf ^ (this.cpf >>> 32));
        hash = 67 * hash + Objects.hashCode(this.endereco);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (this.cpf != other.cpf) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", sexo=" + sexo + ", cpf=" + cpf + ", endereco=" + endereco + '}';
    }
       
}

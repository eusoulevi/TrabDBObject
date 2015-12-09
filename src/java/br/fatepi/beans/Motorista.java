
package br.fatepi.beans;

/**
 *
 * @author levi.soares
 */
public class Motorista extends Pessoa {
    private long cnh;

    public Motorista() {}

    public Motorista(long cnh) {
        super();
        this.cnh = cnh;
    }

    public Motorista(String nome) {
        super();
        this.setNome(nome);
    }

    public Motorista(long cnh ,String nome, String sexo, long cpf, Endereco endereco) {
        super(nome, sexo, cpf, endereco);
        this.cnh = cnh;
    }

    public long getCnh() {
        return this.cnh;
    }

    public void setCnh(long cnh) {
        this.cnh = cnh;
    }
    
}

package br.fatepi.beans;

/**
 *
 * @author levi.soares
 */
public class Engenheiro extends Pessoa {
    
    private long crea;
    public Engenheiro() {}
    
    public Engenheiro(long crea) {
        super();
        this.crea = crea;
    }
    
    public Engenheiro(String nome, String masculino, long cpf, Endereco end) {
        super(nome, nome, cpf, end);
    }
    
}

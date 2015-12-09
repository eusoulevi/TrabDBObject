
package br.fatepi.beans;


import br.fatepi.beans.Pessoa;

/**
 *
 * @author levi.soares
 */
public class Administrativo extends Pessoa{
    public Administrativo() {}
    
    public Administrativo(String nome, String sexo, long cpf) {
        super(nome, sexo, cpf);
    }

    public Administrativo(String nome, String sexo, long cpf, Endereco endereco) {
        super(nome, sexo, cpf, endereco);
    }
    
}

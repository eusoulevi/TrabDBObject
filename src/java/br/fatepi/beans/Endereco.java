
package br.fatepi.beans;

/**
 *
 * @author levi.soares
 */
public class Endereco {
    private String logradouro;
    private int numero;
    private String bairro;
    private long cep;
    private String cidade;
    private String uf;
    
    public Endereco() {}

    public Endereco(String rua, int n, String bairro, long cep, String cidade, String uf) {
        this.logradouro = rua;
        this.numero = n;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
    }
    
    public String getLogradouro() {
        return this.logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public long getCep() {
        return this.cep;
    }

    public void setCep(long cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return this.uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    
}

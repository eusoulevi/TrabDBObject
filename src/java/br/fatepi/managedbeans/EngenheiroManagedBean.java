
package br.fatepi.managedbeans;

import br.fatepi.beans.Engenheiro;
import br.fatepi.beans.Pessoa;
import com.db4o.ObjectSet;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 *
 * @author levi.soares
 */
@ManagedBean
public class EngenheiroManagedBean {
    private com.db4o.ObjectContainer db;
    private Engenheiro engenheiro;
    
    public EngenheiroManagedBean () {
        db = br.fatepi.Utility.getBD("funcionarios");
        engenheiro = new Engenheiro();
    }

    public void create(Pessoa pessoa) {
        db.store(pessoa);
    }

    public void destroy(String nome) {
        Pessoa p = new Pessoa();
        p.setNome(nome);
        ObjectSet result = db.queryByExample(p);
        Pessoa achado = (Pessoa)result.next();
        db.delete(achado);
    }


    public void edit(Pessoa pessoa) throws Exception {        
        ObjectSet result = db.queryByExample(pessoa);
        Pessoa achado = (Pessoa) result.next();
        db.store(achado);
    }


    public Pessoa find(String nome) {
        Pessoa p = new Pessoa(nome);
        ObjectSet result = db.queryByExample(p);
        Object get = result.get(0);
        return (Pessoa) get;
    }


    public List<Pessoa> list() {
        ObjectSet result = db.queryByExample(Pessoa.class);
        return result;
    }

    public int getCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

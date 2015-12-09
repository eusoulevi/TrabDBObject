
package br.fatepi.managedbeans;

import br.fatepi.beans.Motorista;
import br.fatepi.beans.Pessoa;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;




/**
 *
 * @author levi.soares
 */
@ManagedBean
@RequestScoped
public class MotoristaManagedBean {
    private ObjectContainer db;
    private Motorista motorista;
    private List<Motorista> motoristas = new ArrayList<>();
    
    public MotoristaManagedBean() {}

    @PostConstruct
    public void init() {
        db = br.fatepi.Utility.getBD("funcionarios");
        motorista = new Motorista();
    }
    
    public void create(Motorista motorista) {
        db.store(motorista);
    }

    public void destroy(String nome) {
        Pessoa p = new Pessoa();
        p.setNome(nome);
        ObjectSet result = db.queryByExample(p);
        Pessoa achado = (Pessoa)result.next();
        db.delete(achado);
        
    }

    public void edit(Motorista motorista) throws Exception {        
        ObjectSet result = db.queryByExample(motorista);
        Pessoa achado = (Pessoa) result.next();
        db.store(achado);
    }

    public Motorista find(String nome) {
        Motorista p = new Motorista(nome);
        ObjectSet result = db.queryByExample(p);
        Motorista get = (Motorista) result.get(0);
        return get;
    }

    public Motorista find(long cnh) {
        Motorista p = new Motorista(cnh);
        ObjectSet result = db.queryByExample(p);
        Object get = result.get(0);
        return (Motorista) get;
    }

    public List<Motorista> list() {
        ObjectSet result = db.queryByExample(Motorista.class);
        return result;
    }

    public int getCount() {
        int n = 0;
        if (list().isEmpty() || list()== null) {
            n = 0;
        } else {
            n = list().size();
        }
        return n;
    }

    public ObjectContainer getDb() {
        return this.db;
    }

    public void setDb(ObjectContainer db) {
        this.db = db;
    }

    public Motorista getMotorista() {
        return this.motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public List<Motorista> getMotoristas() {
        if (this.motoristas==null) {
            this.motoristas = list();
        }
        return this.motoristas;
    }

    public void setMotoristas(List<Motorista> motoristas) {
        this.motoristas = motoristas;
    }
    
}

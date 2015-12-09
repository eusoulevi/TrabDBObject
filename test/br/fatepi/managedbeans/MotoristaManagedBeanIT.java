
package br.fatepi.managedbeans;

import br.fatepi.beans.Endereco;
import br.fatepi.beans.Motorista;
import br.fatepi.beans.Pessoa;
import com.db4o.ObjectContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author levi.soares
 */
public class MotoristaManagedBeanIT {
    static MotoristaManagedBean dao;
    
    public MotoristaManagedBeanIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        dao = new MotoristaManagedBean();
        ObjectContainer db = dao.getDb();
        db = br.fatepi.Utility.getBD("testList");
        dao.setDb(db);
    }
    
    @AfterClass
    public static void tearDownClass() {
        List<Motorista> result = dao.list();
        for (Iterator<Motorista> iterator = result.iterator(); iterator.hasNext();) {
            Pessoa next = iterator.next();
            dao.getDb().delete(next);
        }
        dao.getDb().close();
    }
    
    @Before
    public void setUp() {
        dao.getDb().rollback();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class MotoristaManagedBean.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Endereco endereco = new Endereco("Minha Rua", 3, "Meu Bairro", 98765, "Teresina", "PI");
        Motorista expResult = new Motorista(98798, "levi", "Masculino", 96742500, endereco);
        dao.create(expResult);
        Pessoa result = dao.find("levi");
        assertEquals(expResult, result);
    }

    /**
     * Test of destroy method, of class MotoristaManagedBean.
     */
    @Test
    public void testDestroy() {
        System.out.println("destroy");
        
        long cnh = 121315;
        String nome = "Jonh";
        Motorista expResult = new Motorista(cnh);
        expResult.setNome(nome);
        expResult.setCpf(Long.parseLong("99945312399"));
        expResult.setSexo("masculino");
        Endereco endereco = new Endereco("Rua do Jonh", 10, "Bairro do Jonh", Long.parseLong("64001001"), "Timon City", "MA");
        expResult.setEndereco(endereco);
        
        dao.create(expResult);

        Pessoa result = dao.find(nome);
        assertEquals(expResult, result);        
        dao.destroy(nome);
        boolean contains = dao.list().contains(expResult);
        assertFalse(contains);
    }

    /**
     * Test of edit method, of class MotoristaManagedBean.
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        long cnh = 121315;
        Motorista expResult = new Motorista(cnh);
        expResult.setNome("João Batista");
        expResult.setCpf(Long.parseLong("96745312301"));
        expResult.setSexo("masculino");
        
        dao.create(expResult);
        Pessoa result = dao.find(cnh);
        assertEquals(expResult, result);

        // Alteração 
        expResult.setSexo("feminino");
        expResult.setCpf(Long.parseLong("11111111100"));
        dao.edit(expResult);
        Motorista result2 = dao.find(cnh);
        assertEquals(expResult.getCpf(), result2.getCpf());
        assertEquals(expResult.getSexo(), result2.getSexo());
    }

    /**
     * Test of find method, of class MotoristaManagedBean.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        String nome = "ellen";
        String sexo = "M";
        long cpf = Long.parseLong("98909887600");
        long cnh = Long.parseLong("1234567");
        Endereco end = new Endereco("Rua do Prof", 1, "Centro", 64000000, "Teresina", "PI");
        Motorista expResult = new Motorista(cnh, nome, sexo, cpf, end);
        dao.create(expResult);
        Pessoa result = dao.find(nome);
        assertEquals(expResult, result);
    }

    /**
     * Test of list method, of class MotoristaManagedBean.
     */
    @Test
    public void testList() {
        System.out.println("list");
        Motorista a = new Motorista(12354, "motorista4", "Masculino", 98788123, null);
        Motorista b = new Motorista(987654, "motorista5", "Feminino", 1234867, 
                new Endereco("Rua Dela", 1, "Centro", 64908098, "Teresina", "PI"));
        Motorista c = new Motorista(987654, "motorista6", "Feminino", 1234867, 
                new Endereco("Rua Brasil", 2, "Cristo Rey", 64900000, "Floriano", "PI"));

        dao.create(a);
        dao.create(b);
        dao.create(c);
        List<Motorista> expResult = new ArrayList<>();
        expResult.add(a);
        expResult.add(b);
        expResult.add(c);

        List<Motorista> result = dao.list();

        assertTrue(result.contains(a));
        assertTrue(result.contains(b));
        assertTrue(result.contains(c));
    }

    /**
     * Test of getCount method, of class MotoristaManagedBean.
     */
    @Test
    public void testGetCount() {
        System.out.println("getCount");
        
        Motorista m1 = new Motorista(12354, "motorista1", "Masculino", 98788123, null);
        Motorista m2 = new Motorista(987654, "motorista2", "Feminino", 1234867, 
                new Endereco("Rua Dela", 1, "Centro", 64908098, "Teresina", "PI"));
        Motorista m3 = new Motorista(987654, "motorista2", "Feminino", 1234867, 
                new Endereco("Rua Brasil", 2, "Cristo Rey", 64900000, "Floriano", "PI"));

        dao.create(m1);
        dao.create(m2);
        dao.create(m3);
        List<Motorista> motoristas = new ArrayList<>();
        motoristas.add(m1);
        motoristas.add(m2);
        motoristas.add(m3);

        int expResult = motoristas.size();
        int result = dao.getCount();
        assertEquals(expResult, result);

    }
    
}

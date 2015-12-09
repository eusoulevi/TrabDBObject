
package br.fatepi;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
/**
 *
 * @author levi.soares
 */
public class Utility {
    public static ObjectContainer db;
    
    public static ObjectContainer getBD(String nomeBanco) {
        db = Db4o.openFile(nomeBanco);
        return db;
    }
}

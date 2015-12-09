
package br.fatepi.managedbeans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author User
 */
@ManagedBean
@RequestScoped
public class HomeManagedBean {
   
    @PostConstruct
    public void init(){
        System.out.println(" Bean executado! ");
    } 
    
    public String getMessage(){
        return "Seja Bem vindo ao RH-WEB!";
    }
    
}

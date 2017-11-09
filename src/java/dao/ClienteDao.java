/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Cliente;


/**
 *
 * @author acg
 */
@Stateless
public class ClienteDao {

    @PersistenceContext
    EntityManager em;
    

    public List<Cliente> getList() {
        Query q = em.createQuery("select c from Cliente c");
        return q.getResultList();
    }

    public void gravar(Cliente object, boolean edit) {
        if (edit == false) {
            em.persist(object);
        } else {
            em.merge(object);
        }
    }

    public void excluir(Cliente object) {
        em.remove(em.merge(object));
    }

}

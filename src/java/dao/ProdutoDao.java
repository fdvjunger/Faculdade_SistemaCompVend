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
import model.Produto;


/**
 *
 * @author acg
 */
@Stateless
public class ProdutoDao {

    @PersistenceContext
    EntityManager em;
    

    public List<Produto> getList() {
        Query q = em.createQuery("select p from Produto p");
        return q.getResultList();
    }

    public void gravar(Produto object, boolean edit) {
        if (edit == false) {
            em.persist(object);
        } else {
            em.merge(object);
        }
    }

    public void excluir(Produto object) {
        em.remove(em.merge(object));
    }

}

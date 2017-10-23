/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encomienda.sessions;

import com.encomienda.entities.Clientes;
import com.encomienda.entities.Encomienda;
import com.encomienda.entities.Encomienda_;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author adsi1199561
 */
@Stateless
public class EncomiendaFacade extends AbstractFacade<Encomienda> {

    @PersistenceContext(unitName = "com.encomienda_encomiendas_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EncomiendaFacade() {
        super(Encomienda.class);
    }
    
      public List<Encomienda> findEncomienda(Integer id) {

        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Encomienda> cq = cb.createQuery(Encomienda.class);
        Root<Encomienda> user = cq.from(Encomienda.class);

        Predicate data = cb.conjunction();

    

        if (id != null) {
            data = cb.and(data, cb.equal(
                    user.get(Encomienda_.idClienteReceptor),new Clientes(id)));

        }
        
        cq.where(data);
        TypedQuery<Encomienda> tq = em.createQuery(cq);
        
        
        try {
            return tq.getResultList();
        } catch (Exception e) {
            return null;

        }
    }
    
}

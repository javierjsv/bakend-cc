/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encomienda.sessions;

import com.encomienda.entities.Clientes;
import com.encomienda.entities.Clientes_;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author adsi1199561
 */
@Stateless
public class ClientesFacade extends AbstractFacade<Clientes> {

    @PersistenceContext(unitName = "com.encomienda_encomiendas_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientesFacade() {
        super(Clientes.class);
    }
    
      public Clientes findByNumDocument(String numDocument) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Clientes> cq = cb.createQuery(Clientes.class);
        Root<Clientes> tercero = cq.from(Clientes.class);

        cq.where(cb.equal(tercero.get(Clientes_.numeroDocumento), numDocument));

        TypedQuery<Clientes> tq = getEntityManager().createQuery(cq);

        try {
            return (Clientes) tq.getSingleResult();
        } catch (NonUniqueResultException e) {
            throw e;
        } catch (NoResultException ex) {
            return null;

        }
    }
    
}

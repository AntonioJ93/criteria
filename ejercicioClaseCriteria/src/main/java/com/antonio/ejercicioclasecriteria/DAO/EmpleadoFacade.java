/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.antonio.ejercicioclasecriteria.DAO;

import com.antonio.ejercicioclasecriteria.Empleado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

/**
 *
 * @author pryet
 */
@Stateless
public class EmpleadoFacade extends AbstractFacade<Empleado> implements EmpleadoFacadeLocal {

    @PersistenceContext(unitName = "prod")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpleadoFacade() {
        super(Empleado.class);
    }

    @Override
    public void actualizarCriteria(Empleado entidad) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaUpdate<Empleado> update=cb.createCriteriaUpdate(Empleado.class);
        Root from=update.from(Empleado.class);
        update.set("nombre", entidad.getNombre());
        update.set("salario", entidad.getSalario());
        update.where(cb.equal(from.get("id"), entidad.getId()));
        em.createQuery(update).executeUpdate();
        
    }

    @Override
    public void removeCriteria(int id) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaDelete<Empleado> delete=cb.createCriteriaDelete(Empleado.class);
        Root from=delete.from(Empleado.class);
        delete.where(cb.equal(from.get("id"), id));
        em.createQuery(delete).executeUpdate();
    }
    
}

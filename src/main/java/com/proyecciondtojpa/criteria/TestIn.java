package com.proyecciondtojpa.criteria;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.proyecciondtojpa.criteria.Item;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author salvador
 */
public class TestIn {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        
//        em.getTransaction().begin();
//        Item i1=new Item("art1", 10.0);
//        Item i2=new Item("art2", 20.0);
//        Item i3=new Item("art3", 30.0);
//        Item i4=new Item("art4", 5.0);
//        em.persist(i1);
//        em.persist(i2);
//        em.persist(i3);
//        em.persist(i4);
//        
//        em.getTransaction().commit();
        
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Item> criteriaQuery = criteriaBuilder.createQuery(Item.class);
        Root<Item> root = criteriaQuery.from(Item.class);
        In<String> inClause = criteriaBuilder.in(root.get("itemName"));
        List<String> names = new ArrayList<>();
        names.add("art1");
        names.add("art2");
        
        Predicate mayorQ10=criteriaBuilder.gt(root.get("itemPrecio"), 10);
        Predicate losDos= criteriaBuilder.and(inClause,mayorQ10);
        
        for (String title : names) {
            inClause.value(title);
        }
        criteriaQuery.select(root).where(losDos);
        TypedQuery<Item> query=em.createQuery(criteriaQuery);
        List<Item> items=query.getResultList();
        
        for(Item item:items){
            System.out.println("itemName:"+item.getItemName()+ " precio:"+item.getItemPrecio());
        }
       

    }
}

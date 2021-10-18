/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.proyecciondtojpa.criteria.Item;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

/**
 *
 * @author salvador
 */
public class TestCriteriaUpdate {

    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("criteria_samples");
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaUpdate<Item> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Item.class);
     
        Root<Item> root = criteriaUpdate.from(Item.class);
        criteriaUpdate.set("itemPrice", 25);
        criteriaUpdate.where(criteriaBuilder.equal(root.get("itemPrice"), 10));

        em.getTransaction().begin();
        em.createQuery(criteriaUpdate).executeUpdate();
        em.getTransaction().commit();

    }
}

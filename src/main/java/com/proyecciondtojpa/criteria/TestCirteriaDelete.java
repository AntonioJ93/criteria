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
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

/**
 *
 * @author salvador
 */
public class TestCirteriaDelete {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("criteria_samples");
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaDelete<Item> criteriaDelete = criteriaBuilder.createCriteriaDelete(Item.class);
        Root<Item> root = criteriaDelete.from(Item.class);
        criteriaDelete.where(criteriaBuilder.greaterThan(root.get("itemPrice"), 20));

        em.getTransaction().begin();
        em.createQuery(criteriaDelete).executeUpdate();
        em.getTransaction().commit();
    }
}

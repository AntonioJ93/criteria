package com.proyecciondtojpa.criteria;




import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author salvador
 */
public class test_groupby {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
//        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
//        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
//
//        Root<Item> root = criteriaQuery.from(Item.class);
//        criteriaQuery.select(criteriaBuilder.count(root.get("itemPrecio"))).groupBy(root.get("itemPrecio")).
//                having( criteriaBuilder.gt(criteriaBuilder.count(root.get("itemPrecio")), 1));
//
//        TypedQuery<Long> typedQuery = em.createQuery(criteriaQuery);
//        List<Long> lista = typedQuery.getResultList();

        List<ConsultaDTO> lista=em.createQuery
        ("Select new com.proyecciondtojpa.criteria.ConsultaDTO(count(i), i.itemPrecio) From Item i Group By i.itemPrecio Having count(i) > 1 ").getResultList();
        
        //  Item_.itemName.
        for(ConsultaDTO d:lista){
        System.out.println(d);
        }

    }
}

package com.example.webcosmetic.EntityDB;

import com.example.webcosmetic.Entity.Cart;
import com.example.webcosmetic.Entity.DetailProduct;
import com.example.webcosmetic.Entity.LineItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class LineItemDB {

    public static void update(LineItem lineItem) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(lineItem);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }



    public List<LineItem> find(DetailProduct detailProduct) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            String jpql = "SELECT li FROM LineItem li WHERE li.detailProduct.id = :detailProductId";
            TypedQuery<LineItem> query = em.createQuery(jpql, LineItem.class);
            query.setParameter("detailProductId", detailProduct.getId());
            return query.getResultList();
        } finally {
            em.close();
        }
    }

}

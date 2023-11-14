package com.example.webcosmetic.EntityDB;

import com.example.webcosmetic.Entity.Cart;
import com.example.webcosmetic.Entity.DetailOrder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class OrderDB {
    public static Cart select(DetailOrder details) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            String jpql = "SELECT c FROM Cart c JOIN FETCH c.details l WHERE l.id = :detailsId";
            TypedQuery<Cart> query = em.createQuery(jpql, Cart.class);
            query.setParameter("detailsId", details.getId());
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }

    }
}

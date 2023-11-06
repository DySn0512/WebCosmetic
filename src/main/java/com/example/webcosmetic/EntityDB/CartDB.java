package com.example.webcosmetic.EntityDB;

import com.example.webcosmetic.ENTITY.Cart;
import com.example.webcosmetic.ENTITY.LineItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class CartDB {

    public static Cart select(LineItem lineItem) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            String jpql = "SELECT c FROM Cart c JOIN FETCH c.lineItems l WHERE l.id = :lineItemId";
            TypedQuery<Cart> query = em.createQuery(jpql, Cart.class);
            query.setParameter("lineItemId", lineItem.getId());
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }

    }
}

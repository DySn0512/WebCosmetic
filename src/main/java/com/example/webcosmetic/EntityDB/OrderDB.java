package com.example.webcosmetic.EntityDB;

import com.example.webcosmetic.Entity.Brand;
import com.example.webcosmetic.Entity.Cart;
import com.example.webcosmetic.Entity.DetailOrder;
import com.example.webcosmetic.Entity.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class OrderDB {

    public static void insert(Order order) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(order);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

}

package com.example.webcosmetic.EntityDB;


import com.example.webcosmetic.Entity.LineItem;
import jakarta.persistence.EntityManager;
import com.example.webcosmetic.Entity.Cart;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class CartDB {

    public static void insert(Cart cart){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(cart);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }

    }
}

package com.example.webcosmetic.EntityDB;


import com.example.webcosmetic.Entity.LineItem;
import com.example.webcosmetic.Entity.User;
import jakarta.persistence.EntityManager;
import com.example.webcosmetic.Entity.Cart;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
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

    public static Cart select(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        TypedQuery<Cart> query = em.createQuery("SELECT c FROM Cart c WHERE  c.user.id = :userId", Cart.class);
        query.setParameter("userId", user.getId());
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}

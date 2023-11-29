package com.example.webcosmetic.EntityDB;


import com.example.webcosmetic.Entity.Brand;
import com.example.webcosmetic.Entity.Cart;
import com.example.webcosmetic.Entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.List;

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

    public static void update(Cart cart) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(cart);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(Cart cart) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(cart));
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

}

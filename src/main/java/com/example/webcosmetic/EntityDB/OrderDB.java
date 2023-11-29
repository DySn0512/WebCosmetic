package com.example.webcosmetic.EntityDB;

import com.example.webcosmetic.Entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

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

    public static List<Order> selectByStatus(String status) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        TypedQuery<Order> query = em.createQuery("SELECT o FROM Order o WHERE o.status = :status", Order.class)
                .setParameter("status",status);
        return query.getResultList();
    }

    public static Order select(Long id) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            return em.find(Order.class, id);
        } finally {
            em.close();
        }
    }

    public static void update(Order order) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(order);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
}

package com.example.webcosmetic.EntityDB;

import com.example.webcosmetic.Entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class UserDB {

    public static void insert(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(user);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }


    public static User select(String phone, String password) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.phone = :phone AND u.password = :password", User.class);
        query.setParameter("phone", phone);
        query.setParameter("password", password);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}

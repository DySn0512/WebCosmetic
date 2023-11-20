package com.example.webcosmetic.EntityDB;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class AccountDB {


    public static Account select(String userName, String password) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        TypedQuery<Account> query = em.createQuery("SELECT a FROM Account a WHERE a.userName = :userName AND a.password = :password", Account.class);
        query.setParameter("userName", userName);
        query.setParameter("password", password);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    public static void insert(Account account){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(account);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }

    }

}

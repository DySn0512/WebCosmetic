package com.example.webcosmetic.EntityDB;

import com.example.webcosmetic.Entity.Account;
import jakarta.persistence.EntityManager;
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

}

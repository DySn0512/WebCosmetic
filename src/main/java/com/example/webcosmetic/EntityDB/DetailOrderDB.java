package com.example.webcosmetic.EntityDB;

import com.example.webcosmetic.Entity.DetailOrder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import static com.example.webcosmetic.EntityDB.DBUtil.getEmFactory;

public class DetailOrderDB {

    public static void update(DetailOrder detailOrder) {
        EntityManager em = getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(detailOrder);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
}

package com.example.webcosmetic.EntityDB;

import com.example.webcosmetic.Entity.DetailProduct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DetailProductDB {

    public static void update(DetailProduct detailProduct) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(detailProduct);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

}
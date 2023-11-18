package com.example.webcosmetic.EntityDB;

import com.example.webcosmetic.Entity.DetailProduct;
import com.example.webcosmetic.Entity.Product;
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

    public static DetailProduct select(Long id) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            return em.find(DetailProduct.class, id);
        } finally {
            em.close();
        }
    }

    public static void delete(DetailProduct detailProduct) {
        detailProduct.setPrice(0L);
        detailProduct.setUnit("0");
        detailProduct.setSalePrice(0L);
        update(detailProduct);
    }
}

package com.example.webcosmetic.EntityDB;

import com.example.webcosmetic.Entity.DetailProduct;
import com.example.webcosmetic.Entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

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

    public static List<DetailProduct> select(Product product) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        TypedQuery<DetailProduct> query = em.createQuery("SELECT d FROM DetailProduct d WHERE d.product.id=:id", DetailProduct.class)
                .setParameter("id",product.getId());
        return query.getResultList();
    }

    public static void delete(DetailProduct detailProduct) {
        detailProduct.setPrice(0L);
        detailProduct.setUnit("0");
        detailProduct.setSalePrice(0L);
        update(detailProduct);
    }
}

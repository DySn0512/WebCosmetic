package com.example.webcosmetic.EntityDB;

import com.example.webcosmetic.Entity.SubCategory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class SubCategoryDB {
    public static SubCategory select(Long id) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            SubCategory subCategory = em.find(SubCategory.class, id);
            return subCategory;
        } finally {
            em.close();
        }
    }

    public static void update(SubCategory subCategory) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(subCategory);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
}

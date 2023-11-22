package com.example.webcosmetic.EntityDB;

import com.example.webcosmetic.Entity.Brand;
import com.example.webcosmetic.Entity.Cart;
import com.example.webcosmetic.Entity.DetailProduct;
import com.example.webcosmetic.Entity.LineItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import javax.sound.sampled.Line;
import java.util.List;

public class LineItemDB {

    public static void update(LineItem lineItem) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(lineItem);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }




    public static LineItem select(long id){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            return em.find(LineItem.class, id);
        } finally {
            em.close();
        }
    }
}

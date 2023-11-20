package com.example.webcosmetic.EntityDB;

import com.example.webcosmetic.Entity.ProductCategory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ProductCategoryDB {
    public static List<ProductCategory> selectAll() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        TypedQuery<ProductCategory> query = em.createQuery("SELECT p FROM ProductCategory p", ProductCategory.class);
        return query.getResultList();
    }

    public static void insert(ProductCategory productCategory) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(productCategory);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static ProductCategory select(Long id) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            ProductCategory productCategory = em.find(ProductCategory.class, id);
            return productCategory;
        } finally {
            em.close();
        }
    }

    public static void update(ProductCategory productCategory) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(productCategory);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(ProductCategory productCategory) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.remove(em.merge(productCategory));
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }
    public static List<ProductCategory> getBreadcrumbCategoriesForProduct(String productName) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            TypedQuery<ProductCategory> query = em.createQuery(
                    "SELECT pc FROM ProductCategory pc JOIN pc.subCategories sc JOIN sc.products p WHERE p.name = :productName",
                    ProductCategory.class);
            query.setParameter("productName", productName);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}

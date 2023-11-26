package com.example.webcosmetic.EntityDB;

import com.example.webcosmetic.Entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ProductDB {

    public static void insert(Product product) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(product);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(Product product) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        for (var detail : product.getDetails()) {
            detail.setNullProduct();
            DetailProductDB.delete(detail);
        }
        trans.begin();
        try {
            em.remove(em.merge(product));
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void update(Product product) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.merge(product);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static Product select(Long id) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            return em.find(Product.class, id);
        } finally {
            em.close();
        }
    }

    public static List<Product> selectAll() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p", Product.class);
        return query.getResultList();
    }

    public static List<Product> selectProductsByOffset(int offset, int recordsPerPage) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p", Product.class)
                    .setFirstResult(offset)
                    .setMaxResults(recordsPerPage);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public static int getTotalProducts() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            TypedQuery<Long> query = em.createQuery("SELECT COUNT(p) FROM Product p", Long.class);
            return query.getSingleResult().intValue();
        } finally {
            em.close();
        }
    }

    public static Product selectProductByName(String productName) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.name = :productName", Product.class)
                    .setParameter("productName", productName);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null; // Trả về null nếu không tìm thấy sản phẩm có tên tương ứng
        } finally {
            em.close();
        }
    }

    public static List<Product> selectProductByBrand(String brandName, String isSale) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String jpqlQuery = "SELECT p FROM Product p WHERE p.brand.name = :brandName";
        if (isSale.equals("true")) {
            jpqlQuery = "SELECT DISTINCT p FROM Product p JOIN FETCH p.details d WHERE p.brand.name = :brandName AND d.isSale = true";
        } else if (isSale.equals("false")) {
            jpqlQuery = "SELECT DISTINCT p FROM Product p JOIN FETCH p.details d WHERE p.brand.name = :brandName AND d.isSale = false ";
        }
        TypedQuery<Product> query = em.createQuery(jpqlQuery, Product.class)
                .setParameter("brandName", brandName);
        return query.getResultList();
    }

    public static List<Product> selectProductByCategory(String categoryName) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.productCategory.name = :categoryName", Product.class)
                .setParameter("categoryName", categoryName);
        return query.getResultList();
    }

    public static List<Product> selectProductBySubCategory(String subCategoryName) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.subCategory.name = :subCategoryName", Product.class)
                .setParameter("subCategoryName", subCategoryName);
        return query.getResultList();
    }

    public static List<Product> selectProductBySimilarName(String similarName) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.name = :similarName", Product.class)
                .setParameter("similarName", similarName);
        return query.getResultList();
    }

}

package demo.demoweb.DB;

import demo.demoweb.ENTITY.Product;
import demo.demoweb.Util.DBUtil;
import jakarta.persistence.*;

import java.util.List;

public class ProductDB {

    public static List<Product> selectProducts(int indexStart, int numProducts) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String jpql = "SELECT p FROM Product p " +
                "JOIN FETCH p.brand " +
                "JOIN FETCH p.productCategory " +
                "JOIN FETCH p.subCategory " +
                "JOIN FETCH p.details " +
                "JOIN FETCH p.images " +
                "JOIN FETCH p.keyWords";
        TypedQuery<Product> query = em.createQuery(jpql, Product.class);
        query.setFirstResult(indexStart);
        query.setMaxResults(numProducts);
        try {
            List<Product> products = query.getResultList();
            return products;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

}

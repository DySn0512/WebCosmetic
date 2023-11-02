package demo.demoweb.Util;

import jakarta.persistence.*;

public class DBUtil {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("web");
    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
}

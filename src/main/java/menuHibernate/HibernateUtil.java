package menuHibernate;
import javax.persistence.*;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.security.auth.login.AppConfigurationEntry;
import javax.security.auth.login.Configuration;

public class HibernateUtil {
   private static EntityManagerFactory emf;
   private static EntityManager em;

    public HibernateUtil() {
    }
public void getEntity() {
    System.out.println("1");
    try {
        emf = Persistence.createEntityManagerFactory("Menu");
    } catch (Exception e) {
        e.printStackTrace();
    }
    System.out.println("2");
    try {
        em = emf.createEntityManager();
    } catch (Exception e) {
        e.printStackTrace();
    }

}
public static EntityManager getEM(){
        return em;
}
    public void closeEntity(){
        em.close();
        emf.close();
    }
}

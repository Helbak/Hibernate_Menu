package tryHibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TryHibernate {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Menu2");
        EntityManager em = emf.createEntityManager();

        TryMenu trym = new TryMenu();

        try {
            em.getTransaction().begin();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            System.out.println(em.find(TryMenu.class, 1));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

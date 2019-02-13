package menuHibernate;

import javax.persistence.*;

@Entity
@Table(name = "Menu")
public class Menu {
    @Id
    @GeneratedValue
    private Long id;
    private String dishname;
    private Double price;
    private Double weight;
    private Double discount;

@Transient
private static EntityManager em;
@Transient
private Menu dish;
    public Menu() {
    }

    public Menu(String dishname, Double price, Double weight, Double discount) {
        this.dishname = dishname;
        this.price = price;
        this.weight = weight;
        this.discount = discount;
    }
    public void addDish(Menu dish){
        dish= this;
        em=HibernateUtil.getEM();
        try {
em.getTransaction().begin();
            em.persist(dish);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getDish(){
        em=HibernateUtil.getEM();
       Menu d= em.find(Menu.class,1L);
        System.out.println(d);
    }
    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", dishname='" + dishname + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", discount=" + discount +
                '}';
    }
}

package menuHibernate;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Menu")
public class Menu {
    @Id
    @GeneratedValue
    private Long id;
    private String dishname;
    private Double price;
    private Long weight;
    private Double discount;

@Transient
private static EntityManager em;
@Transient
private Menu dish;
    public Menu() {
    }

    public Menu(String dishname, Double price, Long weight, Double discount) {
        this.dishname = dishname;
        this.price = price;
        this.weight = weight;
        this.discount = discount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDishname() {
        return dishname;
    }

    public void setDishname(String dishname) {
        this.dishname = dishname;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public static EntityManager getEm() {
        return em;
    }

    public static void setEm(EntityManager em) {
        Menu.em = em;
    }

    public void setDish(Menu dish) {
        this.dish = dish;
    }

    public void addDish(Menu dish){
        dish= this;
        em=HibernateUtil.getEM();
//        System.out.println(" (MENU) What is this em????????? "+ em);
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
//        System.out.println("What is this em????????? ");
//        Set <Menu> m = em.
        for(long i=1; i<=8; i++) {
            Menu d = em.find(Menu.class, i);
            System.out.println(d);
        }
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

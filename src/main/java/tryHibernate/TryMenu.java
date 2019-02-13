package tryHibernate;


import javax.persistence.*;

@Entity
@Table(name = "Menu")

public class TryMenu {
    @Id
    @GeneratedValue
    private Long id;
    private String dishname;
    private Double price;
    private Double weight;
    private Double discount;

    @Transient
    private static EntityManager em;

    public TryMenu() {
    }

    public TryMenu(String dishname, Double price, Double weight, Double discount) {
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

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "TryMenu{" +
                "id=" + id +
                ", dishname='" + dishname + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                ", discount=" + discount +
                '}';
    }
}

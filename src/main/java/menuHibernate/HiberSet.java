package menuHibernate;

import javax.persistence.EntityManager;
import java.util.Scanner;

public class HiberSet {
    private static EntityManager em;
    private String dishname;
    private Double price;
    private Double weight;
    private Double discount;

    public HiberSet() {
    }
    public void setDish(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of the dish");
        String dis = sc.nextLine();
        dishname = "'"+dis+"'";
        System.out.println("Enter price");
        price=sc.nextDouble();
        System.out.println("Enter weight");
        weight=sc.nextDouble();
        System.out.println("Enter discount");
        discount=sc.nextDouble();
        Menu dish = new Menu(dishname, price, weight, discount);
        Menu d = new Menu();
        d.addDish(dish);
    }


}

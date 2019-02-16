package menuHibernate;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HiberSetGet {
    private static EntityManager em;
    private String dishname;
    private Double price;
    private Long weight;
    private Double discount;
    private List<Menu> menuList;
    private List<Menu> orderList;


    public HiberSetGet() {
    }

    public void setDish() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of the dish");
        System.out.println("===>");
        dishname = sc.nextLine();
//        dishname = "'"+dis+"'";
        System.out.println("Enter price");
        System.out.println("===>");
        price = sc.nextDouble();
        System.out.println("Enter weight");
        System.out.println("===>");
        weight = sc.nextLong();
        System.out.println("Enter discount");
        System.out.println("===>");
        discount = sc.nextDouble();
        Menu dish = new Menu(dishname, price, weight, discount);
//        Menu d = new Menu();
//        d.addDish(dish);
        dish.addDish(dish);
    }

    public void getDish() {
        Long weight;
        Long sumWeight = null;
        Order order = new Order();
         menuList = order.requestDB();
        orderList = order.requestClient();

        System.out.println("Your order:");
        for (int i = 1; i < orderList.size(); i++) {
            Menu n = orderList.get(i);
            weight = n.getWeight();
            sumWeight = + weight;

            System.out.println(orderList.get(i));

        }
        System.out.println("total weight of your order = "+sumWeight);
        System.out.println();

    }
}

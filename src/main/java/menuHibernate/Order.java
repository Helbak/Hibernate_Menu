package menuHibernate;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {
    private String dishname;
    private Double price;
    private Long weight;
    private Double discount;
    List<Menu> menuList;
    List<Menu> orderList = new ArrayList<Menu>();
    private static EntityManager em;

    public Order() {

    }

    public List<Menu> requestDB (){
        em = HibernateUtil.getEM();
        System.out.println(" Choose the dishes from menu ");
        Query query = em.createQuery("FROM Menu ", Menu.class);
        menuList = query.getResultList();


        for (int i = 1; i < menuList.size(); i++) {
            System.out.println(menuList.get(i));
        }

        return menuList;
    }

    public List<Menu> requestClient (){
        while (true) {
            Long sumWeight=null;
            Long weight;
            System.out.println("For order the dish enter id of dishes or enter 0 for finish order");

            Scanner sc = new Scanner(System.in);
            int choose = sc.nextInt();
            if (choose > 0 && choose < menuList.size()) {

                Menu m = menuList.get(choose);
                System.out.println(m);

                orderList.add(m);

                for (int i=0; i<orderList.size(); i++) {
                    Menu n = orderList.get(i);
                    weight = n.getWeight();
                    String d = n.getDishname();
                    System.out.println("Weight of " + d + " = "+ weight);
                    sumWeight =  + weight;
                    System.out.println("total weight of your order = "+sumWeight);
                }

//                    System.out.println("total weight of your order = ");

            }
            if (choose <= 0 || choose >= menuList.size()) {

                return orderList;
            }
//
        }
    }
}

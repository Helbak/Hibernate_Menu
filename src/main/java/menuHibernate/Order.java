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
    private  Long sumWeight;
    List<Menu> menuList;
    List<Menu> orderList = new ArrayList<Menu>();
    private static EntityManager em;
    private CalculatorWeight clc = new CalculatorWeight();

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

            Long weight;
            System.out.println("For order the dish enter id of dishes or enter 0 for finish order");

            Scanner sc = new Scanner(System.in);
            int choose = sc.nextInt();
            if (choose > 0 && choose < menuList.size()) {

                Menu m = menuList.get(choose);
                System.out.println("You chose " + m.getDishname()+" It's discount = "+m.getDiscount());
if(m.getDiscount()>0){
                orderList.add(m);
                clc.addWeight(m.getWeight());

    System.out.println(" ... and "+m.getDishname()+"   added to order. Total weight = "+clc.getSumWeight());
}
if (m.getDiscount()==0){
    System.out.println(" ... and "+m.getDishname()+"  did not added to order");
}



            }
            if (choose <= 0 || choose >= menuList.size()) {
                System.out.println("You have finished order");
                System.out.println("total weight of your order = "+clc.getSumWeight());
//

                return orderList;
            }
//
        }
    }
}

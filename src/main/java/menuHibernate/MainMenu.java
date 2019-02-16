package menuHibernate;

import java.util.Scanner;

public class MainMenu {


    public static void main(String[] args) {
        HiberSetGet hs = new HiberSetGet();
        HibernateUtil hut = new HibernateUtil();
//        hut.getEntity();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter 1 to add new dish to the menu");
            System.out.println("Enter 2 to order from menu");
            System.out.println("===>");
            int c = sc.nextInt();

            if (c == 1) {
                System.out.println("Method add to menu");
                hs.setDish();
            }
            if (c == 2) {
                System.out.println("Method order from menu");
               hs.getDish();

            }
            if (c != 1 && c != 2) {
                hut.closeEntity();
                return;
            }
        }
    }
}

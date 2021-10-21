package Controllers;

import config.Db;
import models.Product;

import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Db db = new Db();
        int i = -1;
        while (i != 3) {
            System.out.println("1=>Add Product\n2=>List Product\n3=>Exit");
            i = scanner.nextInt();
            scanner = new Scanner(System.in);
            switch (i) {
                case 1:
                    System.out.println("Enter product's model");
                    int model = scanner.nextInt();
                    System.out.println("Enter product's maker");
                    scanner = new Scanner(System.in);
                    String maker = scanner.nextLine();
                    System.out.println("Enter product's type");
                    String type = scanner.nextLine();
                    Product product = new Product(maker,model,type);
                    db.addProduct(product);
                    break;
                case 2:
                    db.getList();
                    break;
                case 3:
                    break;

            }

        }
    }
}

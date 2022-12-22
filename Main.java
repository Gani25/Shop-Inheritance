import models.Shirt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import models.Pants;
import models.Product;

public class Main {

    static final String FILE_NAME = "products.txt";

    public static void main(String[] args) {

        try {
            Product[] products = getData();
            printArray(products);
            Arrays.sort(products);
            System.out.println("After Sorting");
            printArray(products);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        /*
         * Shirt s1 = new Shirt(100, "blue", "Adidas", Shirt.Size.MEDIUM);
         * Pants p1 = new Pants(24.99, "blue", "Java Klein", 32);
         * 
         * Pants p2 = new Pants(104.99, "red", "Jangler", 28);
         * Pants p3 = new Pants(p1);
         * System.out.println(p1.compareTo(p2));
         * // System.out.println(p1.compareTo(p3));
         * // Shirt s2 = new Shirt(s1);
         * // System.out.println(s1.hashCode());
         * // System.out.println(s2.hashCode());
         * 
         * // System.out.println(s1);
         * // p1.discount();
         * // System.out.println(p1);
         */
    }

    public static void printArray(Product[] array) {
        System.out.println("\nProducts:\n");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * Function Name: getData
     * 
     * @return Product[]
     * @throws FileNotFoundException
     * 
     *                               Inside the function:
     *                               1. Loads the data from products.txt
     */

    public static Product[] getData() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(FILE_NAME);
        Scanner sc = new Scanner(fis);
        Product[] product = new Product[18];
        for (int i = 0; sc.hasNext(); i++) {
            switch (sc.next()) {
                case "PANTS":
                    product[i] = new Pants(sc.nextInt(), sc.nextDouble(), sc.next(), sc.next());
                    break;
                case "SHIRT":
                    product[i] = new Shirt(Shirt.Size.valueOf(sc.next()), sc.nextDouble(), sc.next(), sc.next());
                    break;

            }
        }
        sc.close();
        return product;

    }
}

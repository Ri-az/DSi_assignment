/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem1;

import java.util.Scanner;

/**
 *
 * @author Jakir Hossain Riaz
 */
public class Problem1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ProductManager pm = new ProductManager();
        while (true) {
            System.out.println("Enter 1 to Add product,\n2 to Delete product,\n3 to Buy Product,\n4 to sell product,\n5 to Show the list of products,\n6 to  Show available balance,\nany other key to exit:");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            if (choice == 1) {
                System.out.println("\t\t-----------------------Product Insertion-----------------------");
                boolean result = pm.addProduct();
                if (result == true) {
                    System.out.println("Product added successfully.");
                } else {
                    System.out.println("Product insertion error");
                }
            }else if(choice == 2){
                System.out.println("\t\t-----------------------Product Deletion-----------------------");
                Scanner in = new Scanner(System.in);
                System.out.println("Product Name:");
                String name = in.nextLine();
                System.out.println("\n");
                boolean result = pm.delproduct(name);
                if (result == true) {
                    System.out.println("Product deleted successfully.");
                } else {
                    System.out.println("Product deletion error");
                }
            }else if (choice == 3) {
                System.out.println("\t\t-----------------------Buy Product-----------------------");
                Scanner in = new Scanner(System.in);
                System.out.println("Product Name:");
                String name = in.nextLine();
                System.out.println("Product Quantity:");
                int qnt = in.nextInt();
                System.out.println("\n");
                pm.buyProduct(name, qnt);               
            } else if (choice == 4) {
                System.out.println("\t\t-----------------------Sell Product-----------------------");
                Scanner in = new Scanner(System.in);
                System.out.println("Product Name:");
                String name = in.nextLine();
                System.out.println("Product Quantity:");
                int qnt = in.nextInt();
                System.out.println("\n");
                pm.sellProduct(name, qnt);
                
            }else if (choice == 5) {
                System.out.println("\t\t-----------------------Product List-----------------------");
                pm.show();
            }else if (choice == 6) {
                System.out.println("\t\t-----------------------Available Balance-----------------------");
                pm.showBalance();
                System.out.println("\n");
            }else{
                break;
            }
            System.out.println("--------------------------------------------------------------------------------------------------------");
        }
    }
}

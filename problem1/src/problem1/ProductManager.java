/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jakir Hossain Riaz
 */
public class ProductManager {

    private ArrayList<ProductInfo> productlist;
    private double available_balance;

    ProductManager() {
        productlist = new ArrayList<ProductInfo>();
        available_balance = 0;
    }
    
    public double getAvailable_balance() {
        return available_balance;
    }

    public void setAvailable_balance(double available_balance) {
        this.available_balance = available_balance;
    }

    public boolean addProduct() {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Product Name:");
            String namep = in.nextLine();
            System.out.println("Product Buy Price:");
            double buyp = in.nextDouble();
            System.out.println("Product Sell Price:");
            double sellp = in.nextDouble();
            System.out.println("Product Available in the Inventory to sell:");
            int availablep = in.nextInt();
            System.out.println("Product Selling Total Profit:");
            double profit = in.nextDouble();
            ProductInfo pro = new ProductInfo(namep, buyp, sellp, availablep, profit);
            productlist.add(pro);
            System.out.println("\n");
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public ProductInfo getProduct(String name) {
        for (int i = 0; i < productlist.size(); i++) {
            ProductInfo p = productlist.get(i);
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }
    
    public boolean delproduct(String name){
        for (int i = 0; i < productlist.size(); i++) {
            ProductInfo p = productlist.get(i);
            if (p.getName().equals(name)) {
                productlist.remove(i);
                return true;
            }
        }
        return false;
    }

    public void buyProduct(String name, int qnt) {
        ProductInfo p = getProduct(name);
        if (p != null && check_balance(p.getSellprice(), qnt)) {
            p.updateinventory(qnt);
            balanceUpdate(p.getBuyprice(), qnt, "buy");
            System.out.println("Product bought successfully.");
        }else if(p==null){
            System.out.println("This porduct is not available");
        }else{
            System.out.println("Insufficient balance!!!");
        }
    }

    public void sellProduct(String name, int qnt) {
        ProductInfo p = getProduct(name);
        if (p != null) {
            boolean result = p.updateinventory(-1 * qnt);
            if (result == true) {
                p.updateProfit(qnt);
                balanceUpdate(p.getSellprice(), qnt, "sell");
                System.out.println("Product sold successfully.");
            }else{
                System.out.println("Product sell error");
            }
        }else{
            System.out.println("Product is not available");
        }
    }

    public void show() {
        String heading = String.format("%-" + 40 + "s", "Name")+String.format("%-" + 40 + "s", "Quantity")+"Profit\n";
        System.out.println(heading);
        for (int i = 0; i < productlist.size(); i++) {
            System.out.println(productlist.get(i).output());
        }
    }
    
    public void showBalance(){
        System.out.println("Available Balance: "+available_balance);
    }

    public void balanceUpdate(double price, int qnt, String op) {
        if(op.equals("buy")){
            this.available_balance -= price * qnt;
        }else if(op.equals("sell")){
            this.available_balance += price * qnt;
        }
    }

    public boolean check_balance(double sellprice, int qnt) {
        if (qnt > 0) {
            double bill = sellprice * qnt;
            if (available_balance >= bill) {
                return true;
            }
        }
        return false;
    }
}

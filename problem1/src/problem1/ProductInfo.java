/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem1;

/**
 *
 * @author Jakir Hossain Riaz
 */
public class ProductInfo {
    private String name;
    private double buyprice;
    private double sellprice;
    private int availableproduct;
    private double totalprofit;
    
    public ProductInfo(String name,double buy,double sell,int available,double profit){
        this.name=name;
        this.buyprice=buy;
        this.sellprice=sell;
        this.availableproduct=available;
        this.totalprofit=profit;
    }
    
    public ProductInfo(String name,double buy,double sell){
        this.name=name;
        this.buyprice=buy;
        this.sellprice=sell;
        this.availableproduct=0;
        this.totalprofit=0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBuyprice() {
        return buyprice;
    }

    public void setBuyprice(double buyprice) {
        this.buyprice = buyprice;
    }

    public double getSellprice() {
        return sellprice;
    }

    public void setSellprice(double sellprice) {
        this.sellprice = sellprice;
    }

    public int getAvailableproduct() {
        return availableproduct;
    }

    public void setAvailableproduct(int availableproduct) {
        this.availableproduct = availableproduct;
    }

    public double getTotalprofit() {
        return totalprofit;
    }

    public void setTotalprofit(double totalprofit) {
        this.totalprofit = totalprofit;
    }
    
    public boolean updateinventory(int num){
        int current_qnt = this.availableproduct;
        int check =  current_qnt + num;
        if(check>0){
            this.availableproduct = check;
            return true;
        }else{
            return false;
        }
    }
    
    public void updateProfit(double qnt){
        this.totalprofit += (this.sellprice - this.buyprice)*qnt;
    }
    public String output(){
        return (String.format("%-" + 40 + "s", getName())+String.format("%-" + 40 + "s", getAvailableproduct())+getTotalprofit() +"\n");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Chow Sing Hong
 */
public class DonationItem implements Comparable<DonationItem>{
    private String item;
    private int quantity;

    public DonationItem(){
        
    }
    
    public DonationItem(String item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int compareTo(DonationItem donationItem) {
        return item.compareTo(donationItem.item);
    }

    @Override
    public String toString() {
        return "Item\t\t: " + item + "\nQuantity\t\t: " + quantity;
    }
}

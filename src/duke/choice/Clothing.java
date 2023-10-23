/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duke.choice;

/**
 *
 * @author endie
 */
public class Clothing implements Comparable<Clothing>{
    private String description ;
    private double price;
    private String size = "M" ;
    public static final double MINIMUM_PRICE = 10 ;
    public static final double TAX = 0.2 ;
    
    public Clothing(String description, double price) {
        this.description = description;
        this.price = price;
    }
    
    public Clothing(String description, double price, String size) {
        this.description = description;
        this.price = price;
        this.size = size ;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return ( price * ( 1 + Clothing.TAX));
    }

    public void setPrice(double price) {
        if (price > Clothing.MINIMUM_PRICE){
        this.price = price;
        }
        else{
            this.price = Clothing.MINIMUM_PRICE ;
        }
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    
    @Override
    public String toString() {
        return "Clothing item being reference [description=" + this.getDescription() + ", the price is =" + this.getPrice()
          + ", the size is =" + this.getSize() + "]";
    }
    
    @Override public int compareTo(Clothing a)
    {
        // if the string are not equal
//        if (this.getDescription().compareTo(a.getDescription()) != 0) {
//            return this.x.compareTo(a.x);
//        }
//        else {
//            // we compare int values
//            // if the strings are equal
//            return this.y - a.y;
//        }
        return this.getDescription().compareTo(a.getDescription()) ;
    }
    
}

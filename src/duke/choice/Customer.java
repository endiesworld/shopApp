/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package duke.choice;

/**
 *
 * @author endie
 */
public class Customer {
    private String name;
    private String size;
    private Clothing[] items ;
    private double total = 0 ;

    public Customer(String name, int measurement) {
        this.name = name;
        this.setSize(measurement);
    }
    
    
//    void setCustomerName(String name){
//    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(String size) {
        this.size = size;
    }
    
    public void setSize(int size) {
        switch(size){
            case 1,2,3:
                this.setSize("S");
                break ;
            case 4,5,6:
                this.setSize( "M");
                break ;
            case 7,8,9:
                this.setSize("L");
                break ;
            default:
                this.setSize( "X") ;
        }
    }

    public Clothing[] getItems() {
        return this.items;
    }

    public void setItems(Clothing[] items) {
        this.items = items;
    }
    
    public double getTotalClothingCost(){
        for (Clothing item: this.getItems()){
            if(item.getSize().equals(this.getSize())){
                System.out.println("The first clothing item is: " + item.getDescription() + " The price is: " + item.getPrice() +", and the size is: "+ item.getSize());
                this.total = this.total +  item.getPrice() ;
            }
            if (this.total > 15){
                break ;
            }
        }
        
        return this.total ;
    }
}

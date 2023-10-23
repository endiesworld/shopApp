/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package duke.choice;

import java.util.Arrays;

import io.helidon.webserver.Routing ;
import io.helidon.webserver.ServerConfiguration ;
import io.helidon.webserver.WebServer ;

import java.net.InetAddress;
import java.net.UnknownHostException;


/**
 *
 * @author endie
 */

public class ShopApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        double total ;
        
        Customer c1 = new  Customer("Pinky", 3) ;
        
        System.out.println("The minimum price for any clothing item is: " + Clothing.MINIMUM_PRICE);
        Clothing  item1 = new Clothing("Blue Jacket", 20.9);
        Clothing item2 = new Clothing("Orange T-shirt", 10.5, "S");
        Clothing item3 = new Clothing("Green Scarf", 5, "S");
        Clothing item4 = new Clothing("Blue T-shirt", 10.5, "S");
        Clothing[] items = {item1, item2, item3, item4} ;
        
        System.out.println("Welcome to Duke choice App");
        
        Arrays.sort(items);
        
        for( Clothing item: items){
            System.out.println("The default toString value clothing item is: " + item.toString());
        }
        
        c1.setItems(items);
        total = c1.getTotalClothingCost() ;
        
        System.out.println("The customer's name is: " + c1.getName() +" Size " + c1.getSize());
        System.out.println("The total amount for items bought is: " + total);
        
        try{
            ItemList list = new ItemList(items) ;
            Routing routing = Routing.builder().get("/items", list).build() ;
            ServerConfiguration config = ServerConfiguration.builder().bindAddress(InetAddress.getLocalHost()).port(8888).build() ;
            WebServer ws = WebServer.create( config, routing) ;
            
            ws.start() ;
        }catch(UnknownHostException ex){
            ex.printStackTrace(); 
        }
    }
    
}

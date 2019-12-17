package es.egven.tjenterprise.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * CART MODEL
 * @author dog.D
 */
public class Cart {

    // Fields
    public static ArrayList<Product> cartContent = new ArrayList<>();
    private static BigDecimal totalPrice;


    // Constructor

    public Cart() {
    }

    /**
     * ADD item to cart
     */
    public static void addItemToCart(Product product){
        cartContent.add(product);
        /*BigDecimal currentTotal = new BigDecimal(String.valueOf(totalPrice));
        BigDecimal toBeAdded = new BigDecimal(String.valueOf(b));
        totalPrice = new BigDecimal(String.valueOf(currentTotal.add(toBeAdded)));*/
    }

    /**
     * REMOVE item from cart
     */
    /*public void removeItemFromCart(String s, BigDecimal b){
        cartContent.remove(s, b);
        BigDecimal currentTotal = new BigDecimal(String.valueOf(totalPrice));
        BigDecimal toBeSubtracted = new BigDecimal(String.valueOf(b));
        totalPrice = new BigDecimal(String.valueOf(currentTotal.subtract(toBeSubtracted)));
    }*/

    /**
     * CLEAR all items from cart
     */
    public void clearCart(){
        cartContent.clear();
        totalPrice = new BigDecimal(0);
    }

    // TODO : optional - make methods to write/load cartContent to local file (in absence of user DB)
    //  and find price for each product again to add to totalPrice. ^^

    // Getters
    public ArrayList<Product> getCartContent() {
        return cartContent;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }


    /**
     * ToString Method to make Order
     * @return Order/cartContent in string
     */
    @Override
    public String toString() {
        return "Cart{" +
                "cartContent=" + cartContent +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

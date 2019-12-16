package es.egven.tjenterprise.model;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * CART MODEL
 * @author dog.D
 */
public class Cart {

    // Fields
    private HashMap<String, BigDecimal> cartContent;
    private BigDecimal totalPrice;

    // Constructor
    public Cart(HashMap<String, BigDecimal> cartContent, BigDecimal totalPrice) {
        this.cartContent = new HashMap<>();
        this.totalPrice = totalPrice;
    }

    /**
     * ADD item to cart
     */
    public void addItemToCart(String s, BigDecimal b){
        cartContent.put(s, b);
        BigDecimal currentTotal = new BigDecimal(String.valueOf(totalPrice));
        BigDecimal toBeAdded = new BigDecimal(String.valueOf(b));
        totalPrice = new BigDecimal(String.valueOf(currentTotal.add(toBeAdded)));
    }

    /**
     * REMOVE item from cart
     */
    public void removeItemFromCart(String s, BigDecimal b){
        cartContent.remove(s, b);
        BigDecimal currentTotal = new BigDecimal(String.valueOf(totalPrice));
        BigDecimal toBeSubtracted = new BigDecimal(String.valueOf(b));
        totalPrice = new BigDecimal(String.valueOf(currentTotal.subtract(toBeSubtracted)));
    }

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
    public HashMap<String, BigDecimal> getCartContent() {
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

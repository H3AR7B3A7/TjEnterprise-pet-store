package es.egven.tjenterprise.model;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class CartTest {
    @Test
    public void testAddItemToCart() {
        // TODO: This test is incomplete.

        Product product = new Product();
        product.setNaam("Naam");
        product.setPrijs(BigDecimal.valueOf(42L));
        product.setId(1);
        product.setBeschrijving("Beschrijving");
        product.setProductImagePath("Product Image Path");
        product.setProductCategorie("Product Categorie");
        Cart.addItemToCart(product);
    }
}


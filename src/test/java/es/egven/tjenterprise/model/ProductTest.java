package es.egven.tjenterprise.model;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    @Test
    public void testSetId() {
        Product product = new Product();
        product.setId(1);
        assertEquals(1, product.getId());
    }

    @Test
    public void testSetNaam() {
        Product product = new Product();
        product.setNaam("Naam");
        assertEquals("Naam", product.getNaam());
    }

    @Test
    public void testSetBeschrijving() {
        Product product = new Product();
        product.setBeschrijving("Beschrijving");
        assertEquals("Beschrijving", product.getBeschrijving());
    }

    @Test
    public void testSetPrijs() {
        BigDecimal valueOfResult = BigDecimal.valueOf(42L);
        Product product = new Product();
        product.setPrijs(valueOfResult);
        assertSame(valueOfResult, product.getPrijs());
    }

    @Test
    public void testSetProductCategorie() {
        Product product = new Product();
        product.setProductCategorie("Product Categorie");
        assertEquals("Product Categorie", product.getProductCategorie());
    }

    @Test
    public void testSetProductImagePath() {
        Product product = new Product();
        product.setProductImagePath("Product Image Path");
        assertEquals("Product Image Path", product.getProductImagePath());
    }

    @Test
    public void testEquals() {
        assertFalse((new Product()).equals("o"));
        assertNotEquals((new Product()), null);
    }

    @Test
    public void testHashCode() {
        assertEquals(31, (new Product()).hashCode());
    }
}


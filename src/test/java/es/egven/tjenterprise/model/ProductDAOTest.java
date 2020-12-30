package es.egven.tjenterprise.model;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {ProductDAO.class})
@EnableAutoConfiguration
@DataJpaTest
public class ProductDAOTest {
    @Autowired
    private ProductDAO productDAO;

    @Test
    public void testFindByCategorie() {
        // TODO: This test is incomplete.

        Product product = new Product();
        product.setNaam("Naam");
        product.setPrijs(BigDecimal.valueOf(42L));
        product.setId(1);
        product.setBeschrijving("Beschrijving");
        product.setProductImagePath("Product Image Path");
        product.setProductCategorie("Product Categorie");
        this.productDAO.<Product>save(product);
        Product product1 = new Product();
        product1.setNaam("Naam");
        product1.setPrijs(BigDecimal.valueOf(42L));
        product1.setId(1);
        product1.setBeschrijving("Beschrijving");
        product1.setProductImagePath("Product Image Path");
        product1.setProductCategorie("Product Categorie");
        this.productDAO.<Product>save(product1);
        this.productDAO.findByCategorie("foo");
    }
}


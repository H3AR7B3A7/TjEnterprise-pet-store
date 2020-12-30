package es.egven.tjenterprise.controllers;

import static org.mockito.AdditionalMatchers.or;
import static org.mockito.Mockito.isA;
import static org.mockito.Mockito.isNull;
import static org.mockito.Mockito.when;

import es.egven.tjenterprise.model.Product;
import es.egven.tjenterprise.model.ProductDAO;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {CartController.class})
@ExtendWith(SpringExtension.class)
public class CartControllerTest {
    @Autowired
    private CartController cartController;

    @MockBean
    private ProductDAO productDAO;

    @Test
    public void testAddProductToCart() throws Exception {
        Product product = new Product();
        product.setNaam("Naam");
        product.setPrijs(BigDecimal.valueOf(42L));
        product.setId(1);
        product.setBeschrijving("Beschrijving");
        product.setProductImagePath("Product Image Path");
        product.setProductCategorie("Product Categorie");
        when(this.productDAO.findById(or(isA(Integer.class), isNull()))).thenReturn(Optional.<Product>of(product));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/{id}", 123456789);
        MockMvcBuilders.standaloneSetup(this.cartController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("nProduct"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/index#mainTitle"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/index#mainTitle"));
    }

    @Test
    public void testProductToAdd() {
        // TODO: This test is incomplete.

        this.cartController.productToAdd();
    }

    @Test
    public void testClearCart() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cart/del");
        MockMvcBuilders.standaloneSetup(this.cartController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("nProduct"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/cart"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/cart"));
    }

    @Test
    public void testClearCart2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/cart/del");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(this.cartController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("nProduct"))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/cart"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/cart"));
    }
}


package es.egven.tjenterprise.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * PRODUCT MODEL
 * @author Egven
 */
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Dit veld mag niet leeg zijn!")
    private String naam;
    @NotBlank(message = "Dit veld mag niet leeg zijn!")
    private String beschrijving;
    @NotBlank()
    @DecimalMin("1.00")
    private BigDecimal prijs;
    @NotBlank()
    private String productCategorie;
    @NotBlank()
    private String productImagePath;

    // Constructor
    public Product() {
        // Not empty
    }

    // Getters & Setters
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNaam() { return naam; }

    public void setNaam(String naam) { this.naam = naam; }

    public String getBeschrijving() { return beschrijving; }

    public void setBeschrijving(String beschrijving) { this.beschrijving = beschrijving; }

    public BigDecimal getPrijs() { return prijs; }

    public void setPrijs(BigDecimal prijs) { this.prijs = prijs; }

    public String getProductCategorie() { return productCategorie; }

    public void setProductCategorie(String productCategorie) { this.productCategorie = productCategorie; }

    public String getProductImagePath() { return productImagePath; }

    public void setProductImagePath(String productImagePath) { this.productImagePath = productImagePath; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

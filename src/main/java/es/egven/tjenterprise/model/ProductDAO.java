package es.egven.tjenterprise.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * PRODUCT REPOSITORY
 * @author Egven
 */
public interface ProductDAO extends CrudRepository<Product, Integer> {

    @Query(value = "select p from Product p where p.productCategorie = :productCategorie")
    Iterable<Product> findByCategorie(String productCategorie);
}

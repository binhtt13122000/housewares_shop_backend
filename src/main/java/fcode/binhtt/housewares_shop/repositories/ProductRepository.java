package fcode.binhtt.housewares_shop.repositories;

import fcode.binhtt.housewares_shop.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByProductNameContaining(String name);
    @Query("select p from Product p where p.category.categoryId = ?1")
    List<Product> findAllByCategory(Integer categoryId);
    @Query("select p from Product p where p.brand.brandId = ?1")
    List<Product> findAllByBrand(Integer brandId);
    List<Product> findAllByPromotionGreaterThanEqual(Integer promotion);
    @Query("select p from Product p where p.price * (1 - p.promotion) > ?1")
    List<Product> findAllProductByTotalGreaterThan(Integer total);
}

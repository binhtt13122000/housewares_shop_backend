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
    Page<Product> findAllByCategory(Integer categoryId, Pageable pageable);
    @Query("select p from Product p where p.brand.brandId = ?1")
    Page<Product> findAllByBrand(Integer brandId, Pageable pageable);
    List<Product> findAllByPromotionGreaterThanEqual(Integer promotion);
}

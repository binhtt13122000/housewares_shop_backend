package fcode.binhtt.housewares_shop.service.product;

import fcode.binhtt.housewares_shop.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Page<Product> findAllProducts(Pageable pageable);

    List<Product> findAllProductByName(String name);

    Optional<Product> findProductById(Integer productId);

    void save(Product product);

    void remove(Product product);

    Page<Product> finđAllByBrand(Integer brandId, Pageable pageable);

    Page<Product> findAllByCategory(Integer categoryId, Pageable pageable);

    List<Product> findAllByPromotion(Integer promotion);
}

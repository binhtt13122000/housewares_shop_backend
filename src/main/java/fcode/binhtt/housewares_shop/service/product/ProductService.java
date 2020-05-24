package fcode.binhtt.housewares_shop.service.product;

import fcode.binhtt.housewares_shop.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Page<Product> findAllProducts(Pageable pageable);

    List<Product> findAllProducts();

    List<Product> findAllProductByName(String name);

    Optional<Product> findProductById(Integer productId);

    void save(Product product);

    void remove(Product product);

    List<Product> findAllByBrand(Integer brandId);

    List<Product> findAllByCategory(Integer categoryId);

    List<Product> findAllProductByTotal(Integer total);

    List<Product> findAllByPromotion(Integer promotion);
}

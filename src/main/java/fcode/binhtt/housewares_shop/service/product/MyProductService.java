package fcode.binhtt.housewares_shop.service.product;

import fcode.binhtt.housewares_shop.entities.Product;
import fcode.binhtt.housewares_shop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class MyProductService implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Page<Product> findAllProducts(Pageable pageable) {
        return  productRepository.findAll(pageable);
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findAllProductByName(String name) {
        return productRepository.findAllByProductNameContaining(name);
    }

    @Override
    public Optional<Product> findProductById(Integer productId) {
        return productRepository.findById(productId);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void remove(Product product) {
        productRepository.delete(product);
    }

    @Override
    public List<Product> findAllByBrand(Integer brandId) {
        return productRepository.findAllByBrand(brandId);
    }

    @Override
    public List<Product> findAllByCategory(Integer categoryId) {
        return productRepository.findAllByCategory(categoryId);
    }

    @Override
    public List<Product> findAllByPromotion(Integer promotion) {
        return productRepository.findAllByPromotionGreaterThanEqual(promotion);
    }

    @Override
    public List<Product> findAllProductByTotal(Integer total) {
        return productRepository.findAllProductByTotalGreaterThan(total);
    }
}

package fcode.binhtt.housewares_shop.controllers;

import fcode.binhtt.housewares_shop.entities.Product;
import fcode.binhtt.housewares_shop.service.product.MyProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    @Autowired
    private MyProductService productService;

    @GetMapping("/products")
    public ResponseEntity findAllProductByName(@RequestParam Optional<String> q){
        List<Product> products;
        if(q.isPresent()){
            products = productService.findAllProductByName(q.get());
        } else {
            products = productService.findAllProducts();
        }
        if(products.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(products, HttpStatus.OK);
        }
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity findProductById(@PathVariable("productId") Integer productId){
        Optional<Product> currentProduct = productService.findProductById(productId);
        if(currentProduct.isPresent()){
            return new ResponseEntity(currentProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/brand/{brandId}/products")
    public ResponseEntity findProductsByBrand(@PathVariable("brandId") Integer brandId){
        List<Product> products = productService.findAllByBrand(brandId);
        if(products.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(products, HttpStatus.OK);
        }
    }

    @GetMapping("/category/{categoryId}/products")
    public ResponseEntity findProductsByCategory(@PathVariable("categoryId") Integer categoryId){
        List<Product> products = productService.findAllByCategory(categoryId);
        if(products.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(products, HttpStatus.OK);
        }
    }

    @GetMapping("/promotion/products")
    public ResponseEntity findAllByPromotion(@RequestParam Optional<Integer> rate){
        if(rate.isPresent()){
            if(rate.get() <= 0 || rate.get() >= 100){
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            } else {
                List<Product> products = productService.findAllByPromotion(rate.get());
                if(products.isEmpty()){
                    return new ResponseEntity(HttpStatus.NO_CONTENT);
                } else {
                    return new ResponseEntity(products, HttpStatus.OK);
                }
            }
        } else {
            return new ResponseEntity(productService.findAllByPromotion(0), HttpStatus.OK);
        }
    }

    @GetMapping("/total/products")
    public ResponseEntity findAllByTotal(@RequestParam Optional<Integer> total){
        if(total.isPresent()){
            List<Product> products = productService.findAllProductByTotal(total.get());
            if(products.isEmpty()){
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity(products, HttpStatus.OK);
            }
        } else {
            return new ResponseEntity(productService.findAllProductByTotal(0), HttpStatus.OK);
        }
    }

    @PostMapping("/product")
    public ResponseEntity createProduct(@RequestBody Product product){
        productService.save(product);
        return new ResponseEntity(product, HttpStatus.CREATED);
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity deleteProduct(@PathVariable("productId") Integer productId){
        Optional<Product> currentProduct = productService.findProductById(productId);
        if(currentProduct.isPresent()){
            productService.remove(currentProduct.get());
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/products/{productId}")
    public ResponseEntity updateProduct(@PathVariable("productId") Integer productId, @RequestBody Product product){
        Optional<Product> currentProduct = productService.findProductById(productId);
        if(currentProduct.isPresent()){
            productService.save(currentProduct.get());
            return new ResponseEntity(currentProduct,HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}

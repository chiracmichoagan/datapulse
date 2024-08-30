package bj.higfiveuniversity.datapulse.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import bj.higfiveuniversity.datapulse.model.Product;
import bj.higfiveuniversity.datapulse.repository.ProductRepository;
import bj.higfiveuniversity.datapulse.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




    @RestController
    @RequestMapping("/api/products")
    public class ProductController {
    @Autowired
    private ProductRepository productRepository; 

    @Autowired
    private ProductService productService;
   
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product  updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        Product  productUpdate = productService.updateProduct(id,productDetails);
        return   productRepository.save(productUpdate);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {

       productService.deleteProduct(id);

       return ResponseEntity.noContent().build();

    }

}

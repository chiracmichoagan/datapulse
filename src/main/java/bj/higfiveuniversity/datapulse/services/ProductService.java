package bj.higfiveuniversity.datapulse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import bj.higfiveuniversity.datapulse.model.Product;
import bj.higfiveuniversity.datapulse.repository.ProductRepository;

@Service
public class ProductService {
     @Autowired
    private ProductRepository productRepository; 

     public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

     public Product createProduct(Product product) {
        return productRepository.save(product);
    }

     public Product  updateProduct(Long id,Product productDetails) {
        Product  productUpdate = productRepository.findById(id).orElseThrow();
        productUpdate.setName(productDetails.getName());
        productUpdate.setDescription(productDetails.getDescription());
        productUpdate.setCategories(productDetails.getCategories());
        return productRepository.save(productUpdate);
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow();
        productRepository.delete(product);
    }


    
}

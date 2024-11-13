package com.caiquekola.CRUDapi.services;

import com.caiquekola.CRUDapi.models.Product;
import com.caiquekola.CRUDapi.repositories.ProductRepository;
import com.caiquekola.CRUDapi.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElseThrow(() -> new ObjectNotFoundException("Product not found"));
    }

    @Transactional
    public Product createProduct (Product product) {
        product.setId(null);
        productRepository.save(product);
        return product;
    }

    @Transactional
    public Product updateProduct (Product product) {
        Product newProduct = this.getProductById(product.getId());
        newProduct.setName(product.getName());
        newProduct.setPrice(product.getPrice());
        newProduct.setDescription(product.getDescription());
        return this.productRepository.save(newProduct);
    }

    public void deleteProduct (Long id) {
        Product product = this.getProductById(id);
        try{
            productRepository.delete(product);

        }catch (Exception e){
            throw new DataIntegrityViolationException(e.getMessage() +"Error in deleting product");
        }
    }

}

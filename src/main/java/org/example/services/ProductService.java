package org.example.services;

import org.example.entities.Product;
import org.example.utils.ConnectionFactory;
import org.example.repositories.ProductRepository;

public class ProductService {

    private final ProductRepository productRepository = new ProductRepository(new ConnectionFactory());
    public Product getProductById(Long id) {
        return productRepository.get(id);
    }

    public boolean saveProduct(Product product) {
        return productRepository.save(product);
    }

    public boolean extractProductById(Long id) {
        return productRepository.extract(id);
    }
}

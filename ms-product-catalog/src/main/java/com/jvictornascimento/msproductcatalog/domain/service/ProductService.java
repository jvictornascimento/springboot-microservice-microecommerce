package com.jvictornascimento.msproductcatalog.domain.service;

import com.jvictornascimento.msproductcatalog.domain.models.Product;
import com.jvictornascimento.msproductcatalog.domain.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        List<Product> list = new ArrayList<>();
                productRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).get();
    }
    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
    @Override
    public Product updateProduct(Long id, Product product) {
        var data = getById(id);
        data.setName(product.getName() != null ? product.getName() : data.getName());
        data.setAmount(product.getAmount() != null ? product.getAmount() : data.getAmount());
        return productRepository.save(data);
    }
    @Override
    public void deleteProduct(Long id) {
        var product = productRepository.findById(id).get();
        productRepository.delete(product);
    }
}

package com.jvictornascimento.msproductcatalog.domain.service;

import com.jvictornascimento.msproductcatalog.domain.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    Product getById(Long id);
    Product saveProduct(Product product);
    Product updateProduct(Long id , Product product);
    void deleteProduct(Long id);

}

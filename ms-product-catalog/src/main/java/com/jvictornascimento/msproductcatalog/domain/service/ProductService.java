package com.jvictornascimento.msproductcatalog.domain.service;

import com.jvictornascimento.msproductcatalog.api.controllers.request.ProductRequest;
import com.jvictornascimento.msproductcatalog.api.controllers.request.ProductUpdateRequest;
import com.jvictornascimento.msproductcatalog.api.controllers.response.ProductResponse;
import com.jvictornascimento.msproductcatalog.api.mapper.IProductMapper;
import com.jvictornascimento.msproductcatalog.domain.models.Product;
import com.jvictornascimento.msproductcatalog.domain.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {
    private final ProductRepository productRepository;
    private final IProductMapper productMapper;

    public ProductService(ProductRepository productRepository, IProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductResponse> getAll() {
        List<Product> list = new ArrayList<>();
        productRepository.findAll().forEach(list::add);
        return list.stream().map(productMapper::toOut).collect(Collectors.toList());
    }

    @Override
    public ProductResponse getById(Long id) {
        return productMapper.toOut(productRepository.findById(id).get());
    }
    @Override
    public ProductResponse saveProduct(ProductRequest product) {
        return productMapper.toOut(productRepository.save(productMapper.toEntity(product)));
    }
    @Override
    public ProductResponse updateProduct(Long id, ProductUpdateRequest product) {
        var data = productRepository.findById(id).get();
        data.setName(product.name() != null ? product.name() : data.getName());
        data.setAmount(product.amount() != null ? product.amount() : data.getAmount());
        return productMapper.toOut(productRepository.save(data));
    }
    @Override
    public void deleteProduct(Long id) {
        var product = productRepository.findById(id).get();
        productRepository.delete(product);
    }
}

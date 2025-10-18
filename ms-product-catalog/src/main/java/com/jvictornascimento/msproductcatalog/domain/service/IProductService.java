package com.jvictornascimento.msproductcatalog.domain.service;

import com.jvictornascimento.msproductcatalog.api.controllers.request.ProductRequest;
import com.jvictornascimento.msproductcatalog.api.controllers.request.ProductUpdateRequest;
import com.jvictornascimento.msproductcatalog.api.controllers.response.ProductResponse;

import java.util.List;

public interface IProductService {
    List<ProductResponse> getAll();
    ProductResponse getById(Long id);
    ProductResponse saveProduct(ProductRequest request);
    ProductResponse updateProduct(Long id , ProductUpdateRequest request);
    void deleteProduct(Long id);

}

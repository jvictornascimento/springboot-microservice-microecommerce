package com.jvictornascimento.msproductcatalog.api.mapper;

import com.jvictornascimento.msproductcatalog.api.controllers.request.ProductRequest;
import com.jvictornascimento.msproductcatalog.api.controllers.response.ProductResponse;
import com.jvictornascimento.msproductcatalog.domain.models.Product;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface IProductMapper {

    Product toEntity(ProductRequest request);
    ProductResponse toOut(Product product);

}

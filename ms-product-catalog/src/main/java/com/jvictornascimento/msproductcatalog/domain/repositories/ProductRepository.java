package com.jvictornascimento.msproductcatalog.domain.repositories;

import com.jvictornascimento.msproductcatalog.domain.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}

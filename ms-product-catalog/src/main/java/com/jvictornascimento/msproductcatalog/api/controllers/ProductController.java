package com.jvictornascimento.msproductcatalog.api.controllers;

import com.jvictornascimento.msproductcatalog.api.controllers.request.ProductRequest;
import com.jvictornascimento.msproductcatalog.api.controllers.request.ProductUpdateRequest;
import com.jvictornascimento.msproductcatalog.api.controllers.response.ProductResponse;
import com.jvictornascimento.msproductcatalog.domain.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return ResponseEntity.ok(productService.getAll());
    } @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProdcutbyId(@PathVariable(name= "id") Long id) {
        return ResponseEntity.ok(productService.getById(id));
    }
    @PostMapping()
    public ResponseEntity<ProductResponse> saveProduct(@RequestBody ProductRequest product) {
        var newData = productService.saveProduct(product);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newData.id()).toUri();
        return ResponseEntity.created(uri).body(newData);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> deleteProductById(@PathVariable(name= "id") Long id, @RequestBody ProductUpdateRequest product) {
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }  @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable(name= "id") Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}

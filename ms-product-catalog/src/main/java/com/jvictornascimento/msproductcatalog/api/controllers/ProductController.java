package com.jvictornascimento.msproductcatalog.api.controllers;

import com.jvictornascimento.msproductcatalog.domain.models.Product;
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
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAll());
    } @GetMapping("/{id}")
    public ResponseEntity<Product> getProdcutbyId(@PathVariable(name= "id") Long id) {
        return ResponseEntity.ok(productService.getById(id));
    }
    @PostMapping()
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        var newData = productService.saveProduct(product);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newData.getId()).toUri();
        return ResponseEntity.created(uri).body(newData);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> deleteProductById(@PathVariable(name= "id") Long id, @RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }  @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable(name= "id") Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}

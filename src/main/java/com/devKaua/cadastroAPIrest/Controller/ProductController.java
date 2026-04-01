package com.devKaua.cadastroAPIrest.Controller;

import com.devKaua.cadastroAPIrest.Model.ProductModel;
import com.devKaua.cadastroAPIrest.Repository.ProductRepository;
import com.devKaua.cadastroAPIrest.dtos.ProductRecordDto;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/products")                      //             AQUI ELE FAZ AS VALIDACOES ESCRITOS NO Dto
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto) {
        ProductModel productModel = new ProductModel();
                              // Ele recebe Dto.   Converte para productModel.
        BeanUtils.copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getProductsById(@PathVariable(value = "id") UUID id) {
        Optional<ProductModel> productId = productRepository.findById(id);
        if (productId.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(productId.get());
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value = "id") UUID id, @RequestBody @Valid ProductRecordDto productRecordDto) {
        Optional<ProductModel> productId = productRepository.findById(id);
        if (productId.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        ProductModel productModel = productId.get();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProductById(@PathVariable(value = "id") UUID id, @RequestBody @Valid ProductRecordDto recordDto) {
        Optional<ProductModel> productId = productRepository.findById(id);
        if (productId.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        productRepository.delete(productId.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully");
    }
}

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

@RestController
@RequestMapping
public class ProductController {
    @Autowired
    ProductController productController;
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/products")
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto) {
        var productModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDto, productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }
    // Primeira rota, Get pega o metodo e trasnforma numa rota
    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Primeira rota";
    }
}

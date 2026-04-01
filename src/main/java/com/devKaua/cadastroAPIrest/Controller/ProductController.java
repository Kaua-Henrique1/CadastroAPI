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
    // Primeira rota, Get pega o metodo e trasnforma numa rota
    @GetMapping("/boasvindas")
    public String boasVindas() {
        return "Primeira rota";
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
    }
}

package org.example.userProducts.api.ProductController;

import lombok.RequiredArgsConstructor;
import org.example.userProducts.api.ProductApi.ProductApi;
import org.example.userProducts.dto.ProductDto;
import org.example.userProducts.service.ProductService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController implements ProductApi {

    private final ProductService productService;

    public ProductDto findById(@RequestParam UUID id) {
        return productService.findById(id);
    }

    public List<ProductDto> findAllByUserId(UUID id) {
        return productService.findAllByUserId(id);
    }
}

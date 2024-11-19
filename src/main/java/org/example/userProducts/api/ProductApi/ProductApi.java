package org.example.userProducts.api.ProductApi;

import org.example.userProducts.dto.ProductDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/products")
public interface ProductApi {

    @GetMapping("/")
    ProductDto findById(@RequestParam UUID id);

    @GetMapping("/")
    List<ProductDto> findAllByUserId(@RequestParam UUID id);
}

package org.example.userProducts.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.userProducts.dto.ProductDto;
import org.example.userProducts.exception.NotFoundException;
import org.example.userProducts.persistence.repository.ProductRepository;
import org.example.userProducts.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductDto findById(UUID id) {
        return productRepository.findById(id).map(ProductDto::toProductDto)
                .orElseThrow(() -> new NotFoundException(String.format("Not found product by id = %s", id)));
    }

    @Override
    public List<ProductDto> findAllByUserId(UUID userId) {
        return productRepository.findAllByUserId(userId).stream()
                .map(ProductDto::toProductDto)
                .toList();
    }
}



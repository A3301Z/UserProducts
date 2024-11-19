package org.example.userProducts.persistence.entity;

import lombok.Builder;
import lombok.Data;
import org.example.userProducts.dto.ProductDto;
import org.example.userProducts.enumerations.ProductType;

import java.util.UUID;

@Data
@Builder
public class Product {

    private UUID id;

    private String accountNumber;

    private long balance;

    private ProductType productType;

    public Product toProduct(ProductDto productDto) {
        return Product.builder()
                .id(productDto.id)
                .accountNumber(productDto.accountNumber)
                .balance(productDto.balance)
                .productType(productDto.productType)
                .build();
    }
}

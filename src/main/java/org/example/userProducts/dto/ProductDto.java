package org.example.userProducts.dto;

import lombok.Builder;
import org.example.userProducts.persistence.entity.Product;
import org.example.userProducts.enumerations.ProductType;

import java.util.UUID;

@Builder
public class ProductDto {

    public UUID id;

    public String accountNumber;

    public long balance;

    public ProductType productType;

    public static ProductDto toProductDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .accountNumber(product.getAccountNumber())
                .balance(product.getBalance())
                .productType(product.getProductType())
                .build();
    }
}

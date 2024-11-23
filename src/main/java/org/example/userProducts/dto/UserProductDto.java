package org.example.userProducts.dto;

import lombok.Builder;
import org.example.userProducts.entity.UserProduct;
import org.example.userProducts.enumerations.UserProductType;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public class UserProductDto {

    public UUID id;

    public BigDecimal userId;

    public String accountNumber;

    public long balance;

    public UserProductType productType;

    public static UserProductDto toProductDto(UserProduct product) {
        return UserProductDto.builder()
                .id(product.getId())
                .userId(product.getUserId())
                .accountNumber(product.getAccountNumber())
                .balance(product.getBalance())
                .productType(product.getProductType())
                .build();
    }
}

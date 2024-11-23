package org.example.userProducts.entity;

import lombok.Builder;
import lombok.Data;
import org.example.userProducts.dto.UserProductDto;
import org.example.userProducts.enumerations.UserProductType;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class UserProduct {

    private UUID id;

    private BigDecimal userId;

    private String accountNumber;

    private long balance;

    private UserProductType productType;

    public UserProduct toProduct(UserProductDto productDto) {
        return UserProduct.builder()
                .id(productDto.id)
                .userId(productDto.userId)
                .accountNumber(productDto.accountNumber)
                .balance(productDto.balance)
                .productType(productDto.productType)
                .build();
    }
}

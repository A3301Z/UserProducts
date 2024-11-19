package org.example.userProducts.service;

import org.example.userProducts.dto.ProductDto;

import java.util.List;
import java.util.UUID;

/**
 * Сервис для работы с {@link ProductDto}
 */
public interface ProductService {

    /**
     * Найти продукт по id
     * @param id - уникальный идентификатор продукта пользователя
     */
    ProductDto findById(UUID id);

    /**
     * Найти все продукты пользователя по userId
     * @param userId - уникальный идентификатор пользователя
     */
    List<ProductDto> findAllByUserId(UUID userId);
}

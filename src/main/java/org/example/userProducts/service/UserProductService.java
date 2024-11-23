package org.example.userProducts.service;

import org.example.userProducts.dto.UserProductDto;

import java.util.List;
import java.util.UUID;

/**
 * Сервис для работы с {@link UserProductDto}
 */
public interface UserProductService {

    /**
     * Найти продукт по id
     * @param id - уникальный идентификатор продукта пользователя
     */
    UserProductDto findById(UUID id);

    /**
     * Найти все продукты пользователя по userId
     * @param userId - уникальный идентификатор пользователя
     */
    List<UserProductDto> findAllByUserId(long userId);
}

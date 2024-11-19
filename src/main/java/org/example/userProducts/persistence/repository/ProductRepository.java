package org.example.userProducts.persistence.repository;

import org.example.userProducts.persistence.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Репозиторий для работы с {@link Product}
 */
@Repository
public interface ProductRepository {
    Optional<Product> findById(UUID id);

    List<Product> findAllByUserId(UUID userId);
}

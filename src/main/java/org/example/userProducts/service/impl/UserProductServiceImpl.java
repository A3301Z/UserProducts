package org.example.userProducts.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.userProducts.dao.UserProductDao;
import org.example.userProducts.dto.UserProductDto;
import org.example.userProducts.exception.NotFoundException;
import org.example.userProducts.service.UserProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserProductServiceImpl implements UserProductService {

    private final UserProductDao productDao;

    @Override
    public UserProductDto findById(UUID id) {
        return productDao.findById(id).map(UserProductDto::toProductDto)
                .orElseThrow(() -> new NotFoundException(String.format("Not found product by id = %s", id)));
    }

    @Override
    public List<UserProductDto> findAllByUserId(long userId) {
        return Optional.ofNullable(productDao.findAllByUserId(userId))
                .filter(products -> !products.isEmpty())
                .orElseThrow(() -> new NotFoundException(String.format("Not found user by id = %s", userId)))
                .stream()
                .map(UserProductDto::toProductDto)
                .toList();
    }
}



package org.example.userProducts.api.ProductController;

import lombok.RequiredArgsConstructor;
import org.example.userProducts.api.ProductApi.UserProductApi;
import org.example.userProducts.dto.UserProductDto;
import org.example.userProducts.service.UserProductService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserProductController implements UserProductApi {

    private final UserProductService productService;

    public UserProductDto findById(UUID id) {
        return productService.findById(id);
    }

    public List<UserProductDto> findAllByUserId(long id) {
        return productService.findAllByUserId(id);
    }
}

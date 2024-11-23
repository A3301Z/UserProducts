package org.example.userProducts.api.ProductApi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.userProducts.dto.UserProductDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Tag(name = "API продуктов клиента")
@RequestMapping("/api/v1/products")
public interface UserProductApi {

    @Operation(summary = "Получить продукт по id")
    @GetMapping("/findById")
    UserProductDto findById(@RequestParam UUID id);

    @Operation(summary = "Получить список продуктов пользователя по userId")
    @GetMapping("/findAllByUserId")
    List<UserProductDto> findAllByUserId(@RequestParam long id);
}

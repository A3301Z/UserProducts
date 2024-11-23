package org.example.userProducts.dao;

import lombok.RequiredArgsConstructor;
import org.example.userProducts.entity.UserProduct;
import org.example.userProducts.enumerations.UserProductType;
import org.example.userProducts.sqlQueries.UserProductQueries;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserProductDao {

    private final DataSource dataSource;

    public Optional<UserProduct> findById(UUID id) {

        try (Connection connection = connect(dataSource)) {
            PreparedStatement statement = connection.prepareStatement(UserProductQueries.FIND_BY_ID.getQuery());
            statement.setObject(1, id);
            statement.executeQuery();
            ResultSet resultSet = statement.getResultSet();

            if (resultSet.next()) {
                return Optional.of(UserProduct.builder()
                        .id(UUID.fromString(resultSet.getString("id")))
                        .userId(resultSet.getBigDecimal("user_id"))
                        .accountNumber(resultSet.getString("account_number"))
                        .balance(resultSet.getLong("balance"))
                        .productType(UserProductType.valueOf(resultSet.getString("product_type")))
                        .build());
            }

        } catch (SQLException e) {
            throw new RuntimeException("Ошибка подключения к ресурсу");
        }
        return Optional.empty();
    }

    public List<UserProduct> findAllByUserId(long userId) {

        List<UserProduct> products = new ArrayList<>();

        try (Connection connection = connect(dataSource)) {

            PreparedStatement statement = connection.prepareStatement(UserProductQueries.FIND_ALL_BY_USER_ID.getQuery());
            statement.setLong(1, userId);
            statement.executeQuery();
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                products.add(UserProduct.builder()
                        .id(UUID.fromString(resultSet.getString("id")))
                        .userId(resultSet.getBigDecimal("user_id"))
                        .balance(resultSet.getLong("balance"))
                        .productType(UserProductType.valueOf(resultSet.getString("product_type")))
                        .accountNumber(resultSet.getString("account_number"))
                        .build());
            }

        } catch (SQLException e) {
            throw new RuntimeException("Ошибка подключения к ресурсу");
        }
        return products;
    }

    private Connection connect(DataSource dataSource) {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("не удалось установить подключение к базе данных");
        }
    }
}

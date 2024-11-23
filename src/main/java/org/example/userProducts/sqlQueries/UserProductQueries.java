package org.example.userProducts.sqlQueries;

import lombok.Getter;

@Getter
public enum UserProductQueries {

    FIND_BY_ID("select * from products where id = ?"),
    FIND_ALL_BY_USER_ID("select * from products where user_id = ?");

    private final String query;

    UserProductQueries(String query) {
        this.query = query;
    }
}

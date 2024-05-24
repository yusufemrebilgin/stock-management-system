package com.example.stockmanagement.constants;

import java.util.Arrays;
import java.util.List;

public final class TableConstants {

    public static final List<String> PRODUCT_HEADERS = Arrays.asList("#", "Name", "Category", "Stock", "Price", "Added", "Modified", "");
    public static final List<String> PRODUCT_FIELDS = Arrays.asList("code", "name", "category.name", "quantityInStock", "salePrice", "createdAt", "modifiedAt");

    public static final List<String> USER_HEADERS = Arrays.asList("Username", "Name", "Email", "Role", "Created At", "");
    public static final List<String> USER_FIELDS = Arrays.asList("username", "firstName+lastName", "email", "roles.name", "createdAt");


    private TableConstants() {}

}

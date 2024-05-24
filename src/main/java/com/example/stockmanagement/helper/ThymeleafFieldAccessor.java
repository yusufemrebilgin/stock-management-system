package com.example.stockmanagement.helper;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;

@Component
public class ThymeleafFieldAccessor {

    public Object getFieldValue(Object object, String fieldName) {
        try {
            // If "fieldName" parameter contains more than one field, such as "firstName+lastName"
            if (fieldName.contains("+")) {
                String[] compositeFields = fieldName.split("\\+");
                StringBuilder compositeValue = new StringBuilder();

                for (String compositeField : compositeFields) {
                    compositeValue.append(getFieldValue(object, compositeField)).append(" ");
                }

                return compositeValue.toString().trim();
            }

            String[] fieldNames = fieldName.split("\\.");
            Object value = object;

            for (String name : fieldNames) {
                Field field = value.getClass().getDeclaredField(name);
                field.setAccessible(true);
                value = field.get(value);

                if (value == null) {
                    return null;
                }

                if (value instanceof Collection<?> collection) {
                    String subFieldName = fieldName.substring(fieldName.indexOf('.') + 1);
                    List<Object> roleList = collection.stream()
                            .map(item -> getFieldValue(item, subFieldName))
                            .toList();
                    return (roleList.contains("ROLE_ADMIN")) ? "ADMIN" : "USER";
                }

                if (value instanceof LocalDateTime) {
                    return ((LocalDateTime) value).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                }
            }
            return value;

        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Error while accessing field " + fieldName, e);
        }
    }

}

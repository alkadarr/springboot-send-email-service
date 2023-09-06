package com.radev.basecode.dto;

import lombok.Data;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Data
public class EmailModel {
    private String name;
    private String text;

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();

        Class<?> clazz = getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                String fieldName = field.getName();
                Object value = field.get(this);
                map.put(fieldName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                throw new RuntimeException(e.getMessage());
            }
        }

        return map;
    }
}

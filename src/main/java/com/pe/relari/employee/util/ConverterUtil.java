package com.pe.relari.employee.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConverterUtil {

    private static final ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
    }

    public static <T> T readDataFromFileJson(
            String fileName, Class<T> className) {
        try {
            return mapper.readValue(
                    ConverterUtil.class.getClassLoader().getResourceAsStream(fileName), className
            );
        } catch (Exception e) {
            return null;
        }
    }

    public static <T> T readData(
            String json, Class<T> className) {
        try {
            return mapper.readValue(json, className);
        } catch (Exception e) {
            return null;
        }
    }

    public static String convertJsonToString(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}

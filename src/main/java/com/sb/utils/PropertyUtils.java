package com.sb.utils;

import com.sb.constants.FrameworkConstants;
import com.sb.enums.ConfigProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public final class PropertyUtils {

    private PropertyUtils() {
    }

    private static Properties property = new Properties();
    private static final Map<String, String> CONFIGMAP = new HashMap<>();

    static {
        try {
            FileInputStream file = new FileInputStream(FrameworkConstants.getConfigFilePath());
            property.load(file);
            /*for (Object key: property.keySet()){
                CONFIGMAP.put(String.valueOf(key), String.valueOf(property.get(key)));
            }*/
            for (Map.Entry<Object, Object> entry : property.entrySet()) {
                CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
            }
            // in lambda form
            //property.forEach((key, value) -> CONFIGMAP.put(String.valueOf(key), String.valueOf(value)));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //HashMap use case: when properties need to be read multiple times
    public static String get(ConfigProperties key) throws Exception {
        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
            throw new Exception("The property :\"+key+ \"was not found.Please check the config.properties file");
        }
        return CONFIGMAP.get(key.name().toLowerCase());
    }

    // HashTable use case: if less properties to read and not re-read multiple times
    public static String getValue(String key) throws Exception {
        if (Objects.isNull(property.getProperty(key)) || Objects.isNull(key)) {
            throw new Exception("The property :" + key + "was not found.Please check the config.properties file");
        }
        return property.getProperty(key);
    }
}

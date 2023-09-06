package com.prestashop.utils;

import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Log4j
@UtilityClass
public class PropertiesReader {

    public static Properties loadProperties(String path) {
        log.info("Loading properties from: " + path);
        Properties result = new Properties();
        try (InputStream inputStream = PropertiesReader.class.getResourceAsStream(path)) {
            result.load(inputStream);
        } catch (IOException e) {
            log.error("Error during reading properties by the path: " + path);
            throw new IllegalStateException("Couldn't load properties from resource with path:" + path, e);
        }
        return result;
    }

}

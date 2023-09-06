package com.prestashop.data;

import com.prestashop.utils.PropertiesReader;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Properties;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConfigProperty {

    public static final String URL;

    static {
        Properties nxGqlProperties = PropertiesReader.loadProperties("/properties/config.properties");
        URL = nxGqlProperties.getProperty("url");
    }

}

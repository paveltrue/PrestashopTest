package com.prestashop.utils;

import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j;
import org.assertj.core.api.Assertions;

@Log4j
@UtilityClass
public class NumberUtils {


    public double convertToDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            log.error(e.getMessage());
            Assertions.fail("Cannot parse String [%s] to Double!", str);
        }
        return 0.0;
    }

    public int convertToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            log.error(e.getMessage());
            Assertions.fail("Cannot parse String [%s] to Int!", str);
        }
        return 0;
    }

}

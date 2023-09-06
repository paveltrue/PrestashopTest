package com.prestashop.model;

import lombok.Builder;
import lombok.Getter;
import net.andreinc.mockneat.MockNeat;
import org.apache.commons.lang3.RandomStringUtils;

@Getter
@Builder
public class DeliveryAddress {

    @Builder.Default
    private String address = MockNeat.threadLocal().addresses().get();
    @Builder.Default
    private String postalCode = RandomStringUtils.randomNumeric(5);
    @Builder.Default
    private String city = MockNeat.threadLocal().cities().capitals().get();
    @Builder.Default
    private String country = "France";
    @Builder.Default
    private String state = "Alabama";


}

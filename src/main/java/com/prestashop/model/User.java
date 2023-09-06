package com.prestashop.model;

import lombok.Builder;
import lombok.Getter;
import net.andreinc.mockneat.MockNeat;

@Getter
@Builder
public class User {

    @Builder.Default
    private String firstName = getMock().names().first().get();
    @Builder.Default
    private String lastName = getMock().names().last().get();
    @Builder.Default
    private String email = getMock().emails().get();
    @Builder.Default
    private String address = getMock().addresses().get();

    public static User generateRandomUser() {
        return User.builder().build();
    }

    @Override
    public String toString() {
        return String.format("First name: [%s], email: [%s]", firstName, email);
    }

    private static MockNeat getMock() {
        return MockNeat.threadLocal();
    }

}

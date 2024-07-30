package Utils;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class generateTestData {
    static Faker faker = new Faker();

    public static String firstName = faker.name().firstName();
    public static String lastname = faker.name().lastName();
    public static String zipcode = faker.address().zipCode();

}
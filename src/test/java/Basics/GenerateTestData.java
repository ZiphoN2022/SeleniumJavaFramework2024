package Basics;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class GenerateTestData {

    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String surname = faker.name().lastName();
    String zipcode=faker.address().zipCode();
    String animalNames=faker.animal().name();

    @Test
    public void tests(){
       System.out.println(firstName);
       System.out.println(surname);
       System.out.println(zipcode);
       System.out.println(animalNames);
    }
}

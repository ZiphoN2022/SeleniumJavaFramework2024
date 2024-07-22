import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class GenerateTestData {

    Faker faker = new Faker();

    String firstName= faker.name().firstName();
    String surname =faker.name().lastName();
@Test new public void(){
        system.out.println(firstName);   }}








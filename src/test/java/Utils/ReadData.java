package Utils;

import org.testng.annotations.Test;

public class ReadData {

    String testDataDir = System.getProperty("user.dir") + "/src/test/java/TestData/TestData.xlsx";

    @Test
    public void test() {
        System.out.println(testDataDir);
    }

}

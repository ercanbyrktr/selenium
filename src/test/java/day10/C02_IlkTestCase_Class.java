package day10;

import org.junit.Test;
import day12.utilities.TestBaseBeforeClassAfterClass;

public class C02_IlkTestCase_Class extends TestBaseBeforeClassAfterClass {

    @Test
    public void test1(){
        driver.get("https://amazon.com");
    }
}

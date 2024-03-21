package testRunners;

import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

public class TestNGRunner
{
    public static void main(String[] args)
    {
        TestNG obj =new TestNG();

        List<String> suites =new ArrayList<>();

        suites.add("C:\\Users\\avanti_pampana\\eclipse-workspace\\MyCalculatorProject\\testng.xml");

        obj.setTestSuites(suites);
        obj.run();


    }
}

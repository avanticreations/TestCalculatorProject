package testPackage;


import calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;
//import com.epam.tat.module4.Calculator;

public class CalculatorTest
{
    long result=0;
    public Calculator cal;
    @BeforeTest(alwaysRun=true)
    public void instantiateCalculator()
    {
       cal = new Calculator();
    }

    @DataProvider(name="test-data")
    public Object[][] getTestData()
    {
        return new Object[][]{{45,55},
                            {-18,-50},
                            {Integer.MAX_VALUE,Integer.MAX_VALUE},
                            {Long.MAX_VALUE,Long.MAX_VALUE}};
    }

    @Test(dataProvider = "test-data")
    public void AddTwoNumbersWithDataProvider(long a,long b)
    {
        result= cal.sum(a,b);
        System.out.println(result);
    }
    @Test(groups= {"positive"})
    public void AddTwoNumbers()
    {
       // Calculator cal1 = new Calculator();
        result= (long) cal.sum(10.0, 15.0);
        Assert.assertEquals(result,25.0);
    }

    @Test(groups = {"positive"})
    public void SubtractTwoNumbers()
    {
        result=cal.sub(45,28);
        Assert.assertEquals(result,17.0);
    }

    @Test(groups = {"positive"})
    public void MultiplyTwoNumbers()
    {
        result= (long) cal.mult(4.5,2.5);
        Assert.assertEquals(result,11);
    }

    @Test(groups = {"positive"})
    public void DivideTwoNumbers()
    {
         result= (long) cal.div(20,2.5);
        Assert.assertEquals(result,8);
    }
    @Test(groups = {"negative"}, expectedExceptions = NumberFormatException.class)
    public void DivideByZero()
    {
        result=cal.div(20,0);
      //  Assert.assertEquals(result ,"");
    }

    @Test(groups = {"negative"})
    public void TestOverflowingInputs()
    {
        result= cal.mult(Long.MAX_VALUE,Long.MAX_VALUE);
     //   Assert.assertEquals(result ,1);
    }

    @Test(groups = {"negative"})
    public void TestNegativeSquareRoot()
    {
       result= (long) cal.sqrt(-49);
        Assert.assertEquals(result ,7);
    }

    @Test(groups = {"negative"})
    public void TestDivideNegativeNumbers()
    {
        result= cal.div(-45,-5);
        Assert.assertEquals(result ,9);
    }
    @Test(groups = {"negative"})
    public void testPowerOperation()
    {
        result = (long) cal.pow(-3.0, 2.5);
        Assert.assertEquals(result ,9);
    }

    @Test(groups = {"negative"})
    public void testInvalidInputTrigonometric()
    {
        result = (long) cal.cos(Double.NaN);
    }


    @AfterTest
    public void printResult()
    {
        System.out.println(result);
    }

}

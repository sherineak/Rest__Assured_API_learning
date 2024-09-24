package TestNg_Grouping_TestCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Lab285_DataDrivenTest {
    //Data Driven Testing By using TestNG
    //Mix the Data Driven With Apache POI
    //Data Driven Testing  -- Running a Single Testcase with Multiple input
    //Eg : Validate a Login page with 100 of username and password

    @DataProvider
    public Object[][] getDataFromExcel(){
        //ApachePOI Code
        //Read  Excel file which contain the data and give to the getDataFromExcel function
        return null;
    }

    @Test(dataProvider = "getDataFromExcel")
    public void testAuthToGetToken(String username, String password){
        System.out.println(username);
        System.out.println(password);

        // Rest  Given --> When --> then --> 200 ok or Response
    }

}

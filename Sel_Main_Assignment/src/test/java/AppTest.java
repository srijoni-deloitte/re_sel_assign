import com.aventstack.extentreports.ExtentReports;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
@Listeners(Listener.class)
public class AppTest extends Method_container
    {
        Logger log = extentController.log;
        ExtentReports extent = extentController.extent;
        @Test(priority = 1)
        public void A_openTheWebsite() throws Exception {
            ExtentTest Test = extent.createTest("T1");
            initialSetup(Test,log);
        }
        @Test(priority = 2)
        public void get_temper() throws Exception
        {
            ExtentTest Test = extent.createTest("T2");
            get_temp(Test,log);
        }
        @Test(priority = 3)
        public void choice_by_temper() throws Exception
        {
            ExtentTest Test = extent.createTest("T3");
            choice_by_temp(Test,log);
        }
        @Test(priority = 4)
        public void read_popers() throws Exception
        {
            ExtentTest Test = extent.createTest("T4");
            read_pops(Test,log);
        }
        @Test(priority = 5)
        public void adding_cart()throws Exception
        {
            ExtentTest Test = extent.createTest("T5");
            add_to_cart(Test,log);
        }
        @Test(priority = 6)
        public void verifying_cart()throws Exception
        {
            ExtentTest Test = extent.createTest("T6");
            verify_cart(Test,log);
        }
        @Test(priority = 7)
        public void checking_out()throws Exception
        {
            ExtentTest Test = extent.createTest("T7");
            check_out(Test,log);
        }
        @AfterClass
        public void close()
        {
            ExtentTest Test = extent.createTest("T8");
            closing(Test,log);
        }


    }


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

@Listeners(Listener.class)
public class Method_container {
    public Logger log;
    static WebDriver driver;
    static int new_client_id;
    static String FirstName;
    static String LastName;
    static String PinCode;
    static String deposit;
    static String withdraw;
    private static ExtentTest test;
    private ExtentReports extent;
    static int number=1;
    int cur_temp=0;
    List<String> added_prods=new ArrayList<String>();
    int cartTotal=0;


    public static void initialSetup(ExtentTest test,Logger log) throws Exception
    {
        //Loading CSV
        System.out.println("Q:A :- Open Website");
        test.log(Status.INFO,"Starting of test cases Q:A :- Open Website");
        log.info("Q:A :- Open Website");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\srijochakraborty\\Documents\\chromedriver.exe");
        test.pass("Web driver is initialized successfully");
        driver = new ChromeDriver();
        driver.get("https://weathershopper.pythonanywhere.com");
        Thread.sleep(1000);
        driver.manage().window().maximize();
        log.info("Website is opened and window is Maximized");
        test.pass("Web pages is opened and maximized");

    }
    public void get_temp(ExtentTest test,Logger log) throws Exception{
        test.info("Q:B :- Get the temperature:- Current Temperature");
        System.out.println("Q:B :- Get the temperature:- Current Temperature");
        log.info("Q:B :- Get the temperature:- Current Temperature");
        //Clicked "bank manager login"
        Thread.sleep(2000);
        int cur_temp= Integer.parseInt(driver.findElement(By.xpath("/html/body/div/div[2]/div/span")).getText().split(" ")[0]);
        this.cur_temp=cur_temp;
        Thread.sleep(2000);

        test.pass("Successfully Fetched Temperature"+ cur_temp);
        log.info("Successfully Fetched Temperature"+ cur_temp);
        System.out.println("Successfully Fetched Temperature"+ cur_temp);
    }
    public void choice_by_temp(ExtentTest test,Logger log) throws Exception{
        //Click "Open Account"
        test.info("Q:C :- If t<25C then Moisturiser , Else Sunscreen");
        System.out.println("Q:C :- If t<25C then Moisturiser , Else Sunscreen");
        log.info("Q:C :- If t<25C then Moisturiser , Else Sunscreen");
        if (this.cur_temp<25){
            test.info("Choosing Moisturiser");
            System.out.println("Choosing Moisturiser");
            log.info("Choosing Moisturiser");
            driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/a/button")).click();
        }
        else{
            test.info("Choosing Sunscreen");
            System.out.println("Choosing Sunscreen");
            log.info("Choosing Sunscreen");
        driver.findElement(By.xpath("/html/body/div/div[3]/div[2]/a/button")).click();
        }

        test.pass("Choosing successful" );
        log.info("Choosing successful");
        System.out.println("Choosing successful");

    }
    public  static void read_pops(ExtentTest test,Logger log) throws Exception{
        // Click "Home
        test.info("Q:D :- Reading <i> Tag" );
        System.out.println("Q:D :- Reading <i> Tag");
        log.info("Q:D :- Reading <i> Tag");
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/span")).click();
        Thread.sleep(2000);
        //clicking "customer login section"

        String info=driver.findElement(By.xpath("/html/body/div[3]/div[2]")).getText();
        Thread.sleep(2000);

        //Loggedin as new User
        test.pass("Read Info:- "+info);
        log.debug("Read Info:- "+info);
        System.out.println("Read Info:- "+info);

    }
    public void add_to_cart(ExtentTest test,Logger log) throws Exception{
        // Fetching Current Balance before deposit
        test.info("Q:E :- Adding to cart" );
        System.out.println("Q:E :- Adding to cart");
        log.info("Q:E :- Adding to cart");

        this.added_prods.add(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/p[1]")).getText());
        test.info("Added:"+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/p[1]")).getText()+ " Price:" +driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/p[2]")).getText());
        System.out.println("Added:"+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/p[1]")).getText()+ " Price:" +driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/p[2]")).getText());
        log.info("Added:"+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/p[1]")).getText()+ " Price:" +driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/p[2]")).getText());
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/button")).click();
        this.cartTotal+=Integer.parseInt(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/p[2]")).getText().split(" ")[2]);
        Thread.sleep(2000);
        this.added_prods.add(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/p[1]")).getText());
        test.info("Added:"+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/p[1]")).getText()+ " Price:" +driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/p[2]")).getText());
        System.out.println("Added:"+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/p[1]")).getText()+ " Price:" +driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/p[2]")).getText());
        log.info("Added:"+driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/p[1]")).getText()+ " Price:" +driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/p[2]")).getText());
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/button")).click();
        System.out.println(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/p[2]")).getText());
        this.cartTotal+=Integer.parseInt(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/p[2]")).getText().split(" ")[2]);
        Thread.sleep(2000);
        test.pass("Added 2 Items of Rs."+this.cartTotal);
        log.debug("Added 2 Items of Rs."+this.cartTotal);
        System.out.println("Added 2 Items of Rs."+this.cartTotal);
    }
    public void verify_cart(ExtentTest test,Logger log) throws Exception{
        test.info("Q:F :- Verifying Cart for "+this.added_prods.size()+" items");
        System.out.println("Q:F :- Verifying Cart for "+this.added_prods.size()+" items");
        log.info("Q:F :- Verifying Cart for "+this.added_prods.size()+" items");
        driver.findElement(By.xpath("/html/body/nav/ul/button")).click();
        Thread.sleep(2000);
        int cart_total_got= Integer.parseInt(driver.findElement(By.xpath("/html/body/div[1]/div[2]/p")).getText().split(" ")[2]);
        if (cart_total_got!=this.cartTotal){
            test.fail("Cart verification Failed");
            log.error("Cart verification Failed");
            System.out.println("Cart verification Failed");
        }
        else{
            test.pass("Cart verification passed. Actual value "+this.cartTotal+", Fetched Value "+cart_total_got);
            log.info("Cart verification passed. Actual value "+this.cartTotal+", Fetched Value "+cart_total_got);
            System.out.println("Cart verification passed. Actual value "+this.cartTotal+", Fetched Value "+cart_total_got);
        }
    }
    public void check_out(ExtentTest test,Logger log) throws Exception{

        //Trying to withdraw more than available balance
        String originalWindow = driver.getWindowHandle();
        System.out.println(originalWindow);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://stripe.com/docs/testing#cards");
        Thread.sleep(4000);

        String card_no1=driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div/div/div[2]/div[1]/article/div[2]/div[5]/div[2]/div/div/div/table/tbody/tr[1]/td[2]/button/span/span[1]")).getText();
        String card_no2=driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div/div/div[2]/div[1]/article/div[2]/div[5]/div[2]/div/div/div/table/tbody/tr[1]/td[2]/button/span/span[1]")).getText();
        String card_no3=driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div/div/div[2]/div[1]/article/div[2]/div[5]/div[2]/div/div/div/table/tbody/tr[1]/td[2]/button/span/span[1]")).getText();
        String card_no4=driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div/div/div/div[2]/div[1]/article/div[2]/div[5]/div[2]/div/div/div/table/tbody/tr[1]/td[2]/button/span/span[1]")).getText();
        driver.switchTo().window(originalWindow);
        Thread.sleep(4000);
        String cvc="111";
        String date_m="06";
        String date_y="24";
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/button/span")).click();
        Thread.sleep(2000);
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe")));
        WebElement email = driver.findElement(By.xpath("/html/body/div[3]/form/div[2]/div/div[4]/div/div[1]/div/input"));
        WebElement card = driver.findElement(By.xpath("/html/body/div[3]/form/div[2]/div/div[4]/div/div[2]/div/div/div/div/div/div/div[1]/input"));
        WebElement dt = driver.findElement(By.xpath("/html/body/div[3]/form/div[2]/div/div[4]/div/div[2]/div/div/div/div/div/div/div[2]/input"));
        WebElement cv = driver.findElement(By.xpath("/html/body/div[3]/form/div[2]/div/div[4]/div/div[2]/div/div/div/div/div/div/div[3]/input"));
        WebElement zip = driver.findElement(By.xpath("/html/body/div[3]/form/div[2]/div/div[4]/div/div[2]/div/div/div/div/div/div/div[4]/input"));
        email.sendKeys("srijonichakraborty98@gmail.com");
        card.sendKeys(card_no1);
        card.sendKeys(card_no2);
        card.sendKeys(card_no3);
        card.sendKeys(card_no4);
        dt.sendKeys(date_m);
        dt.sendKeys(date_y);
        cv.sendKeys(cvc);
        zip.sendKeys("724103");

        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/form/div[2]/div/div[3]/div/div/div/button/span/span")).click();
        Thread.sleep(10000);
        String message=driver.findElement(By.xpath("/html/body/div[1]/div[1]/h2")).getText();
        if (message.equals("PAYMENT SUCCESS")){
            test.pass("Payment Successful, Order Placed !!!");
            log.info("Payment Successful, Order Placed !!!");
            System.out.println("Payment Successful, Order Placed !!!");
        }
        else{
            test.fail("Payment UnSuccessful, Order Could not be placed :(");
            log.debug("Payment UnSuccessful, Order Could not be placed :(");
            System.out.println("Payment UnSuccessful, Order Could not be placed :(");
        throw new Exception("***Payment Unsuccessful***");
        }
    }

    public static WebDriver closing(ExtentTest test,Logger log)
    {
        test.info("Browser is closed");
        log.info("Browser is getting closed");
        driver.close();
        extentController.extent.flush();
        return null;
    }

}

package HomeWork;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class SignInHomework {
    WebDriver driver;
    Faker faker = new Faker();
    @Before
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void signIn() throws InterruptedException {
    driver.findElement(By.linkText("Sign in")).click();
    driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("bette.mraz@yahoo.com");
    driver.findElement(By.xpath("//i[@class='icon-user left']")).click();

        WebElement CreateAnAccount = driver.findElement(By.xpath("//h1[@class='page-heading']"));
    Assert.assertTrue(CreateAnAccount.isDisplayed()); //"CREATE AN ACCOUNT" title Assertion

        WebElement YourPersonalInfo = driver.findElement(By.xpath("//h3[@class='page-subheading']"));
    Assert.assertTrue(YourPersonalInfo.isDisplayed());//Your Personal Information Assertion

        WebElement TextTitle = driver.findElement(By.xpath(("(//label)[1]")));
    Assert.assertTrue(TextTitle.isDisplayed());//Title Assertion

        driver.findElement(By.xpath("//input[@id='id_gender1']")).click(); //Title Selection
        //String firstName = faker.name().firstName();==>Janet
        driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("Janet");
        //String lastName = faker.name().lastName();==>Daniel
        driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("Daniel");

        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("12345678");
                //sendKeys(faker.internet().password());==>12345678
        //Dropdown day selection
        WebElement dateDropdown =driver.findElement(By.xpath("//select[@id='days']"));
        Select daySelect = new Select(dateDropdown);
        Thread.sleep(500);
        //daySelect.selectByValue(String.valueOf(faker.number().numberBetween(1, 28)));==>1
        daySelect.selectByIndex(1);
        Thread.sleep(500);

        //Dropdown month selection
        WebElement monthDropdown =driver.findElement(By.xpath("//select[@id='months']"));
        Select monthSelect = new Select(monthDropdown);
        Thread.sleep(500);
        //monthSelect.selectByIndex(faker.number().numberBetween(1, 12));==>August
        monthSelect.selectByIndex(8);
        Thread.sleep(500);

        //Dropdown year selection
        WebElement yearDropdown =driver.findElement(By.xpath("//select[@id='years']"));
        Select yearSelect = new Select(yearDropdown);
        Thread.sleep(500);
        //yearSelect.selectByIndex(faker.number().numberBetween(1, 121));==>1941
        yearSelect.selectByIndex(81);
        Thread.sleep(500);

        //Click on Sign up for our newsletter!
        WebElement checker01 = driver.findElement(By.xpath("//div[@id='uniform-newsletter']"));
        if (!checker01.isSelected()){
            checker01.click();
        }

        //Enter First name
        WebElement firstNameFill = driver.findElement(By.xpath("//input[@id='firstname']"));
        firstNameFill.clear();
        firstNameFill.sendKeys("Janet");

        //Enter Last name
        WebElement lastNameFill = driver.findElement(By.xpath("//input[@id='lastname']"));
        lastNameFill.clear();
        lastNameFill.sendKeys("Daniel");

        //Enter your company
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("Price, Strosin and Connelly");
                //sendKeys(faker.company().name());==>Price, Strosin and Connelly

        //Enter your Address
        driver.findElement(By.xpath("//input[@id='address1']")).sendKeys("18801 Rey Passage");
                //sendKeys(faker.address().streetAddress());==>18801 Rey Passage

        //Enter your Address2
        driver.findElement(By.xpath("//input[@id='address2']")).sendKeys("63184");
                //sendKeys(faker.address().buildingNumber());==>63184

        //Enter your City
        driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Denverview");
                //sendKeys(faker.address().cityName());==>Denverview

        //Select State
        Thread.sleep(500);
        WebElement stateDropdown = driver.findElement(By.xpath("//select[@id='id_state']"));
        Select stateSelect = new Select(stateDropdown);
        stateSelect.selectByIndex(50);
        //stateSelect.selectByIndex(faker.number().numberBetween(1, 53));==>Washington
        Thread.sleep(500);

        //Enter postal code
        driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys("43651");
                //sendKeys(faker.address().zipCode());

        //Select Country
        Thread.sleep(500);
        WebElement countryDropdown = driver.findElement(By.xpath("//select[@id='id_country']"));
        Select countrySelect = new Select(countryDropdown);
        countrySelect.selectByIndex(1);
        Thread.sleep(500);

        //Enter Additional Information
        driver.findElement(By.xpath("//textarea[@id='other']")).sendKeys("This is Selenium Homework");

        //Enter home phone
        driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("103-557-2461");
                //sendKeys(faker.phoneNumber().phoneNumber());==>103-557-2461

        //Enter mobile phone
        driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys("1-920-904-1411");
        //sendKeys(faker.phoneNumber().cellPhone());==>1-920-904-1411

        //Enter reference name
        WebElement referenceName = driver.findElement(By.xpath("//input[@id='alias']"));
        referenceName.clear();
        referenceName.sendKeys("My Selenium Address");

        //Click Register
        driver.findElement(By.xpath("//button[@id='submitAccount']")).click();

        //Assertion MY ACCOUNT
        WebElement myAccountDisplay = driver.findElement(By.xpath("//h1[@class='page-heading']"));
        Assert.assertTrue(myAccountDisplay.isDisplayed());

    }
    @After
    public void tearDown(){
        driver.close();
    }

}

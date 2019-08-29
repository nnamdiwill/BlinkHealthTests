import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Listeners(BlinkHealthTests.TestNGListeners.class)
public class MainClass {

    @Test
    public void firstTestCase() throws IOException {
        System.setProperty("webdriver.chrome.driver","/usr/local/bin/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        WebDriver driver = new ChromeDriver(options);
        String url = "https://www.blinkhealth.com/";

        driver.get(url);
        System.out.println(driver.getTitle());
        System.out.println( "The window handle is " + driver.getWindowHandle());

        driver.manage().window().maximize();

     WebElement zocorType =   driver.findElement(By.xpath("//input[@placeholder='Type your drug name (ex. Lipitor)']"));
     zocorType.sendKeys("Zocor");
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
     zocorType.sendKeys(Keys.ENTER);

  // driver.findElement(By.xpath("//div[@class='_1xRX8 _3Dv3E']//button[@class='_35zau stNWf _16qJ4 _3yWNu U6uo5 _3Dv3E _2cfnH _2vo2D']")).click();



//        public void selectAutoCompleteforNY() throws InterruptedException {
//
//            WebElement element = SharedSD.getDriver().findElement(clickNY);
//
//            Actions act = new Actions(SharedSD.getDriver());
//            act.moveToElement(element).build().perform();
//            Thread.sleep(3000);
//            SharedSD.getDriver().findElement(clickNY).click();
//
//        }

//        WebElement zocorHighlight = driver.findElement(By.xpath("//div[@data-qa='Search Result']//div//span[contains(text(),'Zocor • simvastatin')]"));
//        Actions act1 = new Actions(driver);
//        act1.moveToElement(zocorHighlight).build().perform();
//        driver.findElement(By.xpath("//input[@placeholder='Type your drug name (ex. Lipitor)']")).click();
     //   ((JavascriptExecutor) driver).executeScript("arguments[0].click",zocorType);
//        JavascriptExecutor js = (JavascriptExecutor)driver ;
//        js.executeScript("arguments[0].value='zocor';",zocorType);


        driver.findElement(By.xpath("//*[contains(text(),'Zocor')]")).getText();
//        Select drpCountry = new Select(driver.findElement(By.name("country")));
//        drpCountry.selectByVisibleText("ANTARCTICA");
//
//        //Selecting Items in a Multiple SELECT elements
//        driver.get("http://jsbin.com/osebed/2");
//        Select fruits = new Select(driver.findElement(By.id("fruits")));
//        fruits.selectByVisibleText("Banana");
//        fruits.selectByIndex(1);


   WebElement threeNinety =  driver.findElement(By.xpath("//*[text()='Blink Everyday Low Price']"));
        Date currentDate = new Date();

   if(threeNinety.isSelected()){
       TakesScreenshot ts = (TakesScreenshot) driver;
       File source = ts.getScreenshotAs(OutputType.FILE);
       File destination = new File("failureFolder"+" "+ currentDate+ ".png");
       FileUtils.copyFile(source, destination);
      System.out.print(threeNinety.getText());

   }else{
       threeNinety.click();
       System.out.println("3.90 is selected: " + threeNinety.isDisplayed());
   }

   driver.navigate().to("https://www.medidata.com/");
   driver.findElement(By.cssSelector("a[class='medium cli-plugin-button cli-plugin-main-button cookie_action_close_header cli_action_button']")).click();
   System.out.println(driver.getTitle());

//        WebDriverWait wdw = new WebDriverWait(driver,20);
//        WebElement we2 = wdw.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//path[@id='svg_5']")));
//        we2.click()
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Zocor')]")));
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}

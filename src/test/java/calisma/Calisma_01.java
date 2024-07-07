package calisma;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class Calisma_01 {

    //   2- https://www.automationexercise.com/ adresine gidin
    //           3- Category bolumundeki elementleri locate edin
//4- Category bolumunde 3 element oldugunu test edin
//5- Category isimlerini yazdirin
//6- Sayfayi kapatin

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver=new ChromeDriver ();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(5));

        driver.get("https://www.automationexercise.com/");

        Actions action = new Actions(driver);

        action.sendKeys( Keys.PAGE_DOWN).perform ();

        List<WebElement> kategoriElement = driver.findElements (By.className ( "panel-heading" ) );

        if (kategoriElement.size()==3){
            System.out.println("Test basarılı");
        }else {
            System.out.println("test basarısız");

        }


        for (WebElement eachelement  : kategoriElement) {
            System.out.println(eachelement.getText());
        }

        Thread.sleep(1000);
        driver.quit();

    }


}
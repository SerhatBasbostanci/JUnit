package calisma;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase;

public class Calisma_02 extends TestBase {



    @Test
    public void Calisma_02 () throws InterruptedException {

        //   1. http://zero.webappsecurity.com sayfasina gidin

        driver.get ( "http://zero.webappsecurity.com" );

        //    2. Signin buttonuna tiklayin

        driver.findElement ( By.xpath ( "//*[@*='signin btn btn-info']" ) ).click ();


        //     3. Login alanine "username" yazdirin

        driver.findElement ( By.xpath ( "//*[@id='user_login']" ) ).sendKeys ( "username" );


        //    4. Password alanina "password" yazdirin

        driver.findElement ( By.xpath ( "//input[@id='user_password']" ) ).sendKeys ( "password" );


        //     5. Sign in buttonuna tiklayin

        driver.findElement ( By.xpath ( "//*[@id='user_password']" )).click ();

        //    6. Back tusu ile sayfaya donun

        driver.navigate ().back ();


        //     7. Online Banking menusunden Pay Bills sayfasina gidin

        driver.findElement ( By.xpath ( "//*[@*='onlineBankingMenu']" ) ).click ();

       driver.findElement ( By.xpath ( "//*[@id='pay_bills_link']" ) ).click ();

        driver.findElement ( By.xpath ( "//*[@id='user_login']" ) ).sendKeys ( "username" );

        driver.findElement ( By.xpath ( "//input[@id='user_password']" ) ).sendKeys ( "password" );

        driver.findElement (By.xpath ( "//*[@value='Sign in']" )).click ();



        //     8. amount kismina yatirmak istediginiz herhangi bir miktari yazin

            driver.navigate ().back ();

        driver.findElement ( By.xpath ( "//*[@*='onlineBankingMenu']" ) ).click ();

        driver.findElement ( By.xpath ( "//*[@id='pay_bills_link']" ) ).click ();



        WebElement alacakliBanka = driver.findElement (By.xpath ("(//*[@class='span4'])[1]"  ) );


        Select selectbank = new Select ( alacakliBanka );


        selectbank.selectByValue ( "bofa" );


        WebElement parahesap = driver.findElement (By.xpath ("(//*[@class='span4'])[2]"  ) );




        Select select = new Select ( parahesap );


        select.selectByValue ( "5" );



        driver.findElement ( By.xpath ( "//*[@*='amount']" ) ).sendKeys ( "10000");



        //     9. tarih kismina "2023-09-10" yazdirin


        ReusableMethods.bekle ( 2 );


        driver.findElement ( By.xpath ( "//*[@id='sp_date']" ) ).sendKeys ( "2023-09-10" );


        //      10. Pay buttonuna tiklayin

        driver.findElement ( By.xpath ( "//*[@*='btn btn-primary']" ) ).click ();


        ReusableMethods.bekle ( 5 );




        //      11. "The payment was successfully submitted." mesajinin ciktigini test edin




        WebElement odemeSonuc = driver.findElement ( By.xpath ( "//*[@id='alert_content']" ) );


        String expectedAlertYazi = "The payment was successfully submitted.";

        String actualAlertYazi= odemeSonuc.getText ();


        Assertions.assertEquals ( expectedAlertYazi,actualAlertYazi );


    }




}

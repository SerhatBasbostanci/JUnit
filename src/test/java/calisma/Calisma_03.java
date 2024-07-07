package calisma;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Calisma_03 extends TestBase {



    @Test

    public void calisma_03 () throws InterruptedException {


        //   https://facebook.com
        //   b. Cookies'i kabul edin
        //    c. Create an account buton'una basin
        //    d. Radio button elementlerini locate edin ve size uygun olani secin
        //     e. Sectiginiz radio button'un seçili, ötekilerin seçili olmadigini test edin.

        driver.get ( "https://facebook.com" );

        driver.findElement ( By.xpath ( "//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']" )).click ();

        WebElement kadin = driver.findElement ( By.xpath ( "(//*[@type='radio'])[1]" ) );
        WebElement erkek = driver.findElement ( By.xpath ( "(//*[@type='radio'])[2]" ) );
        WebElement ozel = driver.findElement ( By.xpath ( "(//*[@type='radio'])[3]" ) );

        ozel.click ();

        Thread.sleep ( 3000 );

        Assertions.assertTrue ( ozel.isSelected () );
        Assertions.assertFalse ( kadin.isSelected () );
        Assertions.assertFalse ( erkek.isSelected () );


    }
}



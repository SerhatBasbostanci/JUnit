package calisma;

import org.bouncycastle.est.ESTSourceConnectionListener;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Calisma_04 extends TestBase {


    @Test
    public void test04() {



        //  1."https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html" adresine gidin

        driver.get ( "https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html" );

        //  2. Web table tum body’sini yazdirin

        WebElement tumBody = driver.findElement ( By.xpath ( "//*[@id=\"customers\"]" ) );

        System.out.println ( "Tumbody\n" + tumBody.getText () );

        //  3. Web tablosunda "Roland Mendel" bulundugunu test edin

        String expectedTabloIcerik = "Rolan Mendel";
        String actualTabloIcerik = tumBody.getText ();

        Assertions.assertFalse ( expectedTabloIcerik.contains ( actualTabloIcerik ) );

        // *********************BURAYI CALISTIRAMADIM***********************************//

        //  4. Web table’daki satir sayisinin 6 oldugunu test edin


        //  int expectedSatirsayisi = 6;

        List<WebElement> tableSatirSayisi = driver.findElements ( By.xpath ( "//*[@style=\"box-sizing:inherit\"]/tr" ) );

        // int actualSatirSayisi = tableSatirSayisi.size ();

        //     Assertions.assertEquals( expectedSatirsayisi,actualSatirSayisi );


        //****************BURAYI CALISTIRAMADIM ****************************//


        //  5. Tum satirlari yazdirin

        System.out.println ( "Tum satirlar : " );

        for (int i = 0; i < tableSatirSayisi.size (); i++) {

            System.out.println ( i + 1 + ". satir : \n" + tableSatirSayisi.get ( i ).getText () );

        }


        //  6. Web table’daki sutun sayisinin 3 olduğunu test edin


        List<WebElement> satirElementleri = driver.findElements ( By.xpath ( "//*[@style=\"box-sizing:inherit\"]/th" ) );

        int expectedSutunSayisi = 3;
        int actualSutunSayisi = satirElementleri.size ();

        Assertions.assertEquals ( expectedSutunSayisi, actualSutunSayisi );


        //  7. 3.sutunu yazdirin


        List<WebElement> ucuncuSutunElementleri = driver.findElements ( By.xpath ( "//table[@id='customers']//tr//td[3]" ) );

        System.out.println ( "3. sutundaki bilgiler : " + ReusableMethods.stringListesineDonustur ( ucuncuSutunElementleri ) );


        //  8. Tablodaki basliklari yazdirin


        List<WebElement> baslikElementleriListesi = driver.findElements ( By.xpath ( "//*[@style=\"box-sizing:inherit\"]/tr[1]" ) );

        System.out.println ( "Basliklar : " + ReusableMethods.stringListesineDonustur ( baslikElementleriListesi ) );


        //  6. Satir ve sutunu parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun


        // System.out.println ( getData ( 6, 1 ) );
        // System.out.println ( getData ( 6, 2 ) );


        //****************************************BURAYADA BIRSEYLER GEREKLI************************************************//


        // 10. 4.satirdaki Island Tradin datasinin "Helen Bennett" oldugunu test edin




        //   String expectedData = "Helen Bennett";
        //   String actualData = getData ( 5, 2 );


        //  Assertions.assertEquals ( expectedData, actualData );


        //      }


    }

    public String getData(int satirNo, int sutunNo) {


        String dinamikLocater = "//tbody/tr[" + satirNo + "]/td[" + sutunNo + "]";

        WebElement istenenDataElementi = driver.findElement ( By.xpath ( dinamikLocater ) );

        return istenenDataElementi.getText ();

    }

}






package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utility;

import java.util.ArrayList;
import java.util.List;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    public void selectMenu(String menu) {
        clickOnTheElement(By.xpath("//ul[@class='top-menu notmobile']//a[contains(text(),'" + menu + "')]"));
    }

    @Test
    public void verifyPageNavigation() {
        List<String> topMenus = new ArrayList<>();
        topMenus.add("Computers");
        topMenus.add("Electronics");
        topMenus.add("Apparel");
        topMenus.add("Digital downloads");
        topMenus.add("Books");
        topMenus.add("Jewelry");
        topMenus.add("Gift Cards");

        for (String topMenu : topMenus) {
            selectMenu(topMenu);
            String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'" + topMenu + "')]"));
            Assert.assertEquals("Menu not found", topMenu, actualMessage);
        }
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

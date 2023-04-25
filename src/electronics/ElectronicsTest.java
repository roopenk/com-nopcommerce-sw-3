package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

public class ElectronicsTest extends Utility {
    @Before
    public void setUp() {
        openBrowser("https://demo.nopcommerce.com/");
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() throws InterruptedException {
        //Hover over electronics
        mouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']/li/a[text()='Electronics ']"));
        //click on cell phones
        clickOnTheElement(By.xpath("//ul[@class='top-menu notmobile']/li/ul[@class='sublist first-level']/li/a[text()='Cell phones ']"));
        //define expected text
        String expectedCellPhoneText = "Cell phones";
        //get actual text
        String actualCellPhonesText = getTextFromElement(By.xpath("//h1[normalize-space()='Cell phones']"));
        //verify expected and actual are the same
        Assert.assertEquals("not on cell phones tab", expectedCellPhoneText, actualCellPhonesText);
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        mouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']/li/a[text()='Electronics ']"));
        mouseHoverAndClickOnElement(By.xpath("//body[1]/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        String expectedCellPhoneText = "Cell phones";
        String actualCellPhonesText = getTextFromElement(By.xpath("//div[@class='page-title']/h1"));
        Thread.sleep(1000);
        Assert.assertEquals("not on cell phones tab", expectedCellPhoneText, actualCellPhonesText);
        //2.4 Click on List View Tab
        clickOnTheElement(By.xpath("//a[@class='viewmode-icon list']"));
        //2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(2000);
        clickOnTheElement(By.linkText("Nokia Lumia 1020"));
        //define expected
        String expectedNokia = "Nokia Lumia 1020";
        //get actual
        String actualNokia = getTextFromElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/h1[1]"));
        //2.6 Verify the text “Nokia Lumia 1020”
        Assert.assertEquals("not on nokia", expectedNokia, actualNokia);
        //define expected
        String expectedNokiaPrice = "$349.00";
        //get actual
        String actualNokiaPrice = getTextFromElement(By.xpath("//span[@id='price-value-20']"));
        //2.7 Verify the price “$349.00”
        Assert.assertEquals("Nokia price not $349.00", expectedNokiaPrice, actualNokiaPrice);
        //2.8 Change quantity to 2
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).sendKeys("2");
        //2.9 Click on “ADD TO CART” tab
        clickOnTheElement(By.xpath("//button[@class='button-1 add-to-cart-button']"));
        //define expected
        String expectedShoppingCartAdd = "The product has been added to your shopping cart";
        //get actual
        String actualShoppingCartAdd = getTextFromElement(By.xpath("//div[@class='bar-notification success']/p"));
        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        Assert.assertEquals("not added", expectedShoppingCartAdd, actualShoppingCartAdd);
        //After that close the bar clicking on the cross button.
        clickOnTheElement(By.xpath("//div[@class='bar-notification success']/span"));
        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverOnElement(By.xpath("//span[@class='cart-label']"));
        clickOnTheElement(By.xpath("//button[@class='button-1 cart-button']"));
        //define expected
        String expectedTextShoppingCart = "Shopping cart";
        //get actual
        String actualTextShoppingCart = getTextFromElement(By.xpath("//div[@class='page-title']/h1"));
        //2.12 Verify the message "Shopping cart"
        Assert.assertEquals("not on shopping cart", expectedTextShoppingCart, actualTextShoppingCart);

        WebElement text = driver.findElement(By.xpath("//input[@class='qty-input']"));
        String expectedText1 = "2";
        String actualText2 = text.getAttribute("value");
        Assert.assertEquals("not equal", expectedText1, actualText2);

        //define expected
        String expectedTotal = "$698.00";
        //get actual
        String actualTotal = getTextFromElement(By.xpath("//tbody/tr[1]/td[6]/span[1]"));
        //2.14 Verify the Total $698.00
        Assert.assertEquals("not $698.00", expectedTotal, actualTotal);
        //2.15 click on checkbox “I agree with the terms of service”
        Thread.sleep(1000);
        clickOnTheElement(By.xpath("//input[@id='termsofservice']"));
        //2.16 Click on “CHECKOUT”
        clickOnTheElement(By.xpath("//button[@id='checkout']"));
        Thread.sleep(1000);
        //define expected text
        String expectedWelcome = "Welcome, Please Sign In!";
        //get actual text
        String actualWelcome = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        //Verify the Text “Welcome, Please Sign In!”
        Assert.assertEquals("Not on sign in page", expectedWelcome, actualWelcome);
        //2.18 Click on “REGISTER” tab
        Thread.sleep(1500);
        //click on register button
        //mouseHoverToElement(By.xpath("//button[contains(text(),'Register')]"));
        clickOnTheElement(By.xpath("//button[contains(text(),'Register')]"));
        //define expected
        String expectedRegister = "Register";
        //get actual
        String actualRegister = getTextFromElement(By.xpath("//h1[text()='Register']"));
        //2.19 Verify the text “Register”
        Assert.assertEquals("Not registered", expectedRegister, actualRegister);
        //2.20 Fill the mandatory fields
        Thread.sleep(1000);
        //Enter First Name
        sendTextToElement(By.id("FirstName"), "Roopen");
        //Enter Last Name
        sendTextToElement(By.id("LastName"), "Patel");
        //Enter Date
        sendTextToElement(By.xpath("//select[@name='DateOfBirthDay']"), "25");
        //Enter Month
        sendTextToElement(By.xpath("//select[@name='DateOfBirthMonth']"), "November");
        //Enter Year
        sendTextToElement(By.xpath("//select[@name='DateOfBirthYear']"), "1981");
        //Enter Email
        sendTextToElement(By.id("Email"), getRandomEmail());
        //Enter Password
        sendTextToElement(By.id("Password"), "Xyz123");
        //Enter Confirm password
        sendTextToElement(By.id("ConfirmPassword"), "Xyz123");
        //2.21 Click on “REGISTER” Button
        Thread.sleep(1000);
        clickOnTheElement(By.id("register-button"));
        //define expected
        String expectedRegistration = "Your registration completed";
        //get actual text
        String actualRegistration = getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        //2.22 Verify the message “Your registration completed”
        Thread.sleep(1000);
        Assert.assertEquals("not registered", expectedRegistration, actualRegistration);
        //2.23 Click on “CONTINUE” tab
        clickOnTheElement(By.xpath("//a[contains(text(),'Continue')]"));
        //define expected
        String expectedShoppingCart = "Shopping cart";
        //get actual
        String actualShoppingCart = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        //2.24 Verify the text “Shopping cart”
        Assert.assertEquals("not on shopping cart", expectedTextShoppingCart, actualTextShoppingCart);
        //2.25 click on checkbox “I agree with the terms of service”
        Thread.sleep(1000);
        clickOnTheElement(By.xpath("//input[@id='termsofservice']"));
        //2.26 Click on “CHECKOUT”
        Thread.sleep(1000);
        //clickOnElement(By.xpath("//button[@id='checkout']"));
        //2.27 Fill the Mandatory fields
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United States");
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"), "Texas");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "Houston");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "1234 Raleigh St.");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "77021");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "3952724");
        //2.28 Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnTheElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));
        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        Thread.sleep(1000);
        clickOnTheElement(By.xpath("//input[@id='shippingoption_2']"));
        //2.30 Click on “CONTINUE”
        Thread.sleep(1000);
        clickOnTheElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        //2.31 Select Radio Button “Credit Card”
        clickOnTheElement(By.xpath("//input[@id='paymentmethod_1']"));
        //continue
        Thread.sleep(1000);
        clickOnTheElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));
        //2.32 Select “Visa” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Visa");
        //2.33 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Mr HELLO PATEL");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5555555555554444");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "05");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2025");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "123");
        //2.34 Click on “CONTINUE”
        clickOnTheElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //define expected
        String expectedCard = "Credit Card";
        //get actual text
        String actualCard = getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]"));
        //2.35 Verify “Payment Method” is “Credit Card”
        Assert.assertEquals("Not credit card", expectedCard, actualCard);
        //define expected
        String expectedShippingMethod = "2nd Day Air";
        //get actual
        String actualShippingMethod = getTextFromElement(By.xpath("//li[@class='shipping-method']/span[@class='value']"));
        //2.36 Verify “Shipping Method” is “2nd Day Air”
        Assert.assertEquals("not 2nd day air", expectedShippingMethod, actualShippingMethod);
        //define expected
        String expectedTotalPrice = "$698.00";
        //get actual
        String actualTotalPrice = getTextFromElement(By.xpath("//tbody/tr[1]/td[6]/span[1]"));
        //2.37 Verify Total is “$698.00”
        Assert.assertEquals("Price not $698.00", expectedTotalPrice, actualTotalPrice);
        //2.38 Click on “CONFIRM”
        clickOnTheElement(By.xpath("//button[contains(text(),'Confirm')]"));
        //2.39 Verify the Text “Thank You”
        String expectedMessage14 = "Thank you";
        //Actual Message
        String actualMessage14 = getTextFromElement(By.xpath("//h1[text()='Thank you']"));
        //Validate actual and Expected message
        Assert.assertEquals(expectedMessage14, actualMessage14);
        //2.40 Verify the message “Your order has been successfully processed!”
        String expectedMessage15 = "Your order has been successfully processed!";
        //Actual Message
        String actualMessage15 = getTextFromElement(By.xpath("//strong[text()='Your order has been successfully processed!']"));
        //Validate actual and Expected message
        Assert.assertEquals(expectedMessage15, actualMessage15);
        //2.41 Click on “CONTINUE”
        clickOnTheElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
        //2.42 Verify the text “Welcome to our store”
        String expectedMessage16 = "Welcome to our store";
        //Actual Message
        String actualMessage16 = getTextFromElement(By.xpath("//h2[text()='Welcome to our store']"));
        //Validate actual and Expected message
        Assert.assertEquals(expectedMessage16, actualMessage16);
        //2.43 Click on “Logout” link
        clickOnTheElement(By.xpath("//a[contains(text(),'Log out')]"));
        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String expectedMessage17 = "https://demo.nopcommerce.com/";
        //Actual Message
        String actualMessage17 = driver.getCurrentUrl();
        //Validate actual and Expected message
        Assert.assertEquals(expectedMessage17, actualMessage17);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

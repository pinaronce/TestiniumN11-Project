package methods;

import baseTest.BaseTest;
import baseTest.Log;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Random;

public class Methods extends BaseTest {

    public void waitCssElement(String locator) {
        WebDriverWait waitclik = new WebDriverWait(driver,10);
        waitclik.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));

    }

    public void waitXpathElement(String locator) {
        WebDriverWait waitclik = new WebDriverWait(driver,10);
        waitclik.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    public WebElement findElementCssSelector(String locator){
        return driver.findElement(By.cssSelector(locator));
    }

    public void clickElementXpath(String locator){
        waitXpathElement(locator);
        WebElement element = driver.findElement(By.xpath(locator));
        element.click();
        Log.info("Click" + locator + "element" );
    }

    public void clickCss(String locator){
        waitCssElement(locator);
        findElementCssSelector(locator).click();
        Log.info("Click " + locator + " element" );
    }

    public void urlControl(){
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("HomePage is loading fail!",currentUrl,url);
        Log.info("HomePage is loading success.");
    }

    public void sendKeyCss(String locator,String text){
        waitCssElement(locator);
        findElementCssSelector(locator).sendKeys(text);
        Log.info("SendKeys :" +text+ " to "+locator);
    }

    public void loginControl(String locator){
        waitCssElement(locator);
        findElementCssSelector(locator).getText();
        Assert.assertEquals("Login is fail!",locator,"Deneme User");
        Log.info("Login is success.");
    }

    public void pageControl(){
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl ="https://www.n11.com/arama?q=Bilgisayar&pg=2";
        Assert.assertEquals("Page is not 2",expectedUrl,currentUrl);
        Log.info("Page control is success.");
    }

    public void randomInLıst(String locator){
        List<WebElement> products = driver.findElements(By.cssSelector(locator));
        Random rand = new Random();
        products.get(rand.nextInt(products.size())).click();
        Log.info("Select random product.");
    }

    public  void elementExistControl(String locator){
        List<WebElement> addBasketelement = driver.findElements(By.cssSelector(locator));

        if (addBasketelement.size()>0){
            Log.info("Element is exist " + locator);
            addBasketelement.get(0).click();
        }
    }

    public void priceControl(String productLocator, String basketLocator){
        String productPrice = findElementCssSelector(productLocator).getText();
        String basketPrice = findElementCssSelector(basketLocator).getText();
        Assert.assertEquals("Price is not equal!",productPrice,basketPrice);
        Log.info("Price control is success.");
        }

    public void numberControl(String locator){
        String numberSpinner = findElementCssSelector(locator).getAttribute("value");
        Assert.assertEquals("Product amount is not equal 2!",numberSpinner,"2");
        Log.info("Product amount control is success.");
    }

}

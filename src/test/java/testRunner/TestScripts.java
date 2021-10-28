package testRunner;

import baseTest.BaseTest;
import baseTest.Log;
import methods.Methods;
import org.junit.Test;
import pageObject.BasketPageObject;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.ShopPageObject;

public class TestScripts extends BaseTest {
    Methods methods = new Methods();
    HomePageObject homePageObject = new HomePageObject();
    LoginPageObject loginPageObject = new LoginPageObject();
    ShopPageObject shopPageObject = new ShopPageObject();
    BasketPageObject basketPageObject = new BasketPageObject();

    @Test
    public void testScripts() throws InterruptedException {

        methods.clickElementXpath(homePageObject.frontPopUpClose);
        methods.waitXpathElement(homePageObject.backPopUp2Close);
        methods.clickElementXpath(homePageObject.backPopUp2Close);
        methods.clickCss(homePageObject.cookie);
        methods.urlControl();

        //methods.clickCss(loginPageObject.login);
        //methods.sendKeyCss(loginPageObject.email,email);
        //methods.sendKeyCss(loginPageObject.password,password);
        //methods.clickCss(loginPageObject.loginButton);
        //methods.loginControl(loginPageObject.accountText);

        methods.sendKeyCss(shopPageObject.searchBox,searchText);
        methods.clickCss(shopPageObject.searchButton);
        methods.clickCss(shopPageObject.pageTwo);
        methods.waitCssElement(shopPageObject.productList);
        methods.pageControl();
        methods.randomInLıst(shopPageObject.productList);


        methods.waitCssElement(basketPageObject.productDetail);
        methods.elementExistControl(basketPageObject.addBasket);
        methods.elementExistControl(basketPageObject.addBasketNow);
        methods.clickCss(basketPageObject.basketButton);
        methods.clickCss(basketPageObject.basketPopUp);
        methods.priceControl(basketPageObject.priceProduct, basketPageObject.priceBasket);
        methods.clickCss(basketPageObject.spinnerUp);
        methods.numberControl(basketPageObject.spinnerControl);
        methods.clickCss(basketPageObject.removeBasket);
        methods.waitCssElement(basketPageObject.emptyBasket);
        methods.elementExistControl(basketPageObject.emptyBasket);

    }
}

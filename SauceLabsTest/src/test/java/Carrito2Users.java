import org.junit.Assert;
import org.junit.Test;
import pages.Home;
import pages.Login;
import utilities.DriverManager;

public class Carrito2Users extends Base {

    @Test
    public void verifyCartNotSharedBetweenUsers(){
        Login loginPage = new Login(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        Home homepage= new Home(DriverManager.getDriver().driver);
        homepage.clickOnAddSauceLabsBackPackToCartButton();
        Assert.assertEquals( "1", homepage.getCartIconText());
        homepage.clickOnMenuButton();
        homepage.clickOnLogout();
        Login loginPage2 = new Login(DriverManager.getDriver().driver);
        loginPage2.setUserNameTextBox("problem_user");
        loginPage2.setPasswordTextBox("secret_sauce");
        Home homepage2= new Home(DriverManager.getDriver().driver);
        Assert.assertEquals( "", homepage.getCartIconText());
    }

    @Test
    public void verifyShopWithoutName(){
        Login loginPage = new Login(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        Home homepage= new Home(DriverManager.getDriver().driver);
        homepage.clickOnAddSauceLabsBackPackToCartButton();
        homepage.clickOnCart();
        homepage.clickOnCheckout();
        homepage.setFirst("");
        homepage.setLast("Lopez");
        homepage.setZip("12345");
        homepage.clickOnContinue();
        Assert.assertEquals("Error: First Name is required",
                homepage.getCheckoutErrorMessage());
    }

    @Test
    public void verifyShopWithoutZip(){
        Login loginPage = new Login(DriverManager.getDriver().driver);
        loginPage.setUserNameTextBox("standard_user");
        loginPage.setPasswordTextBox("secret_sauce");
        loginPage.clickOnLoginButton();
        Home homepage= new Home(DriverManager.getDriver().driver);
        homepage.clickOnAddSauceLabsBackPackToCartButton();
        homepage.clickOnCart();
        homepage.clickOnCheckout();
        homepage.setFirst("Fernando");
        homepage.setLast("Lopez");
        homepage.setZip("");
        homepage.clickOnContinue();
        Assert.assertEquals("Error: Postal Code is required",
                homepage.getCheckoutErrorMessage());
    }
}

package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
    WebDriver driver;

    @FindBy(className = "app_logo")
    WebElement appLogo;

    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement sauceLabsBackPackAddToCartButton;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement sauceLabsBackPackRemoveToCartButton;

    @FindBy(id = "react-burger-menu-btn")
    WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    WebElement logout;

    @FindBy(id = "shoping_cart_container")
    WebElement cart;

    @FindBy(id = "checkout")
    WebElement checkout;

    @FindBy(id = "first-name")
    WebElement first;

    @FindBy(id = "last-name")
    WebElement last;

    @FindBy(id = "postal-code")
    WebElement zip;

    @FindBy(id = "continue")
    WebElement continuar;

    @FindBy(tagName = "h3")
    WebElement chekoutError;

    public Home(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public boolean appLogoIsDisplayed() {
        boolean appLogoIsDisplayed = appLogo.isDisplayed();
        return appLogoIsDisplayed;
    }

    public String getCartIconText(){
        String cartText = cartIcon.getText();
        return cartText;
    }

    public String getCheckoutErrorMessage(){
        String errorMessage = chekoutError.getText();
        return errorMessage;
    }

    public void clickOnAddSauceLabsBackPackToCartButton(){
        sauceLabsBackPackAddToCartButton.click();
    }

    public void clickOnRemoveSauceLabsBackPackToCartButton(){
        sauceLabsBackPackRemoveToCartButton.click();
    }

    public void clickOnMenuButton(){ menuButton.click(); }

    public void clickOnLogout(){ logout.click(); }

    public void clickOnCart(){ cart.click(); }

    public void clickOnCheckout(){ checkout.click(); }

    public void setFirst(String name){
        first.sendKeys(name);
    }

    public void setLast(String lastn){
        last.sendKeys(lastn);
    }

    public void setZip(String zipc){
        zip.sendKeys(zipc);
    }

    public void clickOnContinue(){ continuar.click(); }


}

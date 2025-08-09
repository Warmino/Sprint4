package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private final WebDriver driver;

    private static final String URL = "https://qa-scooter.praktikum-services.ru/";
    private final By cookieBannerLocator = By.id("rcc-confirm-button");
    private final By topOrderButtonLocator = By.cssSelector(".Button_Button__ra12g");
    private final By bottomOrderButtonLocator = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openMainPage() {
        driver.get(URL);
    }

    public void closeCookieBanner() {
        WebElement banner = driver.findElement(cookieBannerLocator);
        banner.click();
    }

    public void clickTopOrderButton() {
        WebElement button = driver.findElement(topOrderButtonLocator);
        button.click();
    }

    public void clickBottomOrderButton() {
        WebElement button = driver.findElement(bottomOrderButtonLocator);
        button.click();
    }
}

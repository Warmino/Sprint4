package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openMainPage() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public void closeCookieBanner() {
        WebElement banner = driver.findElement(By.id("rcc-confirm-button"));
        banner.click();
    }

    public void clickTopOrderButton() {
        WebElement button = driver.findElement(By.cssSelector(".Button_Button__ra12g"));
        button.click();
    }

    public void clickBottomOrderButton() {
        WebElement button = driver.findElement(By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM"));
        button.click();
    }
}
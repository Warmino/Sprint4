package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class OrderFormPage {
    private final WebDriver driver;

    public OrderFormPage(WebDriver driver) {
        this.driver = driver;
    }
    public class FaqPage {
        private final WebDriver driver;

        public FaqPage(WebDriver driver) {
            this.driver = driver;
        }

        public String openAndGetAnswer(int index) {
            WebElement heading = driver.findElement(By.id("accordion__heading-" + index));
            heading.click();
            WebElement panel = driver.findElement(By.id("accordion__panel-" + index));
            return panel.getText().trim();
        }
    }


    public void fillFirstName(String firstName) {
        WebElement field = driver.findElement(By.cssSelector("input[placeholder='* Имя']"));
        field.sendKeys(firstName);
    }

    public void fillLastName(String lastName) {
        WebElement field = driver.findElement(By.cssSelector("input[placeholder='* Фамилия']"));
        field.sendKeys(lastName);
    }

    public void fillAddress(String address) {
        WebElement field = driver.findElement(By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']"));
        field.sendKeys(address);
    }

    public void selectMetroStation(String station) {
        WebElement dropdown = driver.findElement(By.cssSelector(".select-search__input"));
        dropdown.click();
        WebElement option = driver.findElement(By.xpath(".//*[.='" + station + "']"));
        option.click();
    }

    public void fillPhone(String phone) {
        WebElement field = driver.findElement(By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']"));
        field.sendKeys(phone);
    }

    public void proceedToSecondStep() {
        WebElement button = driver.findElement(By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM"));
        button.click();
    }

    public void pickDeliveryDate(String date) {
        WebElement input = driver.findElement(By.cssSelector(".react-datepicker__input-container input"));
        input.clear();
        input.sendKeys(date);
    }

    public void selectRentDuration() {
        WebElement dropdown = driver.findElement(By.cssSelector(".Dropdown-arrow"));
        dropdown.click();
        WebElement option = driver.findElement(By.xpath("//div[text()='сутки']"));
        option.click();
    }

    public void selectBlackColor() {
        WebElement colorOption = driver.findElement(By.id("black"));
        colorOption.click();
    }

    public void selectGreyColor() {
        WebElement colorOption = driver.findElement(By.id("grey"));
        colorOption.click();
    }

    public void addCourierComment(String comment) {
        WebElement field = driver.findElement(By.cssSelector("input[placeholder='Комментарий для курьера']"));
        field.sendKeys(comment);
    }

    public void confirmOrder() {
        WebElement button = driver.findElement(By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM:nth-of-type(2)"));
        button.click();
    }

    public void confirmOrderDialog() {
        WebElement dialogButton = driver.findElement(By.xpath("//button[text()='Да']"));
        dialogButton.click();
    }

    public String verifyOrderSuccessModal() {
        WebElement modalHeader = driver.findElement(By.cssSelector(".Order_ModalHeader__3FDaJ"));
        return modalHeader.findElement(By.cssSelector(".Order_Text__2broi")).getText();
    }




}





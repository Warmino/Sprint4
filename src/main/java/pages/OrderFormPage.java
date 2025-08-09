package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderFormPage {
    private final WebDriver driver;

    private final By firstNameFieldLocator = By.cssSelector("input[placeholder='* Имя']");
    private final By lastNameFieldLocator = By.cssSelector("input[placeholder='* Фамилия']");
    private final By addressFieldLocator = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");
    private final By metroDropdownLocator = By.cssSelector(".select-search__input");
    private final String metroStationLocatorTemplate = ".//*[normalize-space(text())='%s']";
    private final By phoneFieldLocator = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");
    private final By nextStepButtonLocator = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    private final By deliveryDateInputLocator = By.cssSelector(".react-datepicker__input-container input");
    private final By rentDurationDropdownLocator = By.cssSelector(".Dropdown-arrow");
    private final By rentDurationOptionLocator = By.xpath("//div[text()='сутки']");
    private final By blackColorOptionLocator = By.id("black");
    private final By greyColorOptionLocator = By.id("grey");
    private final By courierCommentFieldLocator = By.cssSelector("input[placeholder='Комментарий для курьера']");
    private final By orderConfirmButtonLocator = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM:nth-of-type(2)");
    private final By confirmationDialogButtonLocator = By.xpath("//button[text()='Да']");
    private final By successModalHeaderLocator = By.cssSelector(".Order_ModalHeader__3FDaJ .Order_Text__2broi");
    private final String questionHeadingTemplate = "accordion__heading-%d";
    private final String answerPanelTemplate = "accordion__panel-%d";

    public OrderFormPage(WebDriver driver) {
        this.driver = driver;
    }
    public class FaqPage {
        private final WebDriver driver;

        public FaqPage(WebDriver driver) {
            this.driver = driver;
        }

        public String openAndGetAnswer(int index) {
            By questionHeading = By.id(String.format(questionHeadingTemplate, index));
            By answerPanel = By.id(String.format(answerPanelTemplate, index));

            WebElement heading = driver.findElement(questionHeading);
            heading.click();

            WebElement panel = driver.findElement(answerPanel);
            return panel.getText().trim();
        }
    }

    public void fillFirstName(String firstName) {
        WebElement field = driver.findElement(firstNameFieldLocator);
        field.sendKeys(firstName);
    }

    public void fillLastName(String lastName) {
        WebElement field = driver.findElement(lastNameFieldLocator);
        field.sendKeys(lastName);
    }

    public void fillAddress(String address) {
        WebElement field = driver.findElement(addressFieldLocator);
        field.sendKeys(address);
    }


    public void selectMetroStation(String station) {
        WebElement dropdown = driver.findElement(metroDropdownLocator);
        dropdown.click();

        WebElement option = driver.findElement(By.xpath(String.format(metroStationLocatorTemplate, station)));
        option.click();
    }

    public void fillPhone(String phone) {
        WebElement field = driver.findElement(phoneFieldLocator);
        field.sendKeys(phone);
    }

    public void proceedToSecondStep() {
        WebElement button = driver.findElement(nextStepButtonLocator);
        button.click();
    }

    public void pickDeliveryDate(String date) {
        WebElement input = driver.findElement(deliveryDateInputLocator);
        input.clear();
        input.sendKeys(date);
    }

    public void selectRentDuration() {
        WebElement dropdown = driver.findElement(rentDurationDropdownLocator);
        dropdown.click();
        WebElement option = driver.findElement(rentDurationOptionLocator);
        option.click();
    }

    public void selectBlackColor() {
        WebElement colorOption = driver.findElement(blackColorOptionLocator);
        colorOption.click();
    }

    public void selectGreyColor() {
        WebElement colorOption = driver.findElement(greyColorOptionLocator);
        colorOption.click();
    }

    public void addCourierComment(String comment) {
        WebElement field = driver.findElement(courierCommentFieldLocator);
        field.sendKeys(comment);
    }

    public void confirmOrder() {
        WebElement button = driver.findElement(orderConfirmButtonLocator);
        button.click();
    }

    public void confirmOrderDialog() {
        WebElement dialogButton = driver.findElement(confirmationDialogButtonLocator);
        dialogButton.click();
    }

    public String verifyOrderSuccessModal() {
        WebElement modalHeader = driver.findElement(successModalHeaderLocator);
        return modalHeader.getText();
    }
}






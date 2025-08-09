import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.OrderFormPage;


import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ScooterOrderTests {
    private WebDriver driver;
    private boolean isFromTopButton;
    private String firstName;
    private String lastName;
    private String address;
    private String metroStation;
    private String phone;

    public ScooterOrderTests(boolean isFromTopButton, String firstName, String lastName,
                             String address, String metroStation, String phone) {
        this.isFromTopButton = isFromTopButton;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        MainPage mainPageTest = new MainPage(driver);
        mainPageTest.openMainPage();

    }




    @Parameterized.Parameters(name = "{index}: Top Button={0}, First Name={1}, Last Name={2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {true, "Иван", "Иванов", "Москва", "Черкизовская", "89018769402"},
                {false, "Евгений", "Петров", "Санкт-Петербург", "Сокольники", "89128769422"}
        });
    }

    @Test
    public void testCompleteOrderFlow() {
        MainPage mainPage = new MainPage(driver);
        if (isFromTopButton) {
            mainPage.clickTopOrderButton();
        } else {
            mainPage.closeCookieBanner();
            mainPage.clickBottomOrderButton();
        }

        OrderFormPage formPage = new OrderFormPage(driver);


        formPage.fillFirstName(firstName);
        formPage.fillLastName(lastName);
        formPage.fillAddress(address);
        formPage.selectMetroStation(metroStation);
        formPage.fillPhone(phone);
        formPage.proceedToSecondStep();


        formPage.pickDeliveryDate("2025-12-31");
        formPage.selectRentDuration();
        formPage.selectBlackColor();
        formPage.addCourierComment("---");
        formPage.confirmOrder();


        formPage.confirmOrderDialog();

        String resultMessage = formPage.verifyOrderSuccessModal();
        Assert.assertTrue("Форма не содержит текст с номером заказа",
                resultMessage.contains("Номер заказа:"));
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}

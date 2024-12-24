import model.OrderList;
import model.WebDriverFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import static model.MainPage.HOMEPAGE;

public class SamokatLogoTest {
    private static final String DEFAULT_BROWSER_NAME = "CHROME"; // Установи значение для выбора браузера CHROME или FIREFOX
    private WebDriver driver;

    @Before
    public void start() {
        driver = WebDriverFactory.createForName(DEFAULT_BROWSER_NAME);
        driver.get(HOMEPAGE);
        OrderList orderPage = new OrderList(driver);
        orderPage.clickOrder(true); // переходим на страницу заказа
    }

    @Test
    public void samokatLogoNavTest() {
        OrderList orderPage = new OrderList(driver);
        orderPage.clickSamokatLogo();
        Assert.assertEquals("Это не главная страница Самоката", HOMEPAGE, driver.getCurrentUrl());

    }

    @After
    public void after() {
        driver.quit();
    }
}

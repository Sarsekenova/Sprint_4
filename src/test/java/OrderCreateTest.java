import model.OrderList;
import model.RentPage;
import model.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static model.MainPage.HOMEPAGE;

@RunWith(Parameterized.class)
public class OrderCreateTest {
    private static final String DEFAULT_BROWSER_NAME = "CHROME"; // Установи значение для выбора браузера CHROME или FIREFOX
    private WebDriver driver;
    private final String name;
    private final String secondName;
    private final String address;
    private final String phoneNumber;
    private final String date;
    private final String color;
    private final String comment;
    private final boolean isHead;

    public OrderCreateTest(String name, String secondName, String address, String phoneNumber, String date, String color, String comment, boolean isHead) {
        this.name = name;
        this.secondName = secondName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.color = color;
        this.comment = comment;
        this.isHead = isHead;
    }
    @Parameterized.Parameters
    public static Object[][] faqData() {
        return new Object[][]{
                {"Истомин", "Виталий", "Москва, пр. Мира, 10", "88005553535", "27.12.2024", "черный", "Нет", false},
                {"Булычева", "Катя", "Ухтомского, дом 10", "89998887755", "31.12.2025", "серый", "!@#$%", true},
        };
    }

    @Before
    public void start() {
        driver = WebDriverFactory.createForName(DEFAULT_BROWSER_NAME);
        driver.get(HOMEPAGE);
    }

    @Test
    public void orderCreateTest() {
        OrderList orderPage = new OrderList(driver);
        orderPage.fillOrderPage(name, secondName, address, phoneNumber, isHead);
        RentPage rentPage = new RentPage(driver);
        rentPage.fillRentPage(date, color, comment);
    }

    @After
    public void after() {
        driver.quit();
    }
}
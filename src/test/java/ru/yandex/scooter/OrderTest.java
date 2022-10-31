package ru.yandex.scooter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.HomePage;
import pom.OrderPage;

import java.time.Duration;

@RunWith(Parameterized.class)
public class OrderTest {

    private WebDriver driver;
    private final int numberButtonOrder;
    private final String name;
    private final String surename;
    private final String adress;
    private final String metro;
    private final String numberPhone;
    private final String date;
    private final int period;
    private final String color;
    private final String comment;

    public OrderTest(int numberButtonOrder, String name, String surename, String adress, String metro, String numberPhone, String date, int period, String color, String comment) {
        this.numberButtonOrder = numberButtonOrder;
        this.name = name;
        this.surename = surename;
        this.adress = adress;
        this.metro = metro;
        this.numberPhone = numberPhone;
        this.date = date;
        this.period = period;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getCities() {
        return new Object[][]{
                {0, "Виктор", "Иванов", "Ул.Пушкина, д3", "Жулебино", "89996664455", "26.11", 2, "черный жемчуг", "" },
                {0, "Наталья", "Куракина", "Ул.Молодежная", "лер", "86665552211", "22.11", 3, "серая безысходность", "Оставить у двери" },
                {1, "Виктория", "Сычева", "Ул.Искандера", "Черки", "81119992233", "01.12", 6, "серая безысходность", "В первой половине дня" },
                {1, "Руслан", "Белый", "Москва", "Кузь", "81119231122", "12.12", 7, "черный и серый", "Безнал" },
        };
    }
    @Before
    public void beginning (){
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
    }

    @Test
    public void testСheckout() {
        HomePage homePage = new HomePage(driver);
        OrderPage orderPage = new OrderPage(driver);

        homePage.openMainPage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        homePage.closeCookie();
        homePage.enterOrderButtonTop(numberButtonOrder);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        orderPage.enterName(name);
        orderPage.enterSurename(surename);
        orderPage.enterAdress(adress);
        orderPage.enterMetro(metro);
        orderPage.enterNumberPhone(numberPhone);
        orderPage.clickNext();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        orderPage.enterDateOrder(date);
        orderPage.enterRentalPeriod(period);
        orderPage.enterColorScooter(color);
        orderPage.enterComment(comment);
        orderPage.clickOrderButtonFinal();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        orderPage.clickYes();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        orderPage.checkOrderNumber();
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }
}

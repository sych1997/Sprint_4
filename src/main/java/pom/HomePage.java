package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;


public class HomePage {

    private WebDriver driver;

    // URL главной страницы
    private String url = "https://qa-scooter.praktikum-services.ru/";
    // Кнопка закрытия всплывающего окна
    private By cookie = By.cssSelector(".App_CookieButton__3cvqF");
    // Кнопка заказа вверху страницы
    private By orderButtonTop = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[text()='Заказать']");
    // Кнопка заказа внизу страницы
    private By orderButtonBottom = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");
    // 1. Вопрос "Сколько это стоит? И как оплатить?"
    private By howMuchCostAndHowToPay = By.xpath(".//div[text()='Сколько это стоит? И как оплатить?']");
    // 1. Текст ответа на вопрос "Сколько это стоит? И как оплатить"
    private By textHowMuchCostAndHowToPay = By.xpath(".//div[@id='accordion__panel-0']/p");
    // 2. Вопрос "Хочу сразу несколько самокатов! Так можно?"
    private By wantSomeScooters = By.xpath(".//div[text()='Хочу сразу несколько самокатов! Так можно?']");
    // 2. Текст ответа на вопрос "Хочу сразу несколько самокатов! Так можно?"
    private By textWantSomeScooters = By.xpath(".//div[@id='accordion__panel-1']/p");
    // 3. Вопрос "Как рассчитывается время аренды?"
    private By howCalculatedTimeIsRental = By.xpath(".//div[text()='Как рассчитывается время аренды?']");
    // 3. Текст ответа на вопрос "Как рассчитывается время аренды?"
    private By textHowCalculatedTimeIsRental = By.xpath(".//div[@id='accordion__panel-2']/p");
    // 4. Вопрос "Можно ли заказать самокат прямо на сегодня?"
    private By isPossibleToOrderScooterToday = By.xpath(".//div[text()='Можно ли заказать самокат прямо на сегодня?']");
    // 4. Текст ответа на вопрос "Можно ли заказать самокат прямо на сегодня?"
    private By textIsPossibleToOrderScooterToday = By.xpath(".//div[@id='accordion__panel-3']/p");
    // 5. Вопрос "Можно ли продлить заказ или вернуть самокат раньше?"
    private By isPossibleExtendOrderOrReturnScooterEarlier = By.xpath(".//div[text()='Можно ли продлить заказ или вернуть самокат раньше?']");
    // 5. Текст ответа на вопрос "Можно ли продлить заказ или вернуть самокат раньше?"
    private By textIsPossibleExtendOrderOrReturnScooterEarlie = By.xpath(".//div[@id='accordion__panel-4']/p");
    // 6. Вопрос "Вы привозите зарядку вместе с самокатом?"
    private By youBringChargingFlongWithScooter = By.xpath(".//div[text()='Вы привозите зарядку вместе с самокатом?']");
    // 6. Текст ответа на вопрос "Вы привозите зарядку вместе с самокатом?"
    private By textYouBringChargingFlongWithScooter = By.xpath(".//div[@id='accordion__panel-5']/p");
    // 7. Вопрос "Можно ли отменить заказ?"
    private By isPossibleCancelOrder = By.xpath(".//div[text()='Можно ли отменить заказ?']");
    // 7. Текст ответа на вопрос "Можно ли отменить заказ?"
    private By textIsPossibleCancelOrder = By.xpath(".//div[@id='accordion__panel-6']/p");
    // 8. Вопрос "Я живу за МКАДом, привезёте?"
    private By liveBehindMkadWillYouBringMe = By.xpath(".//div[text()='Я жизу за МКАДом, привезёте?']");
    // 8. Текст ответа на вопрос "Я живу за МКАДом, привезёте?"
    private By textLiveBehindMkadWillYouBringMe = By.xpath(".//div[@id='accordion__panel-7']/p");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Метод открытия главной страницы
    public void openMainPage() {
        driver.get(url);
    }
    // Метод выбора вопроса
    public void clickQuestion(int numberQuestion) {
        if (numberQuestion == 1) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(howMuchCostAndHowToPay));
            driver.findElement(howMuchCostAndHowToPay).click();
        } else if (numberQuestion == 2) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(wantSomeScooters));
            driver.findElement(wantSomeScooters).click();
        } else if (numberQuestion == 3) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(howCalculatedTimeIsRental));
            driver.findElement(howCalculatedTimeIsRental).click();
        } else if (numberQuestion == 4) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(isPossibleToOrderScooterToday));
            driver.findElement(isPossibleToOrderScooterToday).click();
        } else if (numberQuestion == 5) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(isPossibleExtendOrderOrReturnScooterEarlier));
            driver.findElement(isPossibleExtendOrderOrReturnScooterEarlier).click();
        } else if (numberQuestion == 6) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(youBringChargingFlongWithScooter));
            driver.findElement(youBringChargingFlongWithScooter).click();
        } else if (numberQuestion == 7) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(isPossibleCancelOrder));
            driver.findElement(isPossibleCancelOrder).click();
        } else if (numberQuestion == 8) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(liveBehindMkadWillYouBringMe));
            driver.findElement(liveBehindMkadWillYouBringMe).click();
        }
    }
    // Метод проверки текста ответа на вопрос
    public void checkingAnswerQuestion(int numberQuestion, String answer) {
        if (numberQuestion == 1) {
            String getText = driver.findElement(textHowMuchCostAndHowToPay).getText();
            assertEquals(answer, getText);
        } else if (numberQuestion == 2) {
            String getText = driver.findElement(textWantSomeScooters).getText();
            assertEquals(answer, getText);
        } else if (numberQuestion == 3) {
            String getText = driver.findElement(textHowCalculatedTimeIsRental).getText();
            assertEquals(answer, getText);
        } else if (numberQuestion == 4) {
            String getText = driver.findElement(textIsPossibleToOrderScooterToday).getText();
            assertEquals(answer, getText);
        } else if (numberQuestion == 5) {
            String getText = driver.findElement(textIsPossibleExtendOrderOrReturnScooterEarlie).getText();
            assertEquals(answer, getText);
        } else if (numberQuestion == 6) {
            String getText = driver.findElement(textYouBringChargingFlongWithScooter).getText();
            assertEquals(answer, getText);
        } else if (numberQuestion == 7) {
            String getText = driver.findElement(textIsPossibleCancelOrder).getText();
            assertEquals(answer, getText);
        } else if (numberQuestion == 8) {
            String getText = driver.findElement(textLiveBehindMkadWillYouBringMe).getText();
            assertEquals(answer, getText);
        }
    }
    // Метод выбора через какую кнопку заказа начать оформление
    public void enterOrderButtonTop(int number) {
        if (number == 0) {
            driver.findElement(orderButtonTop).click();
        } else if (number == 1) {
            driver.findElement(orderButtonBottom).click();
        }
    }
    // Метод закрытия всплывающего окна
    public void closeCookie() {
        driver.findElement(cookie).click();
    }
}

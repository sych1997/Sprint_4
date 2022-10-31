package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.containsString;

public class OrderPage {

    private WebDriver driver;

    // Строка для ввода имени
    private By name = By.xpath(".//input[@placeholder='* Имя']");
    // Строка для ввода фамилии
    private By surname = By.xpath(".//input[@placeholder='* Фамилия']");
    // Строка адреса доставки
    private By address = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // Список станций метро
    private By metro = By.xpath(".//input[@placeholder='* Станция метро']");
    // Строка ввода номера телефона
    private By numberPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка далее
    private By next = By.xpath(".//button[text()='Далее']");
    // Дата привоза самоката
    private By dateOrder = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // Срок аренды
    private By rentalPeriod = By.xpath(".//div[@class='Dropdown-root']");
    // Срок аренды 1 день
    private By day = By.xpath(".//div[@class='Dropdown-menu']/div[text()='сутки']");
    // Срок аренды 2 дня
    private By twoDay = By.xpath(".//div[@class='Dropdown-menu']/div[text()='двое суток']");
    // Срок аренды 3 дня
    private By threeDay = By.xpath(".//div[@class='Dropdown-menu']/div[text()='трое суток']");
    // Срок аренды 4 дня
    private By fourDay = By.xpath(".//div[@class='Dropdown-menu']/div[text()='четверо суток']");
    // Срок аренды 5 дней
    private By fiveDay = By.xpath(".//div[@class='Dropdown-menu']/div[text()='пятеро суток']");
    // Срок аренды 6 дней
    private By sixDay = By.xpath(".//div[@class='Dropdown-menu']/div[text()='шестеро суток']");
    // Срок аренды 7 дней
    private By sevenDay = By.xpath(".//div[@class='Dropdown-menu']/div[text()='семеро суток']");
    // Чек бокс цвет самоката чёрный жемчуг
    private By colorScooterBlack = By.xpath(".//input[@id='black']");
    // Чек бокс цвет самоката серая безысходность
    private By colorScooterGrey = By.xpath(".//input[@id='grey']");
    // Комментарий для курьера
    private By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // Кнопка сделать заказ
    private By orderButtonFinal = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    // Кнопка подтверждения заказа
    private By yes = By.xpath(".//button[text()='Да']");
    // Окно с номером заказ
    private By orderNumber = By.xpath(".//div[text()='Заказ оформлен']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод ввода имени
    public void enterName(String inputName) {
        driver.findElement(name).click();
        driver.findElement(name).sendKeys(inputName);
    }
    // Метод ввода фамилии
    public void enterSurename(String inputSurename) {
        driver.findElement(surname).click();
        driver.findElement(surname).sendKeys(inputSurename);
    }
    // Метод ввода адреса
    public void enterAdress(String inputAdress) {
        driver.findElement(address).click();
        driver.findElement(address).sendKeys(inputAdress);
    }
    // Метод ввода метро
    public void enterMetro(String inputMetro) {
        driver.findElement(metro).click();
        driver.findElement(metro).sendKeys(inputMetro);
        driver.findElement(metro).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }
    // Метод ввода адреса
    public void enterNumberPhone(String inputNumberPhone) {
        driver.findElement(numberPhone).click();
        driver.findElement(numberPhone).sendKeys(inputNumberPhone);
    }
    // Метод нажатия на кнопку далее
    public void clickNext() {
        driver.findElement(next).click();
    }
    // Метод ввода даты заказа
    public void enterDateOrder(String inputDateOrder) {
        driver.findElement(dateOrder).click();
        driver.findElement(dateOrder).sendKeys(inputDateOrder);
        driver.findElement(dateOrder).sendKeys(Keys.ENTER);
    }
    // Метод ввода срока аренды
    public void enterRentalPeriod(int period) {
        driver.findElement(rentalPeriod).click();
        if (period == 1) {
            driver.findElement(day).click();
        } else if (period == 2) {
            driver.findElement(twoDay).click();
        } else if (period == 3) {
            driver.findElement(threeDay).click();
        } else if (period == 4) {
            driver.findElement(fourDay).click();
        } else if (period == 5) {
            driver.findElement(fiveDay).click();
        } else if (period == 6) {
            driver.findElement(sixDay).click();
        } else if (period == 7) {
            driver.findElement(sevenDay).click();
        }
    }
    // Метод выбора цвета самоката
    public void enterColorScooter(String color) {
        if ("черный жемчуг".equals(color)) {
            driver.findElement(colorScooterBlack).click();
        } else if ("серая безысходность".equals(color)) {
            driver.findElement(colorScooterGrey).click();
        } else if ("черный и серый".equals(color)) {
            driver.findElement(colorScooterBlack).click();
            driver.findElement(colorScooterGrey).click();
        }
    }
    public void enterComment(String text) {
        driver.findElement(comment).click();
        driver.findElement(comment).sendKeys(text);
    }
    public void clickOrderButtonFinal() {
        driver.findElement(orderButtonFinal).click();
    }
    public void clickYes() {
        driver.findElement(yes).click();
    }
    public void checkOrderNumber() {
        String actual = driver.findElement(orderNumber).getText();
        Assert.assertThat(actual, containsString("Заказ оформлен"));
    }
}

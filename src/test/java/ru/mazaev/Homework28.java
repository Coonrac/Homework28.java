package ru.mazaev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Homework28 {
    private WebDriver webDriver;

    @Before
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
    }

    @Test
    public void firsttask(){
        webDriver.get("https://savkk.github.io/selenium-practice/");

        WebElement Iframe = webDriver.findElement(By.xpath("//*[@id=\"iframe\"]"));
        Iframe.click(); //Переходим в Fifth task

        WebDriver Code = webDriver.switchTo().frame("code-frame"); //Поиск по Iframe

        WebElement Codes = webDriver.findElement(By.xpath("//*[@id=\"code\"]"));
        String CodeText = Codes.getText().substring(15, 25);

        webDriver.switchTo().defaultContent(); //Выход из поиска Iframe

        WebElement InputCode = webDriver.findElement(By.xpath("/html/body/div/div/div/input[1]"));
        InputCode.sendKeys(CodeText); //Вставляем код

        WebElement Iframes = webDriver.findElement(By.cssSelector("#content > input:nth-child(5)"));
        Iframes.click(); //Нажимаем на кноку Verify

        WebElement Quit = webDriver.findElement(By.tagName("a"));
        Quit.click();
    }


    @Test
    public void sixthtask() throws InterruptedException {
        webDriver.get("https://savkk.github.io/selenium-practice/");

        WebElement Alerts = webDriver.findElement(By.xpath("//*[@id=\"alerts\"]"));
        Alerts.click();
        WebElement GetPassword = webDriver.findElement(By.xpath("//*[@id=\"content\"]/button[1]"));
        GetPassword.click(); // Запрос пароля
        Alert alert = webDriver.switchTo().alert();
        String alertText = alert.getText().substring(15, 25);
        alert.accept();

        WebElement EnterPassword = webDriver.findElement(By.xpath("//*[@id=\"content\"]/button[2]"));
        EnterPassword.click(); // Нажатие кнопки Enter Password для ввода пароля

        Alert al = webDriver.switchTo().alert();
        al.sendKeys(alertText);
        Alert ale = webDriver.switchTo().alert();
        ale.accept();


        WebElement Text1 = webDriver.findElement(By.xpath("//*[contains(text(), 'Great!')]"));
        WebElement Quit = webDriver.findElement(By.tagName("a"));
        Quit.click();
    }

    @Test
    public void seventhtask(){
        webDriver.get("https://savkk.github.io/selenium-practice/");

        WebElement Alerts = webDriver.findElement(By.xpath("//*[@id=\"table\"]"));
        Alerts.click();

        WebElement Check3 = webDriver.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr[3]/td[1]/input"));
        Check3.click();
        WebElement Check2 = webDriver.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr[2]/td[1]/input"));
        Check2.click();
        WebElement Check4 = webDriver.findElement(By.xpath("//*[@id=\"customers\"]/tbody/tr[4]/td[1]/input"));
        Check4.click();

        WebElement Text = webDriver.findElement(By.xpath("//*[@id=\"content\"]/input"));
        Text.click();

        WebElement Company = webDriver.findElement(By.xpath("//*[@id=\"content\"]/div/form/div[1]/input"));
        Company.sendKeys("VTB");
        WebElement Contact = webDriver.findElement(By.xpath("//*[@id=\"content\"]/div/form/div[2]/input"));
        Contact.sendKeys(" Elena Petrova");
        WebElement Country = webDriver.findElement(By.xpath("//*[@id=\"content\"]/div/form/div[3]/input"));
        Country.sendKeys("Russian Federation");

        WebElement Add = webDriver.findElement(By.xpath("//*[@id=\"content\"]/div/form/input"));
        Add.click();

        WebElement Quit = webDriver.findElement(By.tagName("a"));
        Quit.click();


    }

    /*@After
    public void closeDriver(){
        if (webDriver != null) {
            webDriver.quit();
        }
    }*/
}

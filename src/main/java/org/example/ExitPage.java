package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ExitPage {
    private final WebDriver driver;

    public ExitPage(WebDriver driver) {

        this.driver = driver;
    }
    private By personalAccountButton = By.xpath(".//p[text() = \"Личный Кабинет\"]");
    private By emailInput = By.xpath("//label[.='Email']/../input");
    private By passwordInput = By.name("Пароль");
    private By loginButton = By.xpath(".//button[text() = \"Войти\"]");
    private By exitButton = By.xpath(".//button[text() = \"Выход\"]");
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click(); //кликаем на кнопку "Личный кабинет"
    }
    public void typeEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }
    public void typePassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }
    public void clickLoginButton() {
        driver.findElement(loginButton).click(); //кликаем на Войти
    }
    public void clickExitButton() {
        new WebDriverWait(driver, 7)
                .until(ExpectedConditions.elementToBeClickable(exitButton));
        driver.findElement(exitButton).click(); //кликаем на Выйти
    }
    public boolean accessButtonIsVisible(){
        try {
            new WebDriverWait(driver, 7)
                    .until(ExpectedConditions.numberOfElementsToBeMoreThan(loginButton, 0));
            return true;
        } catch (TimeoutException exception){
            return false;
        }

    }
}

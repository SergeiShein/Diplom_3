package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }
    private By loginButton = By.xpath(".//button[text() = \"Войти в аккаунт\"]");
    private By emailInput = By.xpath("//label[.='Email']/../input");
    private By passwordInput = By.name("Пароль");
    private By accessLoginButton = By.xpath(".//button[text() = \"Войти\"]");
    private By orderButton = By.xpath(".//button[text() = \"Оформить заказ\"]");
    private By personalAccountButton = By.xpath(".//p[text() = \"Личный Кабинет\"]");
    private By registrationLink = By.xpath(".//a[text() = \"Зарегистрироваться\"]");
    private By loginLink = By.xpath(".//a[text() = \"Войти\"]");
    private By recoverPassordLink = By.xpath(".//a[text() = \"Восстановить пароль\"]");

    public void clickLoginButton() {
        driver.findElement(loginButton).click(); //кликаем на кнопку "Войти в аккаунт"
    }
    public void typeEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }
    public void typePassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }
    public void clickAccessLoginButton() {
        driver.findElement(accessLoginButton).click(); //кликаем на Войти
    }
    public boolean orderButtonIsVisible() {
        try {
            new WebDriverWait(driver, 7)
                    .until(ExpectedConditions.numberOfElementsToBeMoreThan(orderButton, 0));
            return true;
        } catch (TimeoutException exception) {
            return false;
        }
    }
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccountButton).click(); //кликаем на кнопку "Личный кабинет"
    }
    public void clickRegistrationLink() {
        driver.findElement(registrationLink).click(); //кликаем на ссылку Зарегистрироваться
    }
    public void clickLoginLink() {
        driver.findElement(loginLink).click(); //кликаем на ссылку Войти
    }
    public void clickRecoveryPassword() {
        driver.findElement(recoverPassordLink).click(); //кликаем на ссылку Восстановить пароль
    }

}

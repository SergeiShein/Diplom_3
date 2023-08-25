package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransitionToConstructorPage {
    private final WebDriver driver;

    public TransitionToConstructorPage (WebDriver driver) {

        this.driver = driver;
    }
    private By personalAccountButton = By.xpath(".//p[text() = \"Личный Кабинет\"]");
    private By emailInput = By.xpath("//label[.='Email']/../input");
    private By passwordInput = By.name("Пароль");
    private By loginButton = By.xpath(".//button[text() = \"Войти\"]");
    private By exitButton = By.xpath(".//button[text() = \"Выход\"]");
    private By constructorButton = By.xpath(".//p[text() = \"Конструктор\"]");
    private By titleAssembleTheBurger = By.xpath(".//h1[text() = \"Соберите бургер\"]");
    private By titleStellarBurgers = By.className("AppHeader_header__logo__2D0X2");
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
    public boolean accessButtonExitIsVisible(){
        try {
            new WebDriverWait(driver, 7)
                    .until(ExpectedConditions.numberOfElementsToBeMoreThan(exitButton, 0));
            return true;
        } catch (TimeoutException exception){
            return false;
        }

    }
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click(); //кликаем на Конструктор
    }
    public boolean accessTitleAssembleTheBurgerIsVisible(){
        try {
            new WebDriverWait(driver, 7)
                    .until(ExpectedConditions.numberOfElementsToBeMoreThan(titleAssembleTheBurger, 0));
            return true;
        } catch (TimeoutException exception){
            return false;
        }
    }
    public void clickLogoStellarBurgers() {
        driver.findElement(titleStellarBurgers).click(); //кликаем на логотип
    }
}

package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccountPage {
    private final WebDriver driver;

    public PersonalAccountPage(WebDriver driver) {

        this.driver = driver;
    }
    private By personalAccountButton = By.xpath(".//p[text() = \"Личный Кабинет\"]");
    private By emailInput = By.xpath("//label[.='Email']/../input");
    private By passwordInput = By.name("Пароль");
    private By loginButton = By.xpath(".//button[text() = \"Войти\"]");
    private By profileInformation = By.xpath(".//a[text() = \"Профиль\"]");


    public void clickPersonalAccountButton() {
        new WebDriverWait(driver, 7)
                .until(ExpectedConditions.elementToBeClickable(personalAccountButton));
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
    public boolean profileIsVisible() {
        try {
            new WebDriverWait(driver, 7)
                    .until(ExpectedConditions.numberOfElementsToBeMoreThan(profileInformation, 0));
            return true;
        } catch (TimeoutException exception) {
            return false; //Проверяем, что на странице есть элемент Профиль
        }
    }
}

package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RegisterPage {
    private WebDriver driver;

    public RegisterPage(WebDriver driver) {

        this.driver = driver;
    }
    private By nameInput = By.xpath("//label[.='Имя']/../input");
    private By emailInput = By.xpath("//label[.='Email']/../input");
    private By passwordInput = By.name("Пароль");
    private By registrationButton = By.xpath(".//button[text() = \"Зарегистрироваться\"]");
    private By accessButton = By.xpath(".//button[text() = \"Войти\"]");
    private By invalideRegistrationLable = By.xpath(".//p[text() = \"Некорректный пароль\"]");
    private By registrationLink = By.xpath(".//a[text() = \"Зарегистрироваться\"]");

    public void typeName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }
    public void typeEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }
    public void typePassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }
    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click(); //кликаем на элемент Зарегистрироваться
    }
    public boolean accessButtonIsVisible(){
        try {
            new WebDriverWait(driver, 7)
                    .until(ExpectedConditions.numberOfElementsToBeMoreThan(accessButton, 0));
            return true;
        } catch (TimeoutException exception){
            return false;
        }

    }
    public boolean invalideRegistrationIsVisible(){
        try {
            new WebDriverWait(driver, 7)
                    .until(ExpectedConditions.numberOfElementsToBeMoreThan(invalideRegistrationLable, 0));
            return true;
        } catch (TimeoutException exception){
            return false;
        }
    }
    public void clickRegistrationLink() {
        driver.findElement(registrationLink).click(); //кликаем на ссылку Зарегистрироваться
    }
}

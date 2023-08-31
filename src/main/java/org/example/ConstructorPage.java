package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConstructorPage {
    private final WebDriver driver;

    public ConstructorPage (WebDriver driver) {

        this.driver = driver;
    }
    private By personalAccountButton = By.xpath(".//p[text() = \"Личный Кабинет\"]");
    private By emailInput = By.xpath("//label[.='Email']/../input");
    private By passwordInput = By.name("Пароль");
    private By loginButton = By.xpath(".//button[text() = \"Войти\"]");
    private By sousButton = By.xpath("//span[text() = \"Соусы\"]");
    private By fillingsButton = By.xpath("//span[text() = \"Начинки\"]");
    private By rollsButton = By.xpath("//span[text() = \"Булки\"]");

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
    public void clickSousButton() {
        new WebDriverWait(driver, 7)
                .until(ExpectedConditions.elementToBeClickable(sousButton));
        driver.findElement(sousButton).click(); //кликаем на Cоусы
    }
    public double getScrollPosition(){
        JavascriptExecutor jsExecutor = (JavascriptExecutor)driver;
        Object scrollPosition = (Object)jsExecutor.executeScript("return document.getElementsByClassName(\"BurgerIngredients_ingredients__menuContainer__Xu3Mo\")[0].scrollTop;");
        if (scrollPosition instanceof Double) {
            return(Double) scrollPosition;
        } else{
            return Double.valueOf((Long)scrollPosition);
        }
    }
    public void clickFillingsButton() {
        new WebDriverWait(driver, 7)
                .until(ExpectedConditions.elementToBeClickable(fillingsButton));
        driver.findElement(fillingsButton).click(); //кликаем на Начинки
    }
    public void clickRollsButton() {
        new WebDriverWait(driver, 7)
                .until(ExpectedConditions.elementToBeClickable(rollsButton));
        driver.findElement(rollsButton).click(); //кликаем на Начинки
    }

}

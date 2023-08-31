package constants;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverConstants {
    public static String REGISTER_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";
    public static String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    public static WebDriver getWebDriver(String browserName){
        ChromeOptions options = new ChromeOptions();
        switch (browserName) {
            case "chrome" :
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "yandex" :
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(options.setBinary("C:\\Users\\serge\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe"));
            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            default:
                throw new RuntimeException("Неподдерживаемый браузер");
        }
    }
}

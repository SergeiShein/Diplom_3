import constants.DriverConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class LoginTest {
    private WebDriver driver;
    private String token;
    @Before
    public void init() {
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        WebDriverManager.chromedriver().setup();
        driver = DriverConstants.getWebDriver("yandex");
        driver.get(DriverConstants.MAIN_PAGE_URL);
        File json = new File("src/test/resources/valideUser.json");
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .and()
                        .body(json)
                        .when()
                        .post("/api/auth/register");
        token = response.path("accessToken");
        String [] tokenData = token.split(" ");
        token = tokenData[1];
    }
    @Test
    public void testAccessButtonLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginButton();
        loginPage.typeEmail("andreysmirnov9@gmail.com");
        loginPage.typePassword("9qwsfdgry37");
        loginPage.clickAccessLoginButton();
        assertTrue(loginPage.orderButtonIsVisible());
    }
    @Test
    public void testLoginViaPersonalAccount(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickPersonalAccountButton();
        loginPage.typeEmail("andreysmirnov9@gmail.com");
        loginPage.typePassword("9qwsfdgry37");
        loginPage.clickAccessLoginButton();
        assertTrue(loginPage.orderButtonIsVisible());
    }
    @Test
    public void testLoginViaRegistration(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickPersonalAccountButton();
        loginPage.clickRegistrationLink();
        loginPage.clickLoginLink();
        loginPage.typeEmail("andreysmirnov9@gmail.com");
        loginPage.typePassword("9qwsfdgry37");
        loginPage.clickAccessLoginButton();
        assertTrue(loginPage.orderButtonIsVisible());
    }
    @Test
    public void testLoginViaPasswordRecovery(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickPersonalAccountButton();
        loginPage.clickRecoveryPassword();
        loginPage.clickLoginLink();
        loginPage.typeEmail("andreysmirnov9@gmail.com");
        loginPage.typePassword("9qwsfdgry37");
        loginPage.clickAccessLoginButton();
        assertTrue(loginPage.orderButtonIsVisible());
    }
    @After
    public void tearDown() {
        // Закрыть браузер
        driver.quit();
        given().auth().oauth2(token).delete("/api/auth/user");
    }
}

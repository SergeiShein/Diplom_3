import constants.DriverConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.RegisterPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;


public class RegisterTest {
    private static WebDriver driver;
    @BeforeClass
    public static void init() {
        WebDriverManager.chromedriver().setup();
        driver = DriverConstants.getWebDriver("yandex");
        driver.get(DriverConstants.REGISTER_PAGE_URL);
    }
    @Test
    public void testValideRegistration() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.typeName("Андрей");
        registerPage.typeEmail("andreysmirnov9@gmail.com");
        registerPage.typePassword("9qwsfdgry37");
        registerPage.clickRegistrationButton();
        assertTrue(registerPage.accessButtonIsVisible());
    }
    @Test
    public void testInvalideRegistration() {
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.clickRegistrationLink();
        registerPage.typeName("Андрей");
        registerPage.typeEmail("andreyalexsmirnov@gmail.com");
        registerPage.typePassword("9qwsf");
        registerPage.clickRegistrationButton();
        assertTrue(registerPage.invalideRegistrationIsVisible());
    }
    @AfterClass
    public static void tearDown() {
        // Закрыть браузер
        driver.quit();
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site";
        File json = new File("src/test/resources/valideUser.json");
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .and()
                        .body(json)
                        .when()
                        .post("/api/auth/login");
        String token = response.path("accessToken");
        String [] tokenData = token.split(" ");
        token = tokenData[1];
        given().auth().oauth2(token).delete("/api/auth/user");
    }
}

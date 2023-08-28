import constants.DriverConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.PersonalAccountPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class PersonalAccountTest {
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
    public void testPersonalAccount(){
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickPersonalAccountButton();
        personalAccountPage.typeEmail("andreysmirnov9@gmail.com");
        personalAccountPage.typePassword("9qwsfdgry37");
        personalAccountPage.clickLoginButton();
        personalAccountPage.clickPersonalAccountButton();
        assertTrue(personalAccountPage.profileIsVisible());
    }
    @After
    public void tearDown() {
        // Закрыть браузер
        driver.quit();
        given().auth().oauth2(token).delete("/api/auth/user");
    }
}

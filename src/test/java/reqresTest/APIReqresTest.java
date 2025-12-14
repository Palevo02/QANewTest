package reqresTest;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import reqresTest.POJO.RegAccount;
import reqresTest.POJO.ResponseError;
import reqresTest.POJO.SuccessLogin;
import reqresTest.POJO.SuccessReg;

import static io.restassured.RestAssured.given;


@Feature("Reqres")
@Story("API Тесты")
public class APIReqresTest {

    private final static String URL = "https://reqres.in/";
    private final static String APIKEY_NAME = "x-api-key";
    private final static String APIKEY_VALUE = "reqres_f003b26b01164d3fa07bc61b4a4b5785";

    public static final class EndPoints {
        public static final String REGISTER = "api/register";
        public static final String LOGIN = "api/login";
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка обычной регистрации")
    public void testSuccessRegistration() {
        Specifications.installSpecification(Specifications.requestSpec(URL, APIKEY_NAME, APIKEY_VALUE),
                Specifications.responseSpecOK200());
        RegAccount regAccount = new RegAccount("username123465","eve.holt@reqres.in", "pistol");
        given()
                .body(regAccount)
                .when()
                .post(EndPoints.REGISTER)
                .then().log().all()
                .extract().as(SuccessReg.class);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка регистрации с отсутствующими полями")
    public void unsuccessRegistrationTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL, APIKEY_NAME, APIKEY_VALUE),
                Specifications.responseSpecError400());
        RegAccount regAccount = new RegAccount("eve.holt@reqres.in");
        given()
                .body(regAccount)
                .when()
                .post(EndPoints.REGISTER)
                .then().log().all()
                .extract().as(ResponseError.class);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка обычной авторизации")
    public void successLoginTest(){
        Specifications.installSpecification(Specifications.requestSpec(URL,APIKEY_NAME,APIKEY_VALUE),
                Specifications.responseSpecOK200());
        RegAccount requestAccount = new RegAccount("123","eve.holt@reqres.in","pistol");
        given()
                .body(requestAccount)
                .when()
                .post(EndPoints.LOGIN)
                .then().log().all()
                .extract().as(SuccessLogin.class);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка авторизации с отсутствующим полем пароля")
    public void unsuccessLoginTest(){
        Specifications.installSpecification(Specifications.requestSpec(URL,APIKEY_NAME,APIKEY_VALUE),
                Specifications.responseSpecError400());
        RegAccount requestAccount = new RegAccount("eve.holt@reqres.in");
        given()
                .body(requestAccount)
                .when()
                .post(EndPoints.LOGIN)
                .then().log().all()
                .extract().as(ResponseError.class);
    }
}

package ReqresTest.APITest;

import ReqresTest.POJO.ResponseError;
import ReqresTest.POJO.RequestAccount;
import ReqresTest.POJO.SuccessLogin;
import ReqresTest.POJO.SuccessReg;
import ReqresTest.Specifications;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
@Feature("Reqres")
@Story("API Тесты")
public class ReqresTest {

    private final static String URL = "https://reqres.in/";
    private final static String APIKEY_NAME = "x-api-key";
    private final static String APIKEY_VALUE = "reqres-free-v1";

    public static final class EndPoints {
        public static final String REGISTER = "api/register";
        public static final String LOGIN = "api/login";
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка обычной регистрации")
    public void successRegistrationTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL, APIKEY_NAME, APIKEY_VALUE),
                Specifications.responseSpecOK200());
        RequestAccount requestAccount = new RequestAccount("eve.holt@reqres.in", "pistol");
        given()
                .body(requestAccount)
                .when()
                .post(EndPoints.REGISTER)
                .then().log().all()
                .extract().as(SuccessReg.class);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка регистрации с отсутствующим полем пароля")
    public void unsuccessRegistrationTest() {
        Specifications.installSpecification(Specifications.requestSpec(URL, APIKEY_NAME, APIKEY_VALUE),
                Specifications.responseSpecError400());
        RequestAccount requestAccount = new RequestAccount("eve.holt@reqres.in");
        given()
                .body(requestAccount)
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
        RequestAccount requestAccount = new RequestAccount("eve.holt@reqres.in","pistol");
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
        RequestAccount requestAccount = new RequestAccount("eve.holt@reqres.in");
        given()
                .body(requestAccount)
                .when()
                .post(EndPoints.LOGIN)
                .then().log().all()
                .extract().as(ResponseError.class);
    }
}

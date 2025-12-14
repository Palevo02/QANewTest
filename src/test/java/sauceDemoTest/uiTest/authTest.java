package sauceDemoTest.uiTest;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import sauceDemoTest.data.User;
import sauceDemoTest.data.Users;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static sauceDemoTest.page.LoginPage.openPage;

@Feature("Saucedemo")
@Story("Авторизация")
public class authTest extends BaseTest {

    private static final String URL = "https://www.saucedemo.com/";
    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void testAuthWithNormalAccount(){
        openPage().successAuth(Users.commonUser);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void testAuthWithWrongPassword(){
        openPage().wrongAuth(Users.commonUser);
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void testAuthWithBlockAccount(){
        openPage().wrongAuth(Users.lockedOutUser);
    }


}

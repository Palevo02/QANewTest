package sauceDemoTest.uiTest;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
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
public class authTest {

    private static final String URL = "https://www.saucedemo.com/";
    @Test
    public void testAuthWithNormalAccount(){
        openPage().successAuth(Users.commonUser);
    }

    @Test
    public void testAuthWithWrongPassword(){
        openPage().successAuth(Users.commonUser);
    }

    @Test
    public void testAuthWithBlockAccount(){
        openPage().wrongAuth(Users.commonUser);
    }


}

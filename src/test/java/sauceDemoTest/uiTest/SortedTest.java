package sauceDemoTest.uiTest;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sauceDemoTest.data.Users;
import sauceDemoTest.page.LoginPage;
import sauceDemoTest.page.MainPage;

import static com.codeborne.selenide.Selenide.$;
import static sauceDemoTest.page.LoginPage.openPage;

@Feature("Saucedemo")
@Story("Сортировка")
public class SortedTest extends BaseTest {

    @BeforeEach
    public void setUp() {
        openPage().successAuth(Users.commonUser);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void sortedTestAToZ() {
        new MainPage().checkItemsAToZ();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void sortedTestZToA() {
        $(".product_sort_container").selectOptionByValue("za");
        new MainPage().checkItemsZToA();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void sortedTestLowToHigh(){
        $(".product_sort_container").selectOptionByValue("lohi");
        new MainPage().checkItemsLowToHigh();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void sortedTestHighToLow(){
        $(".product_sort_container").selectOptionByValue("hilo");
        new MainPage().checkItemsHighToLow();
    }



}

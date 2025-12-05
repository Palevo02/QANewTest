package screenTest;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class GoogleTest {
    @Test
    @Attachment(value = "{name}", type = "text/plain")
    public void user_can_search_everything_in_google() {
        String name = "";
        try {
            open("http://google.com/ncr");
            $(By.name("q")).val("selenide").pressEnter();

            $("#rso").shouldBe(visible).shouldHave(
                    text("Selenide - это фреймворк для автоматизированного тестирования веб-приложений"));
            name = "Всё отработало хорошо";
        }catch (Exception e){
            name = "Что-то пошло не так с поиском";
        }
    }
    @Test
    public void userCanCheckPrivacyPolicy(){
        open("http://google.com/ncr");
        $(".iTjxkf").click();
    }
}

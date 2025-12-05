package sauceDemoTest.page;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import sauceDemoTest.data.User;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    public final static String URL_LOGIN_PAGE = "https://www.saucedemo.com/";

    @Step("Открыть страницу авторизации")
    public static LoginPage openPage(){
        open(URL_LOGIN_PAGE);
        return new LoginPage();
    }

    @Step("Успешная авторизация")
    public MainPage successAuth(User user){
        open(URL_LOGIN_PAGE);
        $("#user-name").val(user.getUsername());
        $("#password").val(user.getPassword());
        $("#login-button").click();
        return new MainPage();
    }

    @Step("Проваленная авторизация - неправильные логин/пароль")
    public void wrongAuth(User user){
        open(URL_LOGIN_PAGE);
        $("#user-name").val(user.getUsername());
        $("#password").val("WrongPassword");
        $("#login-button").click();
        $(".error-message-container")
                .shouldBe(Condition.visible)
                .shouldHave(text("Epic sadface: Username and password do not match any user in this service"));
    }

    @Step("Проваленная авторизация - заблокированный аккаунт")
    public void blockAuth(User user){
        open(URL_LOGIN_PAGE);
        $("#user-name").val(user.getUsername());
        $("#password").val(user.getPassword());
        $("#login-button").click();
        $(".error-message-container")
                .shouldBe(Condition.visible)
                .shouldHave(text("Epic sadface: Sorry, this user has been locked out."));
    }
}

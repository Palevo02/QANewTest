package utils;

import io.qameta.allure.Attachment;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.OutputType;

import java.nio.charset.StandardCharsets;

public class AllureUtil {
    @Attachment(value = "{attachName}", type = "image/png")
    public static byte[] screenshotAs(String attachName) {
        return Selenide.screenshot(OutputType.BYTES);
    }

    @Attachment(value = "Page source", type = "text/plain")
    public static byte[] pageSource() {
        return WebDriverRunner.source()
                .getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(value = "{attachName}", type = "text/plain")
    public static String attachAsText(String attachName, String message) {
        return message;
    }

    @Attachment(value = "{fileName}", type = "text/html")
    public static byte[] attachHtml(String fileName) {
        return WebDriverRunner.source()
                .getBytes(StandardCharsets.UTF_8);
    }
}

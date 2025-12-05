package sauceDemoTest.page;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import sauceDemoTest.data.Item;
import sauceDemoTest.data.Items;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    public static final String URL_MAIN_PAGE = "https://www.saucedemo.com/inventory.html";

    @Step("Проверка сортировки A-Z")
    public void checkItemsAToZ() {
        List<String> expectedItems = $$(".inventory_item_name ").texts();
        expectedItems.forEach(System.out::println);
        List<String> actualItems = Items.getAllItems().stream()
                .map(Item::getItemName)
                .sorted()
                .collect(Collectors.toList());
        Assertions.assertEquals(expectedItems, actualItems);
    }
    @Step("Проверка сортировки Z-A")
    public void checkItemsZToA() {
        List<String> expectedItems = $$(".inventory_item_name").texts();
        List<String> actualItems = Items.getAllItems().stream()
                .map(Item::getItemName)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        Assertions.assertEquals(expectedItems, actualItems);
    }
    @Step("Проверка сортировки от Дешевого к Дорогому")
    public void checkItemsLowToHigh() {
        List<String> expectedItems = $$(".inventory_item_price").texts();
        List<String> actualItems = Items.getAllItems().stream()
                .map(Item::getItemPrice)
                .map(BigDecimal::new)
                .sorted()
                .map(price -> "$" + price)
                .collect(Collectors.toList());
        Assertions.assertEquals(expectedItems, actualItems);
    }
    @Step("Проверка сортировки от Дешевого к Дорогому")
    public void checkItemsHighToLow() {
        List<String> expectedItems = $$(".inventory_item_price").texts();
        List<String> actualItems = Items.getAllItems().stream()
                .map(Item::getItemPrice)
                .map(BigDecimal::new)
                .sorted(Comparator.reverseOrder())
                .map(price -> "$" + price)
                .collect(Collectors.toList());
        Assertions.assertEquals(expectedItems, actualItems);
    }


}

package github;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class SelenideRepositoriesSearchTest {


    @BeforeAll
    static void beforeAll() {

        //Задаём разрешение браузера
        Configuration.browserSize= "2560x1440";

        //Пропускаем полную загрузку страницы
        Configuration.pageLoadStrategy = "eager";

        //Оставляем браузер открытым
        Configuration.holdBrowserOpen = true;
    }


    @Test
    public void selenideRepositoriesSearch() {

        //Открыть github
        open("https://github.com/");

        //ввести в поиск selenide
        $(".search-input").click();
        $("#query-builder-test").setValue("selenide").pressEnter();

        // Кликнуть на первый результат
        $$("[data-testid='results-list'] .search-title a")
                .first()
                .shouldBe(visible)
                .click();

        // Проверить, по элементам что перешли на страницу репозитория
        $("a.url.fn").shouldHave(text("selenide"));
        $("a[href='/selenide/selenide']").shouldHave(text("selenide"));

    }
}

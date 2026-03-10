package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WikiHWTest {

    @BeforeAll
    static void beforeAll() {

        //Задаём разрешение браузера
        Configuration.browserSize= "2560x1440";

        //Задаём URL
        Configuration.baseUrl = "https://github.com/";

        //Пропускаем полную загрузку страницы
        Configuration.pageLoadStrategy = "eager";

        //Оставляем браузер открытым
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void wikiHWTest() {

        //Открыть Selenide в Github
        open("/selenide/selenide");

        //Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();

        //Нажать Show 3 more pages
        $("li.wiki-more-pages-link button").click();

        //Проверка наличия SoftAssertions
        $("a[href='/selenide/selenide/wiki/SoftAssertions'] div.Truncate-text").shouldHave(text("SoftAssertions"));

        //Открыть страницу SoftAssertions
        $("a[href='/selenide/selenide/wiki/SoftAssertions']").click();

        // проверить пример кода для JUnit5
        $("#user-content-3-using-junit5-extend-test-class").parent().shouldHave(text("3. Using JUnit5 extend test class"));


    }
}


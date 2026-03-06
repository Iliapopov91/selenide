package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BestContributorToSelenideTest {

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
    public void andreySolntsevTheFirstContributer() {

        //Открыть Selenide
        open("/selenide/selenide");

        //Навести курсор на первого контрибьютера
        $("div.prc-PageLayout-Pane-AyzHK").$(Selectors.byText("Contributors"))
                .closest(".BorderGrid-cell").$$("ul li").first().hover();

        Selenide.sleep(5000);
        //Проверка окна на содержание текста Andrey Solntsev

    }
}

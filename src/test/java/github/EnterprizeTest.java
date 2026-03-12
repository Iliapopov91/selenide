package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class EnterprizeTest {


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
    public void enterprizeTest() {

        //Открыть github
        open("https://github.com/");

        //Навести курсор на Solutions
        $$("button.NavDropdown-module__button__PEHWX")
                .findBy(text("Solutions"))
                .hover();

        //Нажать на Enterprises
        $("a[href='/enterprise']").click();

        //Ожидание дозагрузки страницы. Пробовал через shouldBe(visible), но не срабтало, по этому поставил ожидание элемента
        $("#hero-section-brand-heading").should(appear, Duration.ofSeconds(100));

        //Проверка открытия страницы Solutions по заголовку Enterprise-grade by design
        $("#hero-section-brand-heading")
                .shouldHave(text("The AI-powered developer platform for the agent-ready enterprise"));


    }
}


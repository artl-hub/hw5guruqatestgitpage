import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;

public class Hw5_Task1_TestGitPageEnterprize {


    @BeforeAll
    static void beforAll() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
//        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }

    @Test
    void findEnterprizeInSolutions() {

        //      1. Открыть главную страницу GitHub
        open("https://github.com");

        //      2. На главной странице GitHub выберите меню Solutions -> Enterprize
        //      с помощью команды hover для Solutions
        $x("//button[contains(text(), 'Solution')]").hover();
        $x("//a[contains(text(), 'Enterprise')]").click();

        //      3. Убедитесь что загрузилась нужная страница (заголовок - "The AI-powered"
        $x("//h1[contains(text(), 'The AI-powered')]").shouldBe(visible);



    }
}

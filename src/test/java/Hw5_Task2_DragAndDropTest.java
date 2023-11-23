import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Hw5_Task2_DragAndDropTest {


    @BeforeAll
    static void beforAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
//        Configuration.holdBrowserOpen = true;
    }

    @Test
    void dragAndDrop(){

        //      1. Открыть  https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");

        //      2. Перенести прямоугольник А на место B с помощью Drag&Drop Selenide.actions()
//        $("#column-a").dragAndDrop((DragAndDropOptions) $("#column-b")); -не удалось использовать вместо actions()

        actions().moveToElement($("#column-a")).clickAndHold().
                moveByOffset(214, 0).release().perform();

        //      3. Проверьте, что прямоугольники действительно поменялись
        $x("//*[@id=\"column-a\"]/header").shouldHave(text("B"));
        $x("//*[@id=\"column-b\"]/header").shouldHave(text("A"));

    }
}

package testUiJira.PageObject.PageSteps;

import io.cucumber.java.ru.И;

import java.time.Duration;

import static testUiJira.PageObject.PageElements.MainPageElem.*;
import static com.codeborne.selenide.Condition.visible;

public class MainPageSteps {
    @И ("переходим на страницу проекта")
    public static void MainMetodProject() {
        projectMenu.shouldBe(visible, Duration.ofSeconds(60)).click();
        myProjectTEST.shouldBe(visible, Duration.ofSeconds(60)).click();
        fullListTask.shouldBe(visible, Duration.ofSeconds(60)).click();
    }
    @И ("смотрим количесво задач в проекте")
    public static void PageProjectTask(){

        String numberTask = countAllTask.getText();//Вывод количества задач проекта в консоль
        System.out.println("Общее Количество задач в проекте: " + numberTask);
    }

}

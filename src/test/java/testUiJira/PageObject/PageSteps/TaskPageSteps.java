package testUiJira.PageObject.PageSteps;

import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static testUiJira.PageObject.PageElements.MainPageElem.*;
import static testUiJira.PageObject.PageElements.TaskPageElem.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;

public class TaskPageSteps{

    @Допустим("выполняем поиск задачи - \"([^\"]*)\" и открываем страницу задачи$")
    public static void SearchTask(String nameTask) {

        searchField.shouldBe(visible, Duration.ofSeconds(60));
        searchField.setValue(nameTask).pressEnter();//Поиск и переход к задаче TestSelenium_bug

        String nameTaskAccert = assertTaskName.getText();
        Assertions.assertEquals(nameTaskAccert, "TestSelenium_bug", "ошибка при открытии страницы задачи");

    }
    @Тогда("статус задачи должен быть - \"([^\"]*)\"$")
    public static void TaskPageInfoStatus(String status){
        String statusCheck=statusTask.getText();
        Assertions.assertEquals(statusCheck, status, "Неверный статус");
        System.out.println("Статус задачи: "+statusCheck);
    }
    @И("затронутая версия - \"([^\"]*)\"$")
    public static void TaskPageInfoVer(String version)
    {
        String versionCheck=versionTask.getText();
        Assertions.assertEquals(versionCheck, version, "Неверная версия");
        System.out.println("Затронутая версия: "+versionCheck);
    }

    @И("переодим стутус задачи до ГОТОВО")
    public static void TaskPageStepsMethod(){

        allTask.click(); //нажали кнопку Задачи

        myTasks.shouldBe(visible, Duration.ofSeconds(60)).click(); //Перехоим в мои открутые задачи

        myTaskName.shouldBe(visible, Duration.ofSeconds(60)).click(); //Открываем нужную задачу

        btnInWork.shouldBe(visible, Duration.ofSeconds(60)).click();//Перевод статуса задачи в "В работе"

        //Ожиадние (пока закроется модальное окно о смене статуса
        sleep(2000);

        businesPr.shouldBe(visible, Duration.ofSeconds(60)).click();
        doneBtn.shouldBe(visible, Duration.ofSeconds(60)).click();//Перевод статуса задачи в "ГОТОВО"

        //Проверяем поле статуса пока в нем не будет "ГОТОВО"
         while (!statusTask.getText().equals("ГОТОВО"))
         {
             statusTask.getText();
         }

        String statusOK=statusTask.getText();
        Assertions.assertEquals(statusOK, "ГОТОВО", "ошибка");
    }
}

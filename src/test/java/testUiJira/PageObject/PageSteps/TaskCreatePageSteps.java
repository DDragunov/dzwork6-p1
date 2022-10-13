package testUiJira.PageObject.PageSteps;

import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static testUiJira.PageObject.PageElements.MainPageElem.*;
import static testUiJira.PageObject.PageElements.TaskCreatePageElem.*;
import static com.codeborne.selenide.Condition.visible;

public class TaskCreatePageSteps {

    @Когда("нажимаем кнопку \"Создать\"")
    public static void BtnCreateTask()
    {
        newTaskBag.click();
    }

    @Тогда("должно открыться окно с заголовком - \"([^\"]*)\"$")
    public static void namePageCreateTaskAccert(String namePage)
    {
        String versionCheck=nameFrameTaskAccert.getText();
        Assertions.assertEquals(versionCheck, namePage, "Не открылось окно создания задачи");
    }
    @И("вводим данные новой задачи и создаем задачу")
    public static void TaskCreateStepsMethod(){

        typeTask.shouldBe(visible, Duration.ofSeconds(60)).click();
        typeTask.sendKeys("Ошибка");
        typeTask.pressEnter();

        themeTask.setValue("Ошибка окна программы");

        setDescriptionText("Окно программы открывается неверно", descriptionTask);

        versionEdit.scrollIntoView(true).click();

        setDescriptionText("Операционная система: Windows", environTask);

        versionTouch.scrollIntoView(true).click(); //Выбрать затронутая версия

        taskWorkMy.click();//Назначить меня

        btnCreate.click();

    }


}

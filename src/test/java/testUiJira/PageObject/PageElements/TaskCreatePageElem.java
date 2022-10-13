package testUiJira.PageObject.PageElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.switchTo;

public class TaskCreatePageElem {

    public static SelenideElement nameFrameTaskAccert=$x("//h2[contains(@id, 'jira-dialog2__heading')]");
    public static SelenideElement typeTask=$x("//input[@id='issuetype-field']");

    public static SelenideElement themeTask=$x("//input[@name='summary']");

    public static SelenideElement descriptionTask=$x("//div[@id='description-wiki-edit']//iframe");

    public static SelenideElement versionEdit=$x("(//option[@value='10001'])[1]");

    public static SelenideElement environTask=$x("//div[@id='environment-wiki-edit']//iframe");

    public static SelenideElement versionTouch=$x("(//option[@value='10001'])[2]");

    public static SelenideElement taskWorkMy=$x("//button[contains(text(), 'Назначить меня')]");

    public static SelenideElement btnCreate=$x("//input[@value='Создать']");


    public static SelenideElement fieldFrame=$x("//p");
    public static void setDescriptionText(String description, SelenideElement field) {
        switchTo().frame(field);
        fieldFrame.setValue(description);
        switchTo().defaultContent();
    }

}

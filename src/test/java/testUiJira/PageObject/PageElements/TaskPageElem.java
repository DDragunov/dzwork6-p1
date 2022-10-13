package testUiJira.PageObject.PageElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class TaskPageElem {

    public static SelenideElement allTask=$x("//a[contains(@title,'Поиск и просмотр')]");
    public static SelenideElement myTasks=$x("//a[contains(text(),'Мои открытые задачи')]");
    public static SelenideElement myTaskName=$x("//li[@title='Ошибка окна программы']");
    public static SelenideElement btnInWork=$x("//span[(text()='В работе')]");
    public static SelenideElement businesPr=$x("//span[(text()='Бизнес-процесс')]");
    public static SelenideElement doneBtn=$x("//span[text()='Выполнено']");
    public static SelenideElement statusTask=$x("//span[contains(@class, 'jira-issue-status-lozenge')]");

    //public static SelenideElement statusTask=$x("//strong[contains(text(),'Статус:')]//following-sibling::span");
    public static SelenideElement versionTask=$x("//strong[@title='Исправить в версиях']//following-sibling::span");
    public static SelenideElement assertTaskName = $x ("//h1[@id='summary-val']");

}

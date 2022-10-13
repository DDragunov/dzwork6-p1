package testUiJira.PageObject.PageElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPageElem {

    public static SelenideElement projectMenu = $x ("//a[contains(@title, 'Просмотр недавних проектов')]");
    public static SelenideElement myProjectTEST = $x("//div[@id='project_current']//a[contains(@href,'TEST')]");
    public static SelenideElement fullListTask = $x("//span[contains(@class,'aui-iconfont-issues')]");
    public static SelenideElement countAllTask = $x("//span[starts-with(text(),'1')]");
    public static SelenideElement searchField=$x("//input[@placeholder='Поиск']");
    //public static SelenideElement statusTask=$x("//strong[contains(text(),'Статус:')]//following-sibling::span");
    //public static SelenideElement versionTask=$x("//strong[@title='Исправить в версиях']//following-sibling::span");
    //public static SelenideElement assertTaskName = $x ("//h1[@id='summary-val']");
    public static SelenideElement newTaskBag=$x("//a[contains(text(),'Создать')]");

    public static SelenideElement nameWindowTask=$x("//h2");

}

package testUiJira.PageObject.PageElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPageElem {
    public static SelenideElement loginIcon = $x ("//a[contains(@class,'login-link')]");
    public static SelenideElement loginField = $x ("//input[@name='os_username']");
    public static SelenideElement passwordField = $x("//input[@name='os_password']");
    public static SelenideElement loginBtn = $x("//input[@value='Вход']");

    //заголовок старницы, зашли на главную
    public static SelenideElement assertElemPage = $x ("//h1");
}

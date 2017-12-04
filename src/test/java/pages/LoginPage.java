package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static utils.ConfigProperties.getTestProperty;

public class LoginPage {

    public static SelenideElement loginPage = $(By.xpath("//a[text()='Login']"));
    public static SelenideElement loginField = $(By.id("username"));
    public static SelenideElement passwordField =  $(By.id("password"));

    public static void login(){
        open(getTestProperty("URL"));
        loginPage.click();
        loginField.val(getTestProperty("login"));
        passwordField.val(getTestProperty("password"))
                .pressEnter();
    }

}

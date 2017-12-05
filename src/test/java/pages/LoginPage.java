package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static utils.ConfigProperties.getTestProperty;

public class LoginPage {

    public static SelenideElement loginPage = $x("//a[text()='Login']");
    public static SelenideElement loginField = $(By.id("username"));
    public static SelenideElement passwordField =  $(By.id("password"));
    public static SelenideElement btnLogin = $x("//button[text()='Login']");

    public static void openMainPage(){
        open(getTestProperty("URL"));
    }

    public static void setLoginField(String login){
        loginField.val(login);
    }

    public static void setPasswordField(String password){
        passwordField.val(password);
    }

    public static void login(){
        openMainPage();
        loginPage.click();
        setLoginField(getTestProperty("login"));
        setPasswordField(getTestProperty("password"));
        btnLogin.pressEnter();
    }
}

package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static utils.ConfigProperties.getTestProperty;

public class LoginPage {

    public static SelenideElement loginPage = $x("//a[text()='Login']");
    public static SelenideElement loginField = $(By.id("username"));
    public static SelenideElement passwordField =  $(By.id("password"));
    public static SelenideElement btnLogin = $x("//button[text()='Login']");
    public static SelenideElement btnLogout = $x("//a[text()='logout']");
    public static SelenideElement btnAddOperation = $x("//a[text()='Операция сложения']");
    public static SelenideElement errMsgLogin = $x("//span[text()='Поле Логин обязательное для заполнения']");
    public static SelenideElement errMsgPsw = $x("//span[text()='Поле Пароль обязательное для заполнения']");

    /**
     * Enter login
     * @param login
     */
    public static void setLoginField(String login){
        loginField.val(login);
    }

    /**
     * Enter password
     * @param password
     */
    public static void setPasswordField(String password){
        passwordField.val(password);
    }

    /**
     * Method for sign in with login/ password from properties file
     */
    public static void login(){
        loginPage.click();
        setLoginField(getTestProperty("login"));
        setPasswordField(getTestProperty("password"));
        btnLogin.pressEnter();
    }
}

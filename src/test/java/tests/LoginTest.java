package tests;

import org.junit.Test;
import utils.BaseTest;

import static com.codeborne.selenide.Condition.*;
import static pages.LoginPage.*;
import static utils.RandomGenerator.randStr;

public class LoginTest extends BaseTest {
    @Test
    public void wrongLoginTest() {
        openMainPage();
        loginPage.click();

        btnLogin.shouldBe(disabled);

        loginField.val(randStr(6));
        btnLogin.shouldBe(disabled);

        passwordField.val(randStr(4));
        btnLogin.shouldBe(enabled);
    }
}

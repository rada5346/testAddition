package tests;

import org.junit.Test;
import pages.AddPage;
import pages.HomePage;
import utils.BaseTest;

import static com.codeborne.selenide.Condition.*;
import static pages.HomePage.titleHomePage;
import static pages.LoginPage.*;
import static utils.RandomGenerator.randStr;

public class LoginLogoutTest extends BaseTest {
    private final static int STR_LENGTH = 6;

    @Test
    public void loginLogoutTest(){
        HomePage.openMainPage();
        titleHomePage.shouldBe(visible);

        loginPage.click();

        loginField.shouldBe(visible);
        passwordField.shouldBe(visible);

        login();
        AddPage.titleAddPage.shouldBe(visible);

        btnLogout.click();
        titleHomePage.shouldBe(visible);

        btnAddOperation.click();
        loginField.shouldBe(visible);
        passwordField.shouldBe(visible);
    }

    @Test
    public void wrongLoginTest() {
        HomePage.openMainPage();
        loginPage.click();

        btnLogin.shouldBe(disabled);

        setLoginField(randStr(STR_LENGTH));
        btnLogin.shouldBe(disabled);

        setPasswordField(randStr(STR_LENGTH));
        btnLogin.shouldBe(enabled).click();

        AddPage.titleAddPage.shouldNot(appear);
    }

    @Test
    public void errorMsgTest(){
        HomePage.openMainPage();
        loginPage.click();
        setLoginField(randStr(STR_LENGTH));

        setLoginField("");

        errMsgLogin.should(appear);

        setPasswordField(randStr(STR_LENGTH));
        setPasswordField("");

        errMsgPsw.should(appear);
    }
}

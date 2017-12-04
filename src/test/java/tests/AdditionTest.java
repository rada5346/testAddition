package tests;

import org.junit.Test;
import pages.AddPage;
import pages.LoginPage;
import utils.BaseTest;

import static com.codeborne.selenide.Condition.*;
import static pages.AddPage.btnBack;
import static pages.AddPage.btnForward;

public class AdditionTest extends BaseTest{
    @Test
    public void testAddition() {
        LoginPage.login();
        btnForward.shouldBe(disabled);
        btnBack.shouldBe(disabled);
        //2
        AddPage.addValues(2);
        btnForward.shouldBe(disabled);

        //3
        AddPage.addValues(3);
        btnForward.shouldBe(enabled);
        btnForward.click();
        AddPage.enteredValuesCheck();
        btnForward.click();

        AddPage.sumValue.waitUntil(exist,10000).shouldHave(text(AddPage.expectedSum()));

    }

    @Test
    public void resultPageVerification(){
        LoginPage.login();
//        AddPage.addValues(genRandomIntValues(3));
        btnForward.click();
        btnForward.click();
        AddPage.sumValue.waitUntil(exist,10000).shouldHave(text(AddPage.expectedSum()));
        AddPage.sumRow.shouldHave(cssClass("bg-success"));

    }

    @Test
    public void enterWrongValues(){
        LoginPage.login();
//        AddPage.addValues(genRandomIntValues(1));
        AddPage.valueFields[0].shouldHave(value("12345")).shouldNotHave(value("."));
        AddPage.valueFields[1].shouldNotHave(value("-"))
                .shouldHave(value("78"));
        AddPage.valueFields[2].shouldNotHave(value("qwe")).shouldBe(empty);





    }


}

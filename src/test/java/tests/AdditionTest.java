package tests;

import org.junit.Test;
import pages.AddPage;
import pages.LoginPage;
import utils.BaseTest;

import static com.codeborne.selenide.Condition.*;
import static pages.AddPage.*;

public class AdditionTest extends BaseTest{

    @Test
    public void testAddition() {
        LoginPage.login();
        btnForward.shouldBe(disabled);
        btnBack.shouldBe(disabled);
        AddPage.addValues(2,true);
        btnForward.shouldBe(disabled);

        AddPage.addValues(3, true);
        btnBack.shouldBe(disabled);
        btnForward.shouldBe(enabled);

        stepName.shouldHave(text(getStepName(0)));
        tableTitle.shouldHave(text(getStepName(0)));

        btnForward.click();
        stepName.shouldHave(text(getStepName(1)));
        tableTitle.shouldHave(text(getStepName(1)));

        AddPage.enteredValuesCheck();
        btnForward.click();
        stepName.shouldHave(text(getStepName(2)));
        tableTitle.shouldHave(text(getStepName(2)));
        btnForward.shouldBe(disabled);
        btnBack.shouldBe(disabled);

        AddPage.sumValue.waitUntil(exist,10000)
                .shouldHave(text(AddPage.expectedSum()));
        enteredValuesCheck();
        stepName.shouldHave(text(getStepName(3)));
        tableTitle.shouldHave(text(getStepName(3)));


    }

    @Test
    public void evenResultTest(){
        LoginPage.login();
        AddPage.addEvenValues(true);
        btnForward.click();
        btnForward.click();
        AddPage.sumValue.waitUntil(exist,10000).shouldHave(text(AddPage.expectedSum()));
        AddPage.sumRow.shouldHave(greenRow);

        btnReturnToStart.click();
        addEvenValues(false);
        btnForward.click();
        btnForward.click();
        AddPage.sumValue.waitUntil(exist,10000).shouldHave(text(AddPage.expectedSum()));
        AddPage.sumRow.shouldNotHave(greenRow);
    }

    @Test
    public void enterWrongValues(){
        String doubleValue = "123.45";
        String negInt = "-78";
        String stringValue = "";
        LoginPage.login();
        AddPage.addValues(doubleValue,negInt,stringValue);
        AddPage.valueFields[0].shouldNotHave(value("."));
        AddPage.valueFields[1].shouldNotHave(value("-"));
        AddPage.valueFields[2].shouldNotHave(value(stringValue)).shouldBe(empty);
    }
}

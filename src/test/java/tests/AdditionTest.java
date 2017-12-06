package tests;

import org.junit.Test;
import pages.AddPage;
import pages.HomePage;
import pages.LoginPage;
import utils.BaseTest;

import static com.codeborne.selenide.Condition.*;
import static pages.AddPage.*;
import static utils.RandomGenerator.randStr;

public class AdditionTest extends BaseTest {
    private static final int TIMEOUT = 5000;
    private static final int STRING_LENGTH = 6;
    private static final int TWO_ARGS = 2;
    private static final int THREE_ARGS = 3;
    private static final int STEP_0 = 0;
    private static final int STEP_1 = 1;
    private static final int STEP_2 = 2;
    private static final int STEP_3 = 3;
    private static final boolean IS_EVEN = true;
    private static final boolean IS_NOT_EVEN = false;

    @Test
    public void testAddition() {
        HomePage.openMainPage();
        LoginPage.login();
        btnForward.shouldBe(disabled);
        btnBack.shouldBe(disabled);
        addValues(TWO_ARGS);
        btnForward.shouldBe(disabled);

        addValues(THREE_ARGS);
        btnBack.shouldBe(disabled);
        btnForward.shouldBe(enabled);

        stepName.shouldHave(text(getStepName(STEP_0)));
        tableTitle.shouldHave(text(getStepName(STEP_0)));

        btnForward.click();
        stepName.shouldHave(text(getStepName(STEP_1)));
        tableTitle.shouldHave(text(getStepName(STEP_1)));

        enteredValuesCheck();
        btnForward.click();
        stepName.shouldHave(text(getStepName(STEP_2)));
        tableTitle.shouldHave(text(getStepName(STEP_2)));
        btnForward.shouldBe(disabled);
        btnBack.shouldBe(disabled);

        sumValue.waitUntil(exist, TIMEOUT).shouldHave(text(AddPage.expectedSum()));
        enteredValuesCheck();
        stepName.shouldHave(text(getStepName(STEP_3)));
        tableTitle.shouldHave(text(getStepName(STEP_3)));
    }

    @Test
    public void evenResultTest() {
        HomePage.openMainPage();
        LoginPage.login();
        AddPage.addEvenOddValues(IS_EVEN);
        btnForward.click();
        btnForward.click();
        sumValue.waitUntil(exist, TIMEOUT).shouldHave(text(AddPage.expectedSum()));
        sumRow.shouldHave(greenRow);

        btnReturnToStart.click();
        addEvenOddValues(IS_NOT_EVEN);
        btnForward.click();
        btnForward.click();
        sumValue.waitUntil(exist, TIMEOUT).shouldHave(text(AddPage.expectedSum()));
        sumRow.shouldNotHave(greenRow);
    }

    @Test
    public void enterWrongValues() {
        String doubleValue = "123.45";
        String negInt = "-78";
        String stringValue = randStr(STRING_LENGTH);
        HomePage.openMainPage();
        LoginPage.login();
        AddPage.addValues(doubleValue, negInt, stringValue);
        AddPage.valueFields[0].shouldNotHave(value("."));
        AddPage.valueFields[1].shouldNotHave(value("-"));
        AddPage.valueFields[2].shouldNotHave(value(stringValue)).shouldBe(empty);
    }
}

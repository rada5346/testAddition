package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static utils.RandomGenerator.generateInt;
import static utils.RandomGenerator.randStr;

public class AddPage {
    private static String[] enteredValues;

    private static final String[] STEP_NAMES = {"Ввод данных", "Подтверждение данных", "Расчет", "Результат"};
    public static SelenideElement titleAddPage = $x("//h1[text()='Операция сложения']");
    public static SelenideElement btnForward = $x("//input[@value='Вперед']");
    public static SelenideElement btnBack = $x("//input[@value = 'Назад']");
    public static SelenideElement btnReturnToStart = $x("//input[@value = 'Вернуться к вводу данных']");

    public static SelenideElement sumValue = $x("//th[text()='Итого:']/following-sibling::td");
    public static SelenideElement sumRow = $x("//th[text()='Итого:']/parent::tr");
    public static SelenideElement[] valueFields = {$(By.id("value1")), $(By.id("value2")), $(By.id("value3"))};

    public static SelenideElement stepName = $x("//div[@class='animate-switch ng-scope']/h4");
    public static SelenideElement tableTitle = $x("//div[@ng-class='vm.slideDir']/div/h4");
    public static Condition greenRow = cssClass("bg-success");

    /**
     * Method is for filling the fields with string or integer values
     * @param args - number of values
     */
    public static void addValues(int args) {
        enteredValues = new String[args];
        String s;
        for (int i = 0; i < args; i++) {
            s = String.valueOf(generateInt(Integer.MAX_VALUE));
            valueFields[i].val(s);
            enteredValues[i] = s;
        }
    }

    /**
     * Method is for filling the fields with even or odd integer values
     * @param isEvenValues - if true fill with even values
     */
    public static void addEvenOddValues(boolean isEvenValues) {
        enteredValues = new String[3];
        String s;
        for (int i = 0; i < 3; i++) {
            s = String.valueOf(isEvenValues ? generateInt(Integer.MAX_VALUE / 2) * 2 : generateInt(Integer.MAX_VALUE / 2) * 2 + 1);
            valueFields[i].val(s);
            enteredValues[i] = s;
        }
    }

    /**
     * Add any values
     * @param values - String values
     */
    public static void addValues(String... values) {
        for (int i = 0; i < values.length; i++) {
            valueFields[i].val(values[i]);
        }
    }

    /**
     * Calculate sum based on entered valuies
     * @return expected sum
     */
    public static String expectedSum() {
        long sum = 0;
        for (String value : enteredValues) {
            sum = sum + Integer.parseInt(value);
        }
        return String.valueOf(sum);
    }

    /**
     * Check table with entered values
     */
    public static void enteredValuesCheck() {
        for (int i = 0; i < 3; i++) {
            $x(String.format("(//th[starts-with(text(),'Значение')]/following-sibling ::td)[%s]", i + 1))
                    .should(text((enteredValues[i])));
        }
    }

    /**
     * Get expected Step Name
     * @param stepNumber
     * @return the name of requested step
     */
    public static String getStepName(int stepNumber) {
        return STEP_NAMES[stepNumber];
    }

}

package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import utils.RandomGenerator;

import java.util.Random;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AddPage {
    private static String[] enteredValues;
    private static final Random random = new Random();


    public static SelenideElement btnForward = $x("//input[@value='Вперед']");
    public static SelenideElement btnBack = $x("//input[@value = 'Назад']");
    public static SelenideElement sumValue = $x("//th[text()='Итого:']/following-sibling::td");
    public static SelenideElement sumRow = $x("//th[text()='Итого:']/parent::tr");
    public static SelenideElement[] valueFields = {
            $(By.id("value1")),
            $(By.id("value2")),
            $(By.id("value3"))
    };


    public static SelenideElement stepName = $x("//div[@class='animate-switch ng-scope']/h4");

    public static SelenideElement tableTitle = $x("//div[@ng-class='vm.slideDir']/div/h4");

//    private static ElementsCollection valueFields = $$x()

    public static void addValues(int args) {
        enteredValues = new String[args];
        String s;
        for (int i = 0; i < args; i++) {
            s = String.valueOf(random.nextInt(Integer.MAX_VALUE));
            valueFields[i].val(s);
            enteredValues[i]=s;
        }
    }

    public static void addWrongValues(){
        final String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJLMNOPQRSTUVWXYZ1234567890!@#$%^&*()_+";
    }

    public static String expectedSum() {
        long sum = 0;
        for (String value : enteredValues) {
            sum = sum + Integer.parseInt(value);
        }
        return String.valueOf(sum);
    }

    public static void enteredValuesCheck() {
        for (int i = 0; i < 3; i++) {
            $x(String.format("(//th[starts-with(text(),'Значение')]/following-sibling::td)[%s]", i + 1))
                    .should(text((enteredValues[i])));

        }
    }

}

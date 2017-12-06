package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static utils.ConfigProperties.getTestProperty;

public class HomePage {
    public static SelenideElement titleHomePage = $x("//h1[text()='Welcome']");

    /**
     * Open main page
     */
    public static void openMainPage(){
        open(getTestProperty("URL"));
    }
}

package utils;
import com.codeborne.selenide.junit.TextReport;
import org.junit.Rule;
import org.junit.rules.TestRule;

public class BaseTest {
    @Rule
    public TestRule report = new TextReport();

}

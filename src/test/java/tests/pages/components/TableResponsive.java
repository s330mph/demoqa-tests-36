package tests.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class TableResponsive {
    private SelenideElement tableResponsive = $(".table-responsive");
    public void verifyResult(String key, String value) {
        tableResponsive.$(byText(key))
                .parent().shouldHave(text(value));
    }
}

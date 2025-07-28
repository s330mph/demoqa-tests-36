package tests.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ResultModal {
    private SelenideElement modalContent =  $(".modal-content");

    public void resultModalAppear() {
        modalContent.shouldHave(text("Thanks for submitting the form"));
    }
    public void resultModalNegative() {
        modalContent.shouldNotBe(visible);
    }
}






package tests.pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ResultModal {

    public void resultModalAppear() {
        $(".modal-content").shouldHave(text("Thanks for submitting the form"));
    }

    public void resultModalNegative() {
        $(".modal-content").shouldNotBe(visible);
    }
}






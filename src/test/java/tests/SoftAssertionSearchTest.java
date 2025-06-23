package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SoftAssertionSearchTest {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com/";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void softAssertionSearchTest() {
        open("/selenide/selenide/wiki");
        $(".markdown-body").shouldHave(text("Soft assertions")).shouldBe(visible);
        //open soft assertion
        $(".markdown-body").$(byText("Soft assertions")).click();
        //check examples
        $(".markdown-body").shouldBe(text("Using JUnit5"));
        $("#wiki-wrapper").shouldHave(text("""
                @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                  @Test
                  void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");
                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                  }
                }
        """));
    }

}


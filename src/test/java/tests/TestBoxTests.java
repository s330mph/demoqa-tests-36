package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
    }


    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ivan@ivanov.com");
        $("#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(3) > label").click();
        $("#userNumber").setValue("+79999999999");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__day.react-datepicker__day--007.react-datepicker__day--weekend").click();
        $("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(3) > label").click();


    }
}
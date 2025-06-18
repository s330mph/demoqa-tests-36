package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

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
        $("[for=gender-radio-3]").click();
        $("#userNumber").setValue("8999999999");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__day.react-datepicker__day--007.react-datepicker__day--weekend").click();
        $("[for=hobbies-checkbox-3]").click();
        File fileToUpload = new File("D:/QA/Artefacts/160х160.png");
        $("[id=uploadPicture]").uploadFile(fileToUpload);
        $("#currentAddress").setValue("1123321123");
        $("#stateCity-wrapper").$(byText("Select State")).click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#stateCity-wrapper").$(byText("Select City")).click();
        $("#stateCity-wrapper").$(byText("Lucknow")).click();
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));







    }
}
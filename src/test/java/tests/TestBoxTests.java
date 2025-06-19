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
        Configuration.pageLoadStrategy = "eager";
    }


    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Ivan");  //firstname
        $("#lastName").setValue("Ivanov");  //lastname
        $("#userEmail").setValue("ivan@ivanov.com");  // email
        $("#genterWrapper").$(byText("Male")).click(); // gender
        $("#userNumber").setValue("8999999999");  // number
        $("#hobbiesWrapper").$(byText("Music")).click();  //hobbies

        $("#dateOfBirthInput").clear();  //date
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--010").click();

        $("#subjectsInput").setValue("Math").pressEnter();  // subject

        $("#uploadPicture").uploadFromClasspath("160х160.png");  //picture

        $("#stateCity-wrapper").$(byText("Select State")).click();  //city
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#stateCity-wrapper").$(byText("Select City")).click();
        $("#stateCity-wrapper").$(byText("Lucknow")).click();

        //checking
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive").shouldHave(text("Ivan"));
        $(".table-responsive").shouldHave(text("Ivanov"));
        $(".table-responsive").shouldHave(text("ivan@ivanov.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("8999999999"));
        $(".table-responsive").shouldHave(text("Music"));
        $(".table-responsive").shouldHave(text("160х160.png"));
        $(".table-responsive").shouldHave(text("10 April,1990"));
        $(".table-responsive").shouldHave(text("Math"));
        $(".table-responsive").shouldHave(text("Uttar Pradesh"));
        $(".table-responsive").shouldHave(text("Lucknow"));

    }
}
package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tests.pages.PracticeFormPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestBoxTestsPageObjects extends TestBase {

    PracticeFormPage practiceFormPage = new PracticeFormPage();
    @Test
    void fillFormTest() {
        practiceFormPage.openPage()
                .setFirstName("Ivan")
                .setLasttName("Ivanov")
                .setEmail("ivan@ivanov.com")
                .setGender("Male")
                .setNumber("8999999999")
                .setHobbies("Music")
                .setDateOfBirth("10", "April", "1990")
                .setSubject("Maths")
                .uploadPicture("160х160.png")
                .setAdress("Uttar Pradesh", "Lucknow")
                .submit();

        practiceFormPage.checkTableResult("Student Name", "Ivan"+ " "+"Ivanov")
                .checkTableResult("Student Email", "ivan@ivanov.com")
                .checkTableResult("Gender", "Male")
                .checkTableResult("Mobile", "8999999999")
                .checkTableResult("Hobbies", "Music")
                .checkTableResult("Date of Birth", "10" + " " + "April" + "," + "1990")
                .checkTableResult("Subjects", "Maths")
                .checkTableResult("Picture", "160х160.png")
                .checkTableResult("State and City", "Uttar Pradesh" + " " + "Lucknow");

    }
    @Test
    void minumalFillFormTest(){
        practiceFormPage.openPage()
                .setFirstName("Ivan")
                .setLasttName("Ivanov")
                .setGender("Male")
                .setNumber("8999999999")
                .submit();

        practiceFormPage.resultModalAppear();
        practiceFormPage.checkTableResult("Student Name", "Ivan"+ " "+"Ivanov")
                .checkTableResult("Gender", "Male")
                .checkTableResult("Mobile", "8999999999");


    }

    @Test
    void negativeFillFormTest() {
        practiceFormPage.openPage()
                .setFirstName("Ivan")
                .setLasttName("")
                .setGender("Male")
                .setNumber("8999999999")
                .submit();

        practiceFormPage.resultModalNegative();
    }

}
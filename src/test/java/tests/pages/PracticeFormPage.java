package tests.pages;

import com.codeborne.selenide.SelenideElement;
import tests.pages.components.CalendarComponent;
import tests.pages.components.ResultModal;
import tests.pages.components.TableResponsive;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormPage {
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            calendarInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            uploadPicture = $("#uploadPicture"),
            stateCityInput = $("#stateCity-wrapper");

    CalendarComponent calendarComponent = new CalendarComponent();
    TableResponsive tableResponsive = new TableResponsive();
    ResultModal resultModal = new ResultModal();


    public PracticeFormPage openPage(){
            open("/automation-practice-form");
            return this;
        }

    public PracticeFormPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setLasttName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    public PracticeFormPage setEmail(String value){
        userEmailInput.setValue(value);
        return this;
    }
    public PracticeFormPage setGender(String value){
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage setNumber(String value){
        userNumber.setValue(value);
        return this;
    }

    public PracticeFormPage setHobbies(String value){
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    public PracticeFormPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public PracticeFormPage setSubject(String value){
        subjectInput.setValue("Math").pressEnter();
        return this;
    }

    public PracticeFormPage uploadPicture(String value){
        uploadPicture.uploadFromClasspath(value);
        return this;
    }

    public PracticeFormPage setAdress(String state, String city){
        stateCityInput.$(byText("Select State")).click();  //city
        stateCityInput.$(byText(state)).click();
        stateCityInput.$(byText("Select City")).click();
        stateCityInput.$(byText(city)).click();
        return this;
    }
    public PracticeFormPage submit(){
        $("#submit").click();
        return this;
    }

    public PracticeFormPage checkTableResult(String key, String value){
        tableResponsive.verifyResult(key, value);
        return this;
    }

    public PracticeFormPage resultModalNegative() {
        resultModal.resultModalNegative();
        return this;
    }

    public PracticeFormPage resultModalAppear() {
        resultModal.resultModalAppear();
        return this;
    }
}

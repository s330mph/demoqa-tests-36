package tests.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private SelenideElement
            monthInput = $(".react-datepicker__month-select"),
            yearInput = $(".react-datepicker__year-select");
    public void setDate(String day, String month, String year){
        monthInput.selectOption(month);
        yearInput.selectOption(year);
        $(".react-datepicker__day--0"+day).click();
    }
}

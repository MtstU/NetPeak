package com.netpeak.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selenide.*;

public class FormFillPage {

    @FindBy(xpath = "//div[@id='up_file_name']/label[@class='control-label']")
    public SelenideElement fileFormatErrorMessage;

    @FindBy(id="inputName")
    public SelenideElement inputNameForm;

    @FindBy(id="inputLastname")
    public SelenideElement inputLastNameForm;

    @FindBy(id="submit")
    public SelenideElement submitBtn;

    @FindBy(css = "input[type=file]")
    public SelenideElement uploadCV;

    @FindBy(xpath = "//p[.='Все поля являются обязательными для заполнения']")
    public SelenideElement allFieldsShouldBeFilledError;

    @FindBy(xpath = "//a[@href='https://school.netpeak.group/']")
    public SelenideElement coursesPageLink;

    public CoursesPage clickCoursesPageLink () {
        coursesPageLink.click();
        return page(CoursesPage.class);

    }

    public void enterName(String name) {
        inputNameForm.click();
        inputNameForm.clear();
        inputNameForm.sendKeys(name);
    }

    public void enterLastName(String lastName) {
        inputLastNameForm.click();
        inputLastNameForm.clear();
        inputLastNameForm.sendKeys(lastName);
    }

    public  void clickSubmitBtn() {
        submitBtn.click();
    }

    public void uploadCVFile(String filePath) {
        //uploadCV.click();
        uploadCV.sendKeys(filePath);

    }

    public void fileFormatError () {
        fileFormatErrorMessage.shouldHave(Condition.text("Ошибка: неверный формат файла (разрешённые форматы: doc, docx, pdf, txt, odt, rtf)."));
        //Ошибка: неверный формат файла (разрешённые форматы: doc, docx, pdf, txt, odt, rtf).
    }

    public void allFieldsFilled () {
        allFieldsShouldBeFilledError.shouldHave(cssValue("color", "rgba(255, 0, 0, 1)"));
    }
}
package com.netpeak.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class CareerPage {

    @FindBy(xpath = "//a[@href='//career.netpeak.group/hiring/']")
    public SelenideElement formFillPageLink;

    public FormFillPage clickFormFillPageLink() {
        formFillPageLink.click();
        return page(FormFillPage.class);

    }
}

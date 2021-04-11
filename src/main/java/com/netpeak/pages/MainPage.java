package com.netpeak.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class MainPage {

        @FindBy(xpath = "//a[@href='https://career.netpeak.ua/']")
        public SelenideElement careerPageLink;

    public CareerPage clickCareerPageLink() {
        careerPageLink.click();
        return page(CareerPage.class);
    }
}

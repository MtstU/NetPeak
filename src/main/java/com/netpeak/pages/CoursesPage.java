package com.netpeak.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;

public class CoursesPage {

    @FindBy(xpath = "//h1[.='Образовательный Центр Netpeak']")
    public SelenideElement coursesPageHeader;

    public void checkCoursesPage() {

        coursesPageHeader.shouldBe(Condition.visible);
        //coursesPageHeader.shouldBe(Condition.cssValue(Color.fromString("FF0000")));
    }

}

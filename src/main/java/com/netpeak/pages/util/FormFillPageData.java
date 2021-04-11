package com.netpeak.pages.util;

public class FormFillPageData {

    private String name;
    private String lastName;
    private String filePath;

    public FormFillPageData(String name, String lastName, String filePath) {
        this.name = name;
        this.lastName = lastName;
        this.filePath = filePath;
    }

    public String getName() {
        return this.name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFilePath() {
        return this.filePath;
    }
}




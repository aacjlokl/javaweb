package com.bjpowernode.entity;

public class Question {
    private String title;
    private String optiona;
    private String optionb;
    private String optionc;
    private String optiond;
    private String answer;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOptiona() {
        return optiona;
    }

    public void setOptiona(String optiona) {
        this.optiona = optiona;
    }

    public String getOptionb() {
        return optionb;
    }

    public void setOptionb(String opyionb) {
        this.optionb = opyionb;
    }

    public String getOptionc() {
        return optionc;
    }

    public void setOptionc(String optionc) {
        this.optionc = optionc;
    }

    public String getOptiond() {
        return optiond;
    }

    public void setOptiond(String optiond) {
        this.optiond = optiond;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Question() {
    }

    public Question(String title, String optiona, String opyionb, String optionc, String optiond, String answer) {
        this.title = title;
        this.optiona = optiona;
        this.optionb = opyionb;
        this.optionc = optionc;
        this.optiond = optiond;
        this.answer = answer;
    }


}

package com.neu.projo;

public class Account {
    private String name;
    private String pw;
    private double accountLeft;

    public Account(String name, String pw, double accountLeft) {
        this.name = name;
        this.pw = pw;
        this.accountLeft = accountLeft;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public void setAccountLeft(double accountLeft) {
        this.accountLeft = accountLeft;
    }

    public String getName() {
        return name;
    }

    public String getPw() {
        return pw;
    }

    public double getAccountLeft() {
        return accountLeft;
    }
}

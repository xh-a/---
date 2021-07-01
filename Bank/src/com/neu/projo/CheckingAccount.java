package com.neu.projo;

public class CheckingAccount extends Account{
    private SavingAccount savingAccount;

    public SavingAccount getSavingAccount() {
        return savingAccount;
    }

    public CheckingAccount(String name, String Pw, double accountLeft, double savingAcountLeft) {
        super(name,Pw, accountLeft);
        savingAccount = new SavingAccount(name,Pw,savingAcountLeft);
    }
}

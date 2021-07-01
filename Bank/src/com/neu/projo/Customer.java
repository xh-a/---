package com.neu.projo;

public class Customer {
    private String name;

    public String getName() {
        return name;
    }

    public CheckingAccount getCheckingAccount() {
        return account;
    }

    public SavingAccount getSavingAccount() {
        return savingAccount;
    }

    private CheckingAccount account;
    private SavingAccount savingAccount;

    public Customer(String name, CheckingAccount account) {
        this.name = name;
        this.account = account;
        savingAccount = account.getSavingAccount();
    }

    public double consume(double price){
        if(savingAccount.getAccountLeft() >= price){
            savingAccount.setAccountLeft(savingAccount.getAccountLeft()-price);
            return 0;
        }else{
            price -= savingAccount.getAccountLeft();
            if(account.getAccountLeft() >= price){
                account.setAccountLeft(account.getAccountLeft()-price);
                savingAccount.setAccountLeft(0.0);
                return 0;
            }else{
                savingAccount.setAccountLeft(0.0);
                account.setAccountLeft(0.0);
                return price - account.getAccountLeft();
            }
        }
    }
}

package com.neu.service.impl;

import com.neu.dao.impl.BankDao;
import com.neu.projo.CheckingAccount;
import com.neu.projo.Customer;
import com.neu.service.IService;

public class Service implements IService {
    BankDao bank = new BankDao();
    Customer curCustomer;

    public Service() {
        openAccount("jack","jack",0.0,0.0);
    }

    public String getName(){
        return curCustomer.getName();
    }

    public double getMoney(){
        return curCustomer.getCheckingAccount().getAccountLeft()+curCustomer.getSavingAccount().getAccountLeft();
    }

    public double getSaving(){
        return curCustomer.getSavingAccount().getAccountLeft();
    }
    @Override
    public boolean openAccount(String name, String pw, double checkingMoney,double savingMoney){
        if(bank.checkCustomer(name) == null){
            CheckingAccount account = new CheckingAccount(name,pw,checkingMoney,savingMoney);
            Customer customer = new Customer(name,account);
            bank.addCustomer(customer);
            return true;
        }else{
            return false;
        }
    }

    public boolean login(String name, String pw){
        curCustomer = bank.checkCustomer(name,pw);
        if(curCustomer == null){
            return false;
        }else{
            return true;
        }
    }

    public boolean depositChecking(double money){
        if(curCustomer != null){
            bank.depositCheckingMoney(curCustomer,money);
            return true;
        }else{
            return false;
        }
    }

    public boolean depositSaving(double money){
        if(curCustomer != null){
            bank.depositSavingMoney(curCustomer,money);
            return true;
        }else{
            return false;
        }
    }

    public boolean draw(double money){
        if(curCustomer != null){
            return bank.drawMoney(curCustomer,money);
        }else{
            return false;
        }
    }

    public void logout(){
        curCustomer = null;
    }
}

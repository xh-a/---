package com.neu.dao.impl;

import com.neu.dao.IBankDao;
import com.neu.projo.Customer;

import java.util.ArrayList;
import java.util.List;

public class BankDao implements IBankDao {
    List<Customer> bankList;

    public BankDao() {
        this.bankList = new ArrayList<Customer>();
    }

    @Override
    public void addCustomer(Customer customer) {
        bankList.add(customer);
    }

    @Override
    public void delCustomer(Customer customer) {
        bankList.remove(customer);
    }

    @Override
    public Customer checkCustomer(String name,String pw) {
        for(Customer el: bankList){
            if(el.getName().equals(name)&&el.getCheckingAccount().getPw().equals(pw)){
                return el;
            }
        }
        return null;
    }

    @Override
    public Customer checkCustomer(String name) {
        for(Customer el: bankList){
            if(el.getName().equals(name)){
                return el;
            }
        }
        return null;
    }


    @Override
    public void depositSavingMoney(Customer customer, double money) {
        customer.getSavingAccount().setAccountLeft(customer.getSavingAccount().getAccountLeft()+money);
    }

    @Override
    public void depositCheckingMoney(Customer customer, double money) {
        customer.getCheckingAccount().setAccountLeft(customer.getCheckingAccount().getAccountLeft()+money);

    }

    @Override
    public boolean drawMoney(Customer customer,double money) {
        if(customer.getCheckingAccount().getAccountLeft()+customer.getSavingAccount().getAccountLeft() < money){
            return false;
        }else{
            customer.consume(money);
            return true;
        }
    }

}

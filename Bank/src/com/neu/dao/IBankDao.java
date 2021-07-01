package com.neu.dao;

import com.neu.projo.Customer;

public interface IBankDao {
    void addCustomer(Customer customer);
    void delCustomer(Customer customer);
    Customer checkCustomer(String name, String pw);
    Customer checkCustomer(String name);
    void depositSavingMoney(Customer customer, double money);
    void depositCheckingMoney(Customer customer, double money);
    boolean drawMoney(Customer customer, double money);
}

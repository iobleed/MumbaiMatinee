package com.plaxedo.MumbaiMatinee.data.entity;

import com.plaxedo.MumbaiMatinee.data.enums.Enums;
import org.springframework.data.annotation.Id;

public class Member {
    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private Enums.ACCOUNT_TYPE account_type;

    // Customer
    private Enums.ACCOUNT_STATUS account_status;
    private int balance;



    public Member() {
        firstName = "";
        lastName = "";
        userName = "";
        password = "";
        account_type = Enums.ACCOUNT_TYPE.CUSTOMER;
        account_status = Enums.ACCOUNT_STATUS.ACTIVE;
        balance = 0;
    }

    public Enums.ACCOUNT_STATUS getAccount_status() {
        return account_status;
    }

    public void setAccount_status(Enums.ACCOUNT_STATUS account_status) {
        this.account_status = account_status;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Enums.ACCOUNT_TYPE getAccount_type() {
        return account_type;
    }

    public void setAccount_type(Enums.ACCOUNT_TYPE account_type) {
        this.account_type = account_type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Member(String id, String firstName, String lastName, String userName, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }


    public Member(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Member[id=%s, firstName='%s', lastName='%s', userName='%s', password='%s', account_type='%s']",
                id, firstName, lastName, userName, password, account_type);
    }
}

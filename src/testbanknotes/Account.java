/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testbanknotes;

/**
 *
 * @author marti
 */
class Account {
    private String number;
    private int balance;

    public Account(String number, int balance) {
        this.number = number;
        
        if (balance >= 0) {
            this.balance = balance;
        }
        else {
            this.balance = 0;
        }
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if (number != null) {
            this.number = number;
        }
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    
    public void deposit (int amount) {
        if (amount >= 0) {
            this.balance += amount;
        }
    }
    
    public void withdraw (int amount) {
        if (amount >= 0) {
            this.balance -= amount;
        }
    }
    
    public boolean overdrawn () {
        return this.balance < 0;
    }
    
    @Override
    public String toString() {
        return String.format("account %s, $%,d",number, balance);
    }
    
}

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
class Customer extends Person {

    private Account account;

    public Customer(Account account, String name, String address) {
        super(name, address);
        this.account = account;
    }

    public Customer(String name) {
        super(name);
    }
    
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        if (account != null && this.account == null) {
            this.account = account;
        }
    }
    
    public Account deleteAccount() {
        Account deletedAccount = account;
        this.account = null;
        return deletedAccount;
    }
    public boolean hasAnAccount() {
        return account != null;
    }

    @Override
    public String toString() {
        if (account != null) {
            return (super.toString() + " with "  + account);
        }
        return (super.toString() + " - no current account");
    }
    
    
}

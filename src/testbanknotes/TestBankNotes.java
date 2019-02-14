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
public class TestBankNotes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         // Standard usage
        Account a1 = new Account("P-0001", 30);
        assert a1.getBalance() == 30;
        
        a1.deposit(100);
        assert a1.getBalance() == 130;
        a1.deposit(3);
        assert a1.getBalance() == 133;
        a1.withdraw(34);
        assert a1.getBalance() == 99 : a1.getBalance();
        
        System.out.println(a1);
        assert a1.toString().equals("account P-0001, $99");
        
        a1.setNumber("P-002");
        assert a1.getNumber().equals("P-002");
        
        assert a1.overdrawn() == false;
        
        a1.withdraw(1000);
        assert a1.getBalance() == -901;
        assert a1.overdrawn();
        
        Person p = new Person("Alan Jackson", "100 Oak Drive");
        assert p.toString().equals("Alan Jackson at 100 Oak Drive") : p.toString();
        
        Account acct = new Account("P-003", 150);
        Customer c1 = new Customer(
                acct, "Rekha Raman", "200 Maple Drive"
        );
        
        System.out.println(c1);
        assert c1.toString().equals("Rekha Raman at 200 Maple Drive with account P-003, $150") : c1.toString();     
        
        assert c1.getName().equals("Rekha Raman");
        assert c1.getAddress().equals("200 Maple Drive");
        
        assert c1.hasAnAccount();
        assert c1.getAccount().getBalance() == 150;
        assert c1.getAccount() == acct;
           
        System.out.println("BEFORE: " + c1.getAccount().getBalance());
        if (c1.hasAnAccount())
            c1.getAccount().deposit(200); 
        System.out.println("AFTER: " + c1.getAccount().getBalance());
        assert c1.getAccount().getBalance() == 350;
        
        Customer c2 = new Customer(null, "John Travolta", "1 Hollywood Blvd");
        System.out.println(c2);
        assert c2.toString().equals("John Travolta at 1 Hollywood Blvd - no current account");
        assert c2.getAccount() == null;
        assert c2.hasAnAccount() == false;
        
        Manager mgr1 = new Manager(50_000, 1, "Roy Rogers", "2 Cactus St");
        assert mgr1.getAddress().equals("2 Cactus St");
        assert mgr1.getSalary() == 50_000;
        System.out.println(mgr1);
        assert mgr1.toString().equals("Manager, employee id 1, Roy Rogers at 2 Cactus St, with a salary of $50,000");
        
        mgr1.setAddress("3 Mountain View Lane");
        assert mgr1.getAddress().equals("3 Mountain View Lane");
        
        mgr1.setEmpId(234);
        assert mgr1.getEmpId() == 234;
        
        mgr1.setName("Mr. Royal R. Rogers");
        assert mgr1.getName().equals("Mr. Royal R. Rogers");
        
        mgr1.setSalary(65_999);
        assert mgr1.getSalary() == 65_999;
        
        System.out.println(mgr1);
        assert mgr1.toString().equals("Manager, employee id 234, Mr. Royal R. Rogers at 3 Mountain View Lane, with a salary of $65,999");

        // You cannot overwrite an existing account (ignore the request).
        
        Customer c3 = new Customer(
                new  Account("P-123", 15), "Susan Anthony", "5000 Freedom Way"
        );
        
        Account acctNew = new Account("P-456", 260);
        assert c3.getAccount().getNumber().equals("P-123");
        
        c3.setAccount(acctNew);
        assert c3.getAccount().getNumber().equals("P-123"); // should be unchanged
        assert c3.hasAnAccount();
        
        Account acctOut = c3.deleteAccount();
        assert c3.hasAnAccount() == false;
        assert c3.getAccount() == null;
        assert acctOut.getNumber().equals("P-123");
        
        c3.setAccount(acctNew);
        assert c3.hasAnAccount();
        assert c3.getAccount().getNumber().equals("P-456");
        
        // Cannot use setAccount to set an account to "null" -- you must use
        // deleteAccount to delete an account.  setAccount(null) is should be
        // ignored.
        
        c3.setAccount(null);
        assert c3.hasAnAccount();
        assert c3.getAccount().getNumber().equals("P-456");
        
        
        // When you delete an account, you are returned a reference to the 
        // just-deleted account.
        
        
        // Error Checking
        Account a2 = new Account("P-200", -55);
        assert a2.getBalance() == 0;
        assert a2.overdrawn() == false;
        assert a2.getNumber().equals("P-200");
        a2.deposit(100);
        assert a2.getBalance() == 100;
        a2.withdraw(5);
        assert a2.getBalance() == 95;
        a2.deposit(-1000);  // ignore negative values
        assert a2.getBalance() == 95;
        
        a2.withdraw(-2000); // ignore negative values
        assert a2.getBalance() == 95;
        
        Manager m2 = new Manager(-10_000, 12, "Bill Bryson", "1234 Fourth St");
        System.out.println(m2);
        assert m2.getSalary() == 0;
        assert m2.toString().equals("Manager, employee id 12, Bill Bryson at 1234 Fourth St, with a salary of $0");
        
        // Default values
        
        // There are no default values for the Account class -- the only Account
        // constructor available requires both an account number and a starting balance.
        
        // A newly created Person can have both a default name, and address.
        Person p4 = new Person("Bob", "1 Street St");
        assert p4.getName().equals("Bob");
        assert p4.getAddress().equals("1 Street St");
        
        Person p5 = new Person("Robert");
        assert p5.getName().equals("Robert");
        assert p5.getAddress().equals("*** NO ADDRESS ***");
        
        Person p6 = new Person();
        assert p6.getName().equals("*** NO NAME ***");
        assert p6.getAddress().equals("*** NO ADDRESS ***");
        
        // A Customer can be created with just a name
        Customer c4 = new Customer("Rob");
        assert c4.getAccount() == null;
        assert c4.hasAnAccount() == false;
        assert c4.getName().equals("Rob");
        assert c4.getAddress().equals("*** NO ADDRESS ***");
        
        // A Manager can be created with just an employee ID
        Manager m3 = new Manager(500);
        assert m3.getAddress().equals("*** NO ADDRESS ***");
        assert m3.getEmpId() == 500;
        assert m3.getName().equals("*** NO NAME ***");
        assert m3.getSalary() == 0;
        assert m3.toString().equals("Manager, employee id 500, *** NO NAME *** at *** NO ADDRESS ***, with a salary of $0");
        System.out.println(m3);
        
        
    }
    
}

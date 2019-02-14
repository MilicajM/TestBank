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
public class Person2 {
    public static final String DEFAULT_NAME = "*** NO NAME ***";
    public static String DEFAULT_ADDRESS = "*** NO ADDRESS ***";
    private String name;
    private String address;

    public Person2(String name, String address) {
        this.name = name;
        this.address = address;
    }
    
    public Person2(String name) {
        this(name, DEFAULT_NAME); //industry way to write 'this'
    }

    public Person2() {
        this(DEFAULT_NAME, DEFAULT_ADDRESS);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("%s at %s", name , address);
    }
    
    
    
    
}

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
class Manager extends Employee {
    private int salary;

    public Manager(int salary, int empId, String name, String address) {
        super(empId, name, address);
        if (salary >= 0) {
            this.salary = salary;
        }
    }

    public Manager(int empId) {
        super(empId);
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if (salary >= 0) {
            this.salary = salary;
        }
    }

    @Override
    public String toString() {
        return String.format("Manager, %s, with a salary of $%,d",super.toString(),salary);
    }
}

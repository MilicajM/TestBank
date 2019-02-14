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
class Employee extends Person {
    private int empId;

    public Employee(int empId, String name, String address) {
        super(name, address);
        this.empId = empId;
    }

    public Employee(int empId) {
        this.empId = empId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "employee id " + empId + ", " + super.toString();
    }
    
}

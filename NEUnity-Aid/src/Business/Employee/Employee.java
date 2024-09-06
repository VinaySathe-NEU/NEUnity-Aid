/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Employee;

/**
 *
 * @author tarunangrish
 */
public class Employee {
    
    private String name;
    private int employeeID;
    private static int count = 1;
    
    public Employee(){
        employeeID = count;
        count++;
    }
    
    public int getEmployeeID(){
        return employeeID;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    @Override
    public String toString(){
        return name;
    }
    
}

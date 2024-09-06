/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import Business.Employee.*;
import Business.Role.*;
import Business.TaskQueue.*;
import Business.UserAccount.*;
import java.util.ArrayList;

/**
 *
 * @author vinaysathe
 */
public abstract class Organization {

    private String name;
    private TaskQueue taskQueue;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int counter=0;
    private Type type;
    
     public enum Type{
        Admin("Admin Organization"), NGO("NGO Organization"), Doctor("Doctor Organization"), Lab("Lab Organization"),Pharmacist("Pharmacy Organization"),
        OrphanageAdmin("Orphanage Admin Organization"), PersonCare("Person Care Organization"), PersonRegistration("Person Registeration Organization"), FinanceOrganization ("Finance Organization"),
        AdoptionAdmin("Adoption Admin Organization"), Espousal("Adoption Organization"), CriminalCheck("Criminal Check Organization"), FinanceCheck("Finance Check Organization"),Adopter("Adopter Organization")
        , Donor("Donor Organization"), Education("Education Organization");
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }
    public Organization(String name) {
        this.name = name;
        taskQueue = new TaskQueue();
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory(); 
        organizationID = counter;
        ++counter;
    }

    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }
    
    public String getName() {
        return name;
    }

    public TaskQueue getTaskQueue() {
        return taskQueue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTaskQueue(TaskQueue taskQueue) {
        this.taskQueue = taskQueue;
    }
 
    @Override
    public String toString() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }   
}


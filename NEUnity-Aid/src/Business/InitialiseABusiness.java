/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business;

import Business.Employee.Employee;
import Business.UserAccount.UserAccount;
import Business.Role.PrincipalAdminRole;

/**
 *
 * @author tarunangrish
 */
public class InitialiseABusiness {
    public static Ecosystem configureEcosystem(){
        
        Ecosystem ecosystem = Ecosystem.getInstance();
        
        Employee employee = ecosystem.getEmployeeDirectory().addEmployee("TRV");
        
        UserAccount ua = ecosystem.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", employee, new PrincipalAdminRole());
        
        return ecosystem;

    }
}

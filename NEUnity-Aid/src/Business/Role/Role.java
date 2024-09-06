/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Business.Role;

import Business.Donor.DonorDirectory;
import Business.Ecosystem;
import Business.Enterprise.Enterprise;
import Business.NGO.NGODirectory;
import Business.Organization.Organization;
import Business.Person.PersonDirectory;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author tarunangrish
 */
public abstract class Role {
    
    public enum RoleType{
        Admin("Admin"),
        NGO("NGO"),
        Doctor("Doctor"),
        LabAssistant("Lab Assistant"),
        PersonCare("Person Care Examinator"),
        FosterCare("Foster Care Admin"),
        PersonRegistration("Person Registrar"), 
        Finance ("Accountant"),
        AdoptionAdmin("Adoption Admin Organization"), 
        Adoption("Adoption Manager"), 
        Adopter("Adopter"),
        CriminalCheck("Criminal Check Org Employee"),
        FinanceCheck("Finance Check Org Employee"),
        Pharmacist("Pharmacist"),
        Donor("Sponsor");
        
    private String roleValue;
    
    private RoleType(String roleValue){
        this.roleValue = roleValue;
    }
    
    public String getRoleValue() {
            return roleValue;
        }

        @Override
        public String toString() {
            return roleValue;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Ecosystem ecosystem, PersonDirectory personDirectory, NGODirectory ngoDirectory,DonorDirectory donorDirectory);
    
    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import userInterface.NGORegisteration.NGOTaskArea;

/**
 *
 * @author tarunangrish
 */
public class NGORole extends Role{
    
    public String toString(){
        return (RoleType.NGO.getRoleValue());
    }    

	@Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Ecosystem ecosystem, PersonDirectory personDirectory, NGODirectory ngoDirectory, DonorDirectory donorDirectory) {
        return new NGOTaskArea(userProcessContainer, account, organization, enterprise, ecosystem, ngoDirectory, personDirectory);
    }
}

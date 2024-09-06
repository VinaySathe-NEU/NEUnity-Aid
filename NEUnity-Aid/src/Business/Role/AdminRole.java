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
import userInterface.AdministrativeRole.AdminTaskAreaJPanel;

/**
 *
 * @author tarunangrish
 */
public class AdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Ecosystem ecosystem, PersonDirectory personDirectory, NGODirectory ngoDirectory, DonorDirectory donorDirectory) {
        return new AdminTaskAreaJPanel(userProcessContainer,account,organization, enterprise, ecosystem, personDirectory,ngoDirectory,donorDirectory);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import userInterface.SupportGroup.SupportGroupMainTaskArea;



/**
 *
 * @author tarunangrish
 */
public class SupportGroupMemberRole extends Role{

    @Override
    public String toString(){
        return (RoleType.Adoption.getRoleValue());
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Ecosystem ecosystem, PersonDirectory personDirectory, NGODirectory ngoDirectory, DonorDirectory donorDirectory) {
        return new SupportGroupMainTaskArea(userProcessContainer, account, organization, enterprise, ecosystem, ngoDirectory);
    }
    
}

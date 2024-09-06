/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Donor.DonorDirectory;
import Business.Ecosystem;
import Business.Enterprise.Enterprise;
import Business.NGO.NGODirectory;
import Business.Organization.Organization;
import Business.Organization.MedicalOrganization;
import Business.Person.PersonDirectory;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import userInterface.MedicOrg.MedicTaskArea;

/**
 *
 * @author tarunangrish
 */
public class MedicRole extends Role{
    
    @Override
    public String toString(){
        return (RoleType.Doctor.getRoleValue());
    }

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Ecosystem ecosystem, PersonDirectory personDirectory, NGODirectory ngoDirectory, DonorDirectory donorDirectory) {
        return new MedicTaskArea(userProcessContainer, account, (MedicalOrganization) organization, enterprise, ecosystem, personDirectory);
    }
}

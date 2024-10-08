/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;


import Business.NGO.NGODirectory;
import Business.Donor.DonorDirectory;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Person.PersonDirectory;
import Business.Role.Role;
import Business.Role.PrincipalAdminRole;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 * creating ecosystem
 * @author shwetabulchandani
 */
public class Ecosystem extends Organization {
    
    private static Ecosystem business;
    private ArrayList<Network> networkCatalog;
    private PersonDirectory personDirectory;
    private NGODirectory ngoDirectory;
    private DonorDirectory donorDirectory;
   

    public Ecosystem(){
        
        super(null);
        
        networkCatalog = new ArrayList<Network>();
        personDirectory = new PersonDirectory();
        ngoDirectory = new NGODirectory();
        donorDirectory = new DonorDirectory();
    }
    
    public static Ecosystem getInstance(){
        if(business==null){
            business=new Ecosystem();
        }
        return business;
    }
    
    public static void setInstance(Ecosystem system) {
        business = system;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList=new ArrayList<Role>();
        roleList.add(new PrincipalAdminRole());
        return roleList;
    }
    
    public boolean checkIfUserIsUnique(String userName){
         if(this.business!=null){
           for (Network network : business.getNetworkCatalog()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                for (UserAccount ua : enterprise.getUserAccountDirectory().getUserAccountList()) {
                    if (ua.getUsername().equalsIgnoreCase(userName)) {
                        return false;
                    }
                }
                for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                        if (ua.getUsername().equalsIgnoreCase(userName)) {
                            return false;
                        }
                    }
                }
            }
        }
    }
    return true;
    }
    
    public boolean isUnique(String name){
        for(Network network : networkCatalog){
            if(network.getName().equalsIgnoreCase(name)){
                return false;
            }
        }
        return true;
    }

    public static Ecosystem getBusiness() {
        return business;
    }

    public static void setBusiness(Ecosystem business) {
        Ecosystem.business = business;
    }

    public ArrayList<Network> getNetworkCatalog() {
        return networkCatalog;
    }

    public void setNetworkCatalog(ArrayList<Network> networkCatalog) {
        this.networkCatalog = networkCatalog;
    }

    public PersonDirectory getPersonDirectory() {
        return personDirectory;
    }

    public void setPersonDirectory(PersonDirectory personDirectory) {
        this.personDirectory = personDirectory;
    }

    public NGODirectory getNGODirectory() {
        return ngoDirectory;
    }

    public void setAdopterDirectory(NGODirectory ngoDirectory) {
        this.ngoDirectory = ngoDirectory;
    }

    public DonorDirectory getDonorDirectory() {
        return donorDirectory;
    }

    public void setDonorDirectory(DonorDirectory donorDirectory) {
        this.donorDirectory = donorDirectory;
    }
    
    public Network createAndAddNetwork(){
        Network network=new Network();
        networkCatalog.add(network);
        return network;
    }
}

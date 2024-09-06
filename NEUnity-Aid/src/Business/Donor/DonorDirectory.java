/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Donor;

import java.util.ArrayList;

/**
 *
 * @author RakshitaJ
 */
public class DonorDirectory {
    
    ArrayList<Donor> donorList;
    
    public DonorDirectory() {
        donorList = new ArrayList<Donor>();
    }
    
    private static DonorDirectory donorDirectory;

    public ArrayList<Donor> getDonorList() {
        return donorList;
    }

    public void setDonorList(ArrayList<Donor> donorList) {
        this.donorList = donorList;
    }

    public static DonorDirectory getDonorDirectory() {
        return donorDirectory;
    }

    public static void setDonorDirectory(DonorDirectory donorDirectory) {
        DonorDirectory.donorDirectory = donorDirectory;
    }
    
    public Donor addNewDonor(){
        Donor donor = new Donor();
        donorList.add(donor);
        return donor;
    }   
    
    public static DonorDirectory getInstance(){
       
        if(donorDirectory == null) {
            donorDirectory=new DonorDirectory();
        }
        return donorDirectory;  
    }
    
}

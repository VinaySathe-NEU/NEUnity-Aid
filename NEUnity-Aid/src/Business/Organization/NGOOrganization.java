/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;
import Business.Role.*;
import java.util.ArrayList;

/**
 *
 * @author tarunangrish
 */
public class NGOOrganization extends Organization{
    String name;
    public NGOOrganization(String name) {
        super(name);
        this.name=name;
    
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new NGORole());
        return roles;
    }
    @Override
    public Organization.Type getType() {
        return Organization.Type.NGO;
    }
}


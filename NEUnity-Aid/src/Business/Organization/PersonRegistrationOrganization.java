/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Organization;

import Business.Role.*;
import Business.Person.*;
import java.util.ArrayList;

/**
 *
 * @author vinaysathe
 */
public class PersonRegistrationOrganization extends Organization {

    PersonDirectory personDirectory;
    String name;

    public PersonRegistrationOrganization(String name) {
        super(name);
        this.name=name;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new PersonRegistrationRole());
        return roles;
    }
    
    @Override
    public Type getType() {
        return  Organization.Type.PersonRegistration;
    }

}

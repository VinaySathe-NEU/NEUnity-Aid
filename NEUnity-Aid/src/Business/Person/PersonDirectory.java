/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Person;

import java.util.ArrayList;

/**
 *
 * @author tarunangrish
 */
public class PersonDirectory {
    
    private ArrayList <Person> personList;
    private static PersonDirectory personDirectory;
    
    
    public static PersonDirectory getInstance() {
        if (personDirectory == null) {
            personDirectory = new PersonDirectory();
        }
        return personDirectory;
    }
    
    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ArrayList<Person> personList) {
        this.personList = personList;
    }

    public PersonDirectory() {
        personList = new ArrayList<Person>();
    }

    public Person addPerson() {
        Person person = new Person();
        personList.add(person);
        return person;
    }

    public void removePerson(Person person) {
        personList.remove(person);
    }
}

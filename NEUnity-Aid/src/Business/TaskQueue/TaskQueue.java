/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.TaskQueue;

import java.util.ArrayList;
import Business.Person.Person;
import Business.TaskQueue.TaskRequest;

/**
 *
 * @author RakshitaJ
 */
public class TaskQueue {
    
    private ArrayList<TaskRequest> taskRequestList;

    public TaskQueue() {
        taskRequestList = new ArrayList();
    }

    public ArrayList<TaskRequest> getTaskRequestList() {
        return taskRequestList;
    }
    
      public void delete(int personId){
       ArrayList<TaskRequest> list = new ArrayList<>();
       for(TaskRequest tr : taskRequestList) {
           if(personId == tr.getPersonID()){
               list.add(tr);
               
           }
       }
       taskRequestList.removeAll(list);
    }
    
}

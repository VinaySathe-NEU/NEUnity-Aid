/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.TaskQueue;

/**
 *
 * @author RakshitaJ
 */
public class PersonCareNGOTaskRequest extends TaskRequest {

   
    private String emailId;
    private String adopterName;

    public String getAdopterName() {
        return adopterName;
    }
    
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setAdopterName(String adopterName) {
        this.adopterName = adopterName;
    }
    
}

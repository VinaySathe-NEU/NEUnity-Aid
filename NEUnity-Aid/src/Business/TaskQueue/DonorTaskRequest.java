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
public class DonorTaskRequest extends TaskRequest {
    
    private String userName;
    private double amount;
    private String emailId;
    private String Remarks;
   

    public String getUserName() {
        return userName;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public double getAmount() {
        return amount;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String Remarks) {
        this.Remarks = Remarks;
    }
      
}

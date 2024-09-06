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
public class EducationAssistTaskRequest extends TaskRequest {
     private String testResult;
     private double amount;

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public double getAmount() {
        return amount;
    }
    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }
    
     private String remarks;

    public String getRemarks() {
        return remarks;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
       
}

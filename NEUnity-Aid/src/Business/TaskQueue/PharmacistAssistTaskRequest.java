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
public class PharmacistAssistTaskRequest extends TaskRequest {
    
    
    private String prescription;
    private String result;

    

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }
    
}

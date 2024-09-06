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
public class NGOTaskStatusCheckRequest extends TaskRequest {
     private String bgcStatus;
     private String financeStatus;
     private String personCareStatus;

    public String getBgcStatus() {
        return bgcStatus;
    }
    public String getFinanceStatus() {
        return financeStatus;
    }

    public void setFinanceStatus(String financeStatus) {
        this.financeStatus = financeStatus;
    }

    public void setBgcStatus(String bgcStatus) {
        this.bgcStatus = bgcStatus;
    }
    public String getPersonCareStatus() {
        return personCareStatus;
    }

    public void setPersonCareStatus(String personCareStatus) {
        this.personCareStatus = personCareStatus;
    }
}

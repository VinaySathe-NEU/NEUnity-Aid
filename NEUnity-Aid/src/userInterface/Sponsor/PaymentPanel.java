/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.Sponsor;

import Business.Person.Person;
import Business.Person.PersonDirectory;
import Business.Donor.Donor;
import Business.Ecosystem;
import Business.Enterprise.Enterprise;
import Business.Organization.DonorOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.TaskQueue.DonorTaskRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 *
 * @author vinaysathe
 */
public class PaymentPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    UserAccount account;
    Enterprise enterprise;
    Ecosystem business;
    DonorOrganization donororganization;
    Donor donor;
    PersonDirectory personDirectory;
    Person person;
  
    public PaymentPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Ecosystem business, PersonDirectory personDirectory, Person person ,Donor donor) { 
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.account=account;
        this.enterprise=enterprise;
        this.business = business;
        this.donororganization =(DonorOrganization) organization;
        this.personDirectory = personDirectory;
        this.donor = donor;
        this.person = person;
         jXDatePicker1.getMonthView().setLowerBound(new Date());
         
    }
    
     private boolean ValidateCardNo() {
        String card = cardNo.getText();
        Pattern pattern;
        Matcher matcher;
        String PHONE_PATTERN = "^[0-9]{16}$";
        pattern = Pattern.compile(PHONE_PATTERN);
        matcher = pattern.matcher(card);
        return matcher.matches();    
    }
    
    private boolean ValidatePostal() {
        String zip = txtPostal.getText();
        Pattern pattern;
        Matcher matcher;
        String PHONE_PATTERN = "^[0-9]{5}$";
        pattern = Pattern.compile(PHONE_PATTERN);
        matcher = pattern.matcher(zip);
        return matcher.matches();
    }


private boolean validateExpDate(){
        String selectedFormaString = "";
         DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        try {
            Date selected = jXDatePicker1.getDate();
            selectedFormaString = format.format(selected);
            return true;
        } catch (Exception e) {
           // JOptionPane.showMessageDialog(null, "Please select the registration date");
            return false;
        }
    }
    private boolean ValidateCVV() {
        String cvv = txtCVV.getText();
        Pattern pattern;
        Matcher matcher;
        String PHONE_PATTERN = "^[0-9]{3}$";
        pattern = Pattern.compile(PHONE_PATTERN);
        matcher = pattern.matcher(cvv);
        return matcher.matches();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cardNo = new javax.swing.JTextField();
        txtCVV = new javax.swing.JTextField();
        txtPostal = new javax.swing.JTextField();
        btnPay = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(134, 187, 216));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(71, 52, 58));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Card Payment");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setText("Card Number");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, -1, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setText("CVV");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, -1, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setText("Expiration Date");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, -1, -1));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setText("Postal Code");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, -1, -1));

        cardNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cardNoActionPerformed(evt);
            }
        });
        add(cardNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 180, -1));

        txtCVV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCVVActionPerformed(evt);
            }
        });
        add(txtCVV, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 180, -1));

        txtPostal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPostalActionPerformed(evt);
            }
        });
        add(txtPostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 390, 180, -1));

        btnPay.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnPay.setText("Pay");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });
        add(btnPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 460, 150, 40));

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 2, 12)); // NOI18N
        jLabel6.setText("please enter your 16 digits card number");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 150, 270, 30));
        add(jXDatePicker1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 310, 180, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/white-credit-cards-payment-icon-transparent-background-21635327066kbzkpmrwpm-2_bgremoval.ai.png"))); // NOI18N
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 500, 520));
    }// </editor-fold>//GEN-END:initComponents

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        // TODO add your handling code here:
         
        if(cardNo.getText().isEmpty() || txtCVV.getText().isEmpty() || txtPostal.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter all the fields");
        }
        else if(!ValidateCVV()) {
            JOptionPane.showMessageDialog(null, "CVV should be 3 digits");
        }
        else if(!ValidateCardNo()) {
            JOptionPane.showMessageDialog(null, "Card number should be 16 digits");
        }
        else if(!ValidatePostal()) {
            JOptionPane.showMessageDialog(null, "Zip should be 5 digits");
        }
        else {
            Date date = jXDatePicker1.getDate();
                DateFormat formatit = new SimpleDateFormat("yyyy-MM-dd");
                String temp = "";
                Date regDate = new Date();
                try {
                    temp = formatit.format(date);
                    regDate = formatit.parse(temp);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Please select the registration date");
                    return;
                }
        DonorTaskRequest donorTaskRequest = new DonorTaskRequest();
        donorTaskRequest.setPersonID(person.getPersonID());
        donorTaskRequest.setPersonName(person.getPersonName());
        donorTaskRequest.setUserID(account.getEmployee().getEmployeeID());
        donorTaskRequest.setUserName(donor.getDonorName());
        donorTaskRequest.setMessage("Sponsored");
        donorTaskRequest.setAmount(person.getAmount());
        donorTaskRequest.setStatus("Payment Successful");
        donorTaskRequest.setSender(account);
        donorTaskRequest.setEmailId(donor.getDonorEmail());
        donorTaskRequest.setRemarks("Payment Completed from Sponsor");
        donororganization.getTaskQueue().getTaskRequestList().add(donorTaskRequest);
        if (donororganization != null) {
            account.getTaskQueue().getTaskRequestList().add(donorTaskRequest);
            business.getTaskQueue().getTaskRequestList().add(donorTaskRequest);
        } 
        JOptionPane.showMessageDialog(null, "Thank you! Payment Initiated");
        btnPay.setEnabled(false);
        cardNo.setText("");
        txtCVV.setText("");
        txtPostal.setText("");
        
        
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        SponsorRequestTable panel = (SponsorRequestTable) component;
        panel.populatePersonTable();
        panel.getComponent(2).setEnabled(false);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        
        }
        
    }//GEN-LAST:event_btnPayActionPerformed
 
    
    private void txtCVVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCVVActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtCVVActionPerformed

    private void cardNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cardNoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cardNoActionPerformed

    private void txtPostalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPostalActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtPostalActionPerformed

    private void jXDatePicker1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXDatePicker1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jXDatePicker1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPay;
    private javax.swing.JTextField cardNo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    private javax.swing.JTextField txtCVV;
    private javax.swing.JTextField txtPostal;
    // End of variables declaration//GEN-END:variables


}

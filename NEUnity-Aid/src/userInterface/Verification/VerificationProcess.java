/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userInterface.Verification;

import Business.NGO.NGO;
import Business.NGO.NGODirectory;
import Business.Ecosystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.FinanceVerificationOrganization;
import Business.Organization.VerificationOrganization;
import Business.UserAccount.UserAccount;
import Business.Utilities.MailSender;
import Business.TaskQueue.NGOTaskStatusCheckRequest;
import Business.TaskQueue.BackgroundCheckTaskRequest;
import Business.TaskQueue.FinanceCheckProcessTaskRequest;
import Business.TaskQueue.TaskRequest;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vinaysathe
 */
public class VerificationProcess extends javax.swing.JPanel {

    /**
     * Creates new form VerificationProcess
     */
    
    JPanel userProcessContainer;
    UserAccount account;
    Enterprise enterprise;
    Ecosystem business;
    NGODirectory ngoDirectory;
    VerificationOrganization BackgroundAndCriminalCheckOrganization;
    NGO ngo;
    BackgroundCheckTaskRequest backgroundCheckTaskRequest;
    
    public VerificationProcess(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Ecosystem business, NGODirectory ngoDirectory, BackgroundCheckTaskRequest backgroundCheckTaskRequest, NGO ngo) {
        initComponents();
        
        this.userProcessContainer=userProcessContainer;
        this.ngoDirectory = ngoDirectory;
        this.account = account;
        this.enterprise = enterprise;
        this.business = business;
        this.BackgroundAndCriminalCheckOrganization = (VerificationOrganization) organization;
        this.backgroundCheckTaskRequest = backgroundCheckTaskRequest;
        this.ngo = ngo;
        
        populateWorkRequest();
        setUserDetailsField();
        
        txtName.setEnabled(false);
        txtAge.setEnabled(false);
        txtSSN.setEnabled(false);
        rdbMale.setEnabled(false);
        rdbFemale.setEnabled(false);
        txtIncome.setEnabled(false);
        txtEmail.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        verificationStatusProcessJLabel = new javax.swing.JLabel();
        adopterDetailsJLabel = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblAge = new javax.swing.JLabel();
        lblSSN = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblIncome = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        txtSSN = new javax.swing.JTextField();
        txtIncome = new javax.swing.JTextField();
        rdbMale = new javax.swing.JRadioButton();
        rdbFemale = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRequest = new javax.swing.JTable();
        lblRemarks = new javax.swing.JLabel();
        txtRemarks = new javax.swing.JTextField();
        btnApprove = new javax.swing.JButton();
        btnDeny = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(47, 72, 88));

        verificationStatusProcessJLabel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        verificationStatusProcessJLabel.setForeground(new java.awt.Color(255, 255, 255));
        verificationStatusProcessJLabel.setText("Verification Status Process");

        adopterDetailsJLabel.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        adopterDetailsJLabel.setForeground(new java.awt.Color(255, 255, 255));
        adopterDetailsJLabel.setText("ADOPTER DETAILS");

        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("Email ID");

        lblName.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setText("Name");

        lblAge.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblAge.setForeground(new java.awt.Color(255, 255, 255));
        lblAge.setText("Age");

        lblSSN.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblSSN.setForeground(new java.awt.Color(255, 255, 255));
        lblSSN.setText("SSN");

        lblGender.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblGender.setForeground(new java.awt.Color(255, 255, 255));
        lblGender.setText("Gender");

        lblIncome.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        lblIncome.setForeground(new java.awt.Color(255, 255, 255));
        lblIncome.setText("Income");

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        rdbMale.setText("Male");

        rdbFemale.setText("Female");

        tblRequest.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tblRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Message", "Sender", "Receiver", "Adopter ID", "Adopter Name", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblRequest);

        lblRemarks.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblRemarks.setForeground(new java.awt.Color(255, 255, 255));
        lblRemarks.setText("Remarks");

        txtRemarks.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        txtRemarks.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnApprove.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnApprove.setText("Approve");
        btnApprove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApproveActionPerformed(evt);
            }
        });

        btnDeny.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnDeny.setText("Deny");
        btnDeny.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDenyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(verificationStatusProcessJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(187, 187, 187))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblRemarks, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtRemarks, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(82, 82, 82)
                                        .addComponent(btnApprove, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(btnDeny, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(229, 229, 229)))
                        .addContainerGap())))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblAge, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(290, 290, 290)
                            .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(450, 450, 450)
                            .addComponent(lblIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(550, 550, 550)
                            .addComponent(txtIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(160, 160, 160)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(9, 9, 9)
                            .addComponent(rdbFemale))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addComponent(lblSSN, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(550, 550, 550)
                            .addComponent(rdbMale, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(160, 160, 160)
                            .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(450, 450, 450)
                            .addComponent(lblGender, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(160, 160, 160)
                            .addComponent(txtSSN, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(50, 50, 50)
                            .addComponent(adopterDetailsJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(550, 550, 550)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 131, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(verificationStatusProcessJLabel)
                .addGap(268, 268, 268)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRemarks, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRemarks))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnApprove)
                    .addComponent(btnDeny))
                .addGap(126, 126, 126))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 60, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(lblAge, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(120, 120, 120)
                            .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(80, 80, 80)
                            .addComponent(lblIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(80, 80, 80)
                            .addComponent(txtIncome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(rdbFemale))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(120, 120, 120)
                            .addComponent(lblSSN, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(rdbMale))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(80, 80, 80)
                            .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(lblGender, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(120, 120, 120)
                            .addComponent(txtSSN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(adopterDetailsJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(120, 120, 120)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 461, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnApproveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApproveActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblRequest.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select the request to proceed.");
            return;
        }

        Object statusval = tblRequest.getValueAt(selectedRow, 5);
        Object receiverval = tblRequest.getValueAt(selectedRow, 2);

        if ("Approved".equals(statusval) || "Denied".equals(statusval)) {
            JOptionPane.showMessageDialog(null, "Request already processed");
        } else {

            if (receiverval.equals(account.getUsername())) {

                BackgroundCheckTaskRequest request = (BackgroundCheckTaskRequest) tblRequest.getValueAt(selectedRow, 0);
                request.setStatus("Approved");
                request.setComment(txtRemarks.getText());
                request.setUserID(ngo.getUserID());
                request.setBgcStatus("Approved");
                populateWorkRequest();
                FinanceCheckProcessTaskRequest fcwreq = new FinanceCheckProcessTaskRequest();
                fcwreq.setMessage("Please initiate Finance check");
                fcwreq.setStatus("Pending with Finance organization");
                fcwreq.setSender(account);
                fcwreq.setUserID(ngo.getUserID());
                fcwreq.setName(ngo.getName());

                Organization org = null;
                for (Network network : business.getNetworkCatalog()) {
                    for (Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()) {
                        for (Organization organization : ent.getOrganizationDirectory().getOrganizationList()) {
                            if (organization instanceof FinanceVerificationOrganization) {
                                org = organization;
                                break;
                            }
                        }
                    }
                }

                if (org != null) {
                    org.getTaskQueue().getTaskRequestList().add(fcwreq);
                    account.getTaskQueue().getTaskRequestList().add(fcwreq);
                    business.getTaskQueue().getTaskRequestList().add(fcwreq);
                }

                for (TaskRequest req : business.getTaskQueue().getTaskRequestList()) {
                    if (req.getUserID() == ngo.getUserID()) {
                        if (req instanceof NGOTaskStatusCheckRequest) {
                            ((NGOTaskStatusCheckRequest) req).setFinanceStatus("Pending");
                            ((NGOTaskStatusCheckRequest) req).setBgcStatus("Approved");
                            ((NGOTaskStatusCheckRequest) req).setMessage("Finance check initialized");
                        }
                    }
                }
                String subject = "Background Check Approved";
                String content = "Your background check has been completed and approved. The request is further sent to Finance check team .You can confirm your status through portal. \nThank you";
                //MailSender.sendEmailMessage(adopter.getEmailId(), subject, content);
                JOptionPane.showMessageDialog(null, "Finance check initialized successfully!");

            } else {
                JOptionPane.showMessageDialog(null, "Please select work request assigned to you");
            }
            txtRemarks.setText("");
        }
    }//GEN-LAST:event_btnApproveActionPerformed

    private void btnDenyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDenyActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblRequest.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select the request to proceed.");
            return;
        }

        Object statusval = tblRequest.getValueAt(selectedRow, 5);
        Object receiverval = tblRequest.getValueAt(selectedRow, 2);
        if ("Approved".equals(statusval) || "Denied".equals(statusval)) {
            JOptionPane.showMessageDialog(null, "Request already processed");
        } else {
            if (receiverval.equals(account.getUsername())) {

                BackgroundCheckTaskRequest request = (BackgroundCheckTaskRequest) tblRequest.getValueAt(selectedRow, 0);

                request.setStatus("Denied");
                request.setComment(txtRemarks.getText());
                request.setSender(account);
                request.setUserID(ngo.getUserID());
                request.setBgcStatus("Denied");
                populateWorkRequest();

                for (TaskRequest req : business.getTaskQueue().getTaskRequestList()) {
                    if (req.getUserID() == ngo.getUserID()) {
                        if (req instanceof NGOTaskStatusCheckRequest) {
                            if (((NGOTaskStatusCheckRequest) req).getFinanceStatus().equals("Pending")) {
                                ((NGOTaskStatusCheckRequest) req).setFinanceStatus("Cancelled");
                                ((NGOTaskStatusCheckRequest) req).setBgcStatus("Denied");
                                ((NGOTaskStatusCheckRequest) req).setMessage("BGC Failed.Request cancelled");

                            }
                        }
                    }
                }
                String subject = "Background Verification failed";
                String content = "We are sorry to inform you that your background check has been failed and cannot proceed with adoption procedure .You can confirm your status through portal. \nThank you";
                try {
                    MailSender.sendEmailMessage(ngo.getEmailId(), subject, content);
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(VerificationProcess.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, "Background check denied. Adopt request cancelled");
            } else {
                JOptionPane.showMessageDialog(null, "Please select work request assigned to you");
            }
            txtRemarks.setText("");
        }
    }//GEN-LAST:event_btnDenyActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adopterDetailsJLabel;
    private javax.swing.JButton btnApprove;
    private javax.swing.JButton btnDeny;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblIncome;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblRemarks;
    private javax.swing.JLabel lblSSN;
    private javax.swing.JRadioButton rdbFemale;
    private javax.swing.JRadioButton rdbMale;
    private javax.swing.JTable tblRequest;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIncome;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtRemarks;
    private javax.swing.JTextField txtSSN;
    private javax.swing.JLabel verificationStatusProcessJLabel;
    // End of variables declaration//GEN-END:variables
    public void populateWorkRequest() {

        DefaultTableModel dtm = (DefaultTableModel) tblRequest.getModel();
        dtm.setRowCount(0);
        for (TaskRequest request : BackgroundAndCriminalCheckOrganization.getTaskQueue().getTaskRequestList()) {
            if (request instanceof BackgroundCheckTaskRequest) {
                if (request.getUserID() == backgroundCheckTaskRequest.getUserID()) {
                    Object[] row = new Object[dtm.getColumnCount()];
                    row[0] = request;
                    row[1] = request.getSender().getEmployee().getName();
                    row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
                    row[3] = request.getUserID();
                    row[4] = request.getName();
                    row[5] = request.getStatus();
                    dtm.addRow(row);
                }
            }
        }
    }

    public void setUserDetailsField() {
        txtAge.setText(String.valueOf(ngo.getAge()));
        txtEmail.setText(ngo.getEmailId());
        txtIncome.setText(String.valueOf(ngo.getAnnualIncome()));
        txtName.setText(ngo.getName());
        txtSSN.setText(ngo.getSsn());
        if (ngo.getGender().equalsIgnoreCase("male")) {
            rdbMale.setSelected(true);
        } else {
            rdbFemale.setSelected(true);
        }
    }
}

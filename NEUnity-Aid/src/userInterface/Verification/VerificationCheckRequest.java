/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userInterface.Verification;

import Business.NGO.NGO;
import Business.NGO.NGODirectory;
import Business.Ecosystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.VerificationOrganization;
import Business.UserAccount.UserAccount;
import Business.TaskQueue.BackgroundCheckTaskRequest;
import Business.TaskQueue.TaskRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vinaysathe
 */
public class VerificationCheckRequest extends javax.swing.JPanel {

    /**
     * Creates new form VerificationCheckRequest
     */
    
    JPanel userProcessContainer;
    UserAccount account;
    Enterprise enterprise;
    Ecosystem business;
    NGODirectory ngoDirectory;
    VerificationOrganization BackgroundAndCriminalCheckOrganization;
    NGO ngo;
    
    public VerificationCheckRequest(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Ecosystem business, NGODirectory ngoDirectory) {
        initComponents();
        
        this.userProcessContainer=userProcessContainer;
        this.ngoDirectory = ngoDirectory;
        this.account=account;
        this.enterprise=enterprise;
        this.business = business;
        this.BackgroundAndCriminalCheckOrganization = (VerificationOrganization)organization;
        this.ngo = ngo; 
        
        populateWorkRequest();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeading = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRequest = new javax.swing.JTable();
        btnAssign = new javax.swing.JButton();
        btnProcess = new javax.swing.JButton();

        setBackground(new java.awt.Color(47, 72, 88));

        lblHeading.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lblHeading.setForeground(new java.awt.Color(255, 255, 255));
        lblHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeading.setText("Background Verification");

        tblRequest.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tblRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Message", "Sender", "Receiver", "UserID", "Adopter Name", "Status"
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

        btnAssign.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnAssign.setText("Assign to me");
        btnAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignActionPerformed(evt);
            }
        });

        btnProcess.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnProcess.setText("Process");
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(lblHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(btnAssign, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(410, 410, 410)
                        .addComponent(btnProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1037, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(lblHeading)
                .addGap(60, 60, 60)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAssign, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProcess))
                .addContainerGap(224, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblRequest.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a work request");
            return;
        }
        Object receiverval = tblRequest.getValueAt(selectedRow, 2);
        Object statusval = tblRequest.getValueAt(selectedRow, 5);

        if ("Pending with BGC organization".equals(statusval) || receiverval == null) {
            TaskRequest request = (TaskRequest) tblRequest.getValueAt(selectedRow, 0);
            request.setReceiver(account);
            request.setStatus("BGC organization processing");
            JOptionPane.showMessageDialog(null, "Work request has been assigned to you");
            populateWorkRequest();
        } else {
            if ("Approved".equals(statusval) || "Denied".equals(statusval)) {
                JOptionPane.showMessageDialog(null, "Please select some other request,this work request is already processed");
            } else if (!receiverval.equals(account.getUsername())) {
                JOptionPane.showMessageDialog(null, "Work request is assigned to someone else");
            } else if (receiverval.equals(account.getUsername())) {
                JOptionPane.showMessageDialog(null, "Work request is already assigned to you");
            }
        }
    }//GEN-LAST:event_btnAssignActionPerformed

    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblRequest.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a work request");
            return;
        }
        TaskRequest request = (TaskRequest) tblRequest.getValueAt(selectedRow, 0);
        Object receiverval = tblRequest.getValueAt(selectedRow, 2);
        Object statusval = tblRequest.getValueAt(selectedRow, 5);
        for (NGO n : ngoDirectory.getNGOList()) {
            if (n.getUserID() == request.getUserID()) {
                ngo = n;
            }
        }
        if (receiverval == null) {
            JOptionPane.showMessageDialog(null, "Please first assign it to yourself");
        } else {
            if (receiverval.equals(account.getUsername()) && statusval.equals("BGC organization processing")) {
                VerificationProcess panel = new VerificationProcess(userProcessContainer, account, BackgroundAndCriminalCheckOrganization, enterprise, business, ngoDirectory, (BackgroundCheckTaskRequest) request, ngo);
                this.userProcessContainer.add("BackgroundAndCriminalCheckProcessRequestJPanel", panel);
                CardLayout layout = (CardLayout) this.userProcessContainer.getLayout();
                layout.next(userProcessContainer);
            } else if ("Approved".equals(statusval) || "Denied".equals(statusval)) {
                JOptionPane.showMessageDialog(null, "The selected work request is already processed");
            } else if (!receiverval.equals(account.getUsername())) {
                JOptionPane.showMessageDialog(null, "Please select the work request assigned to you to proceed");
            }
        }
    }//GEN-LAST:event_btnProcessActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssign;
    private javax.swing.JButton btnProcess;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JTable tblRequest;
    // End of variables declaration//GEN-END:variables

    public void populateWorkRequest() {
        DefaultTableModel dtm = (DefaultTableModel) tblRequest.getModel();
        dtm.setRowCount(0);
        for (TaskRequest request : BackgroundAndCriminalCheckOrganization.getTaskQueue().getTaskRequestList()) {
            if (request instanceof BackgroundCheckTaskRequest) {
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

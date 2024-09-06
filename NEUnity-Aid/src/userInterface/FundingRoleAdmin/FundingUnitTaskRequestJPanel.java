/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.FundingRoleAdmin;

import Business.NGO.NGODirectory;
import Business.Donor.Donor;
import Business.Donor.DonorDirectory;
import Business.Ecosystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Role.DonorRole;
import Business.UserAccount.UserAccount;
import Business.Utilities.MailSender;
import Business.TaskQueue.RegisterDonorRequest;
import Business.TaskQueue.DonorTaskRequest;
import Business.TaskQueue.TaskRequest;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author RakshitaJ
 */
public class FundingUnitTaskRequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form FundingUnitWorkRequestJPanel
     */
    private JPanel userProcessContainer;
    private Ecosystem business;
    private UserAccount userAccount;
    private Enterprise enterprise;
    private Network network;
    private OrganizationDirectory organizationDirectory;
    NGODirectory ngoDirectory;
    DonorDirectory donorDirectory;

    public FundingUnitTaskRequestJPanel(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, Ecosystem system, NGODirectory ngoDirectory, DonorDirectory donorDirectory) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.enterprise = enterprise;
        this.business = system.getInstance();
        this.ngoDirectory = ngoDirectory;
        this.donorDirectory = donorDirectory;
        this.organizationDirectory = enterprise.getOrganizationDirectory();
        this.business = system.getInstance();
        populateTable();
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();
        model.setRowCount(0);
        for (TaskRequest taskRequest : enterprise.getTaskQueue().getTaskRequestList()) {
            if (taskRequest instanceof RegisterDonorRequest) {
                Object[] row = new Object[model.getColumnCount()];
                row[0] = taskRequest;
                row[1] = ((RegisterDonorRequest) taskRequest).getName();
                row[2] = ((RegisterDonorRequest) taskRequest).getUserEmailId();
                row[3] = ((RegisterDonorRequest) taskRequest).getUserContact();
                row[4] = ((RegisterDonorRequest) taskRequest).getSsn();
                row[5] = ((RegisterDonorRequest) taskRequest).getStatus();
                model.addRow(row);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        assignJButton = new javax.swing.JButton();
        processJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(158, 228, 147));
        setMinimumSize(new java.awt.Dimension(1058, 840));
        setPreferredSize(new java.awt.Dimension(1058, 840));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        workRequestJTable.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        workRequestJTable.setForeground(new java.awt.Color(25, 56, 82));
        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "UserName", "Name", "Email ID", "Contact", "SSN", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 870, 170));

        assignJButton.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        assignJButton.setForeground(new java.awt.Color(25, 56, 82));
        assignJButton.setText("Assign To Me");
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });
        add(assignJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 400, -1, -1));

        processJButton.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        processJButton.setForeground(new java.awt.Color(25, 56, 82));
        processJButton.setText("Process");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });
        add(processJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 400, 130, -1));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Sponsorship Requests");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 431, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Sponsorluk2-removebg-preview.png"))); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 960, 620));
    }// </editor-fold>//GEN-END:initComponents

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed
        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow >= 0) {
            TaskRequest request = (TaskRequest) workRequestJTable.getValueAt(selectedRow, 0);
            //if (request.getStatus().equalsIgnoreCase("Completed")) {
            if ("Completed".equalsIgnoreCase(request.getStatus())) {
                JOptionPane.showMessageDialog(null, "Request already processed.");
                return;
            } else {
                request.setReceiver(userAccount);
                request.setStatus("Pending");
                populateTable();
                JOptionPane.showMessageDialog(null, "Request has successfully assigned");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Choose a request to process.");
            return;
        }
    }//GEN-LAST:event_assignJButtonActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed
        int selectedRow = workRequestJTable.getSelectedRow();
        try {
            if (selectedRow >= 0) {
                RegisterDonorRequest request = (RegisterDonorRequest) workRequestJTable.getValueAt(selectedRow, 0);
                //if (request.getStatus().equalsIgnoreCase("Completed")) {
                if ("Completed".equalsIgnoreCase(request.getStatus())) {
                    JOptionPane.showMessageDialog(null, "Request already processed.");
                    return;
                }
                Organization org = organizationDirectory.createOrganization(request.getName(), Organization.Type.Donor);
                Employee emp = org.getEmployeeDirectory().addEmployee(request.getName());
                UserAccount ua1 = org.getUserAccountDirectory().createUserAccount(request.getUserName(), request.getUserPassword(), emp, new DonorRole());
                Donor donor = new Donor();
                int uid = donorDirectory.getDonorList().size() + 1;
                donor = this.donorDirectory.addNewDonor();
                donor.setDonorIncome(Long.parseLong(request.getUserContact()));
                donor.setDonorEmail(request.getUserEmailId());
                donor.setDonorName(request.getUserName());
                donor.setDonorSSN(request.getSsn());
                donor.setUserID(uid);
                donor.setUserName(ua1.getUsername());
                DonorTaskRequest donorTaskRequest = new DonorTaskRequest();
                donorTaskRequest.setStatus("");
                donorTaskRequest.setMessage("Sponsor request");
                donorTaskRequest.setSender(ua1);
                donorTaskRequest.setUserID(donor.getUserID());
                donorTaskRequest.setName(donor.getUserName());
                request.setStatus("Completed");
                String subject = "Account activation";
                String content = "Dear Sponsor, your account has been activated. You may proceed with further process of funding. \n Thank you";
                MailSender.sendEmailMessage(request.getUserEmailId(), subject, content);
                JOptionPane.showMessageDialog(null, "User account has been activated successfully");
                populateTable();
            } else {
                JOptionPane.showMessageDialog(null, "Please select a request message to process.");
                return;
            }
        } catch (Exception e) {
            //System.out.println("Error");
        }
    }//GEN-LAST:event_processJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton processJButton;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}

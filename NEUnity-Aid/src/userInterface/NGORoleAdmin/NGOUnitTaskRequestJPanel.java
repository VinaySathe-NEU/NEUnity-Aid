/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.NGORoleAdmin;

import Business.NGO.NGO;
import Business.NGO.NGODirectory;
import Business.Ecosystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.SupportGroupOrganization;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Role.NGORole;
import Business.UserAccount.UserAccount;
import Business.Utilities.MailSender;
import Business.TaskQueue.NGOProcessTaskRequest;
import Business.TaskQueue.NGORegistrationRequest;
import Business.TaskQueue.TaskRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 * Adoption Unit Work Request
 * @author RakshitaJ
 */
public class NGOUnitTaskRequestJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Ecosystem business;
    private UserAccount userAccount;
    private Enterprise enterprise;
    private Network network;
    private OrganizationDirectory organizationDirectory;
    NGODirectory ngoDirectory;

    // Adoption Unit Work Request JPanel
    
    public NGOUnitTaskRequestJPanel(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, Ecosystem system, NGODirectory ngoDirectory) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.enterprise = enterprise;
        this.business = system.getInstance();
        this.ngoDirectory = ngoDirectory;
        this.organizationDirectory = enterprise.getOrganizationDirectory();
        populateTable();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    public void populateTable() {

        DefaultTableModel model = (DefaultTableModel) ngoTaskRequest.getModel();

        model.setRowCount(0);

        for (TaskRequest taskRequest : enterprise.getTaskQueue().getTaskRequestList()) {

            if (taskRequest instanceof NGORegistrationRequest) {
                Object[] row = new Object[model.getColumnCount()];
                row[0] = taskRequest;
                row[1] = ((NGORegistrationRequest) taskRequest).getName();
                row[2] = ((NGORegistrationRequest) taskRequest).getUserEmailId();
                row[3] = ((NGORegistrationRequest) taskRequest).getGender();
                row[4] = ((NGORegistrationRequest) taskRequest).getAnnualIncome();
                row[5] = ((NGORegistrationRequest) taskRequest).getSsn();
                row[6] = ((NGORegistrationRequest) taskRequest).getStatus();

                model.addRow(row);
            }
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ngoTaskRequest = new javax.swing.JTable();
        assignJButton = new javax.swing.JButton();
        processJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblRefresh = new javax.swing.JLabel();

        setBackground(new java.awt.Color(134, 187, 216));
        setMinimumSize(new java.awt.Dimension(1058, 840));
        setPreferredSize(new java.awt.Dimension(1058, 840));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ngoTaskRequest.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        ngoTaskRequest.setForeground(new java.awt.Color(25, 56, 82));
        ngoTaskRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "UserName", "Name", "Email ID", "Gender", "Income", "SSN", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ngoTaskRequest);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 980, 170));

        assignJButton.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        assignJButton.setForeground(new java.awt.Color(25, 56, 82));
        assignJButton.setText("Assign To Me");
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });
        add(assignJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, -1, -1));

        processJButton.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        processJButton.setForeground(new java.awt.Color(25, 56, 82));
        processJButton.setText("Process");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });
        add(processJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 430, 120, -1));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(71, 52, 58));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Adoption Requests");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(303, 41, 431, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/istockphoto-1206776889-612x612.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 870, 470));

        lblRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/refreshBtn.png"))); // NOI18N
        lblRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRefreshMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblRefreshMousePressed(evt);
            }
        });
        add(lblRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 130, 40, 40));
    }// </editor-fold>//GEN-END:initComponents
// Assign Button
    
    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed

        int selectedRow = ngoTaskRequest.getSelectedRow();

        if (selectedRow >= 0) {
            TaskRequest taskRequest = (TaskRequest) ngoTaskRequest.getValueAt(selectedRow, 0);
            if ("Completed".equalsIgnoreCase(taskRequest.getStatus())) {
                JOptionPane.showMessageDialog(null, "Request already processed.");
                return;
            } else {
                taskRequest.setReceiver(userAccount);
                taskRequest.setStatus("Pending");

                populateTable();
                JOptionPane.showMessageDialog(null, "Request has successfully assigned");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Choose a request to process.");
            return;
        }
    }//GEN-LAST:event_assignJButtonActionPerformed

    // Process Button
    
    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed

         int selectedRow = ngoTaskRequest.getSelectedRow();

        if (selectedRow >= 0) {
            NGORegistrationRequest request = (NGORegistrationRequest) ngoTaskRequest.getValueAt(selectedRow, 0);
            if ("Completed".equalsIgnoreCase(request.getStatus())) {
                JOptionPane.showMessageDialog(null, "Request already processed.");
                return;
            } else {

                Organization org = organizationDirectory.createOrganization(request.getName(), Organization.Type.NGO);
                Employee emp = org.getEmployeeDirectory().addEmployee(request.getName());
                UserAccount ua1 = org.getUserAccountDirectory().createUserAccount(request.getUserName(), request.getUserPassword(), emp, new NGORole());
                NGO ngo = new NGO();
                int uid = ngoDirectory.getNGOList().size() + 1;
                ngo = this.ngoDirectory.addNGO();
                ngo.setAge(Integer.parseInt(request.getAge()));
                ngo.setAnnualIncome(Long.parseLong(request.getAnnualIncome()));
                ngo.setEmailId(request.getUserEmailId());
                ngo.setGender(request.getGender());
                ngo.setName(request.getName());
                ngo.setSsn(request.getSsn());
                ngo.setUserID(uid);
                ngo.setUsername(ua1.getUsername());
                ngo.setFlag(false);
                ngo.setName(request.getName());
                NGOProcessTaskRequest ngoProcessTaskRequest = new NGOProcessTaskRequest();
                ngoProcessTaskRequest.setStatus("");
                ngoProcessTaskRequest.setMessage("I want to adopt");
                ngoProcessTaskRequest.setSender(ua1);
                ngoProcessTaskRequest.setUserID(ngo.getUserID());
                ngoProcessTaskRequest.setName(ngo.getName());

                Organization org1 = null;
                List<Organization> list = new ArrayList<>();
                for (Network network : this.business.getNetworkCatalog()) {
                    for (Enterprise ent : network.getEnterpriseDirectory().getEnterpriseList()) {
                        for (Organization organization : ent.getOrganizationDirectory().getOrganizationList()) {
                            if (organization instanceof SupportGroupOrganization) {
                                org1 = organization;
                                list.add(organization);
                                org1.getTaskQueue().getTaskRequestList().add(ngoProcessTaskRequest);
                            }
                        }
                    }
                }
                if (!list.isEmpty() && list.size() > 0) {
                    ua1.getTaskQueue().getTaskRequestList().add(ngoProcessTaskRequest);
                    business.getTaskQueue().getTaskRequestList().add(ngoProcessTaskRequest);
                    populateTable();
                }
                request.setStatus("Completed");
                String subject = "Account activation";
                String content = "Dear NGO, your account has been activated. Your request has been sent to Adoption team. You can check your status through your credentials. \nThank you.";
                try {
                    MailSender.sendEmailMessage(request.getUserEmailId(), subject, content);
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(NGOUnitTaskRequestJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, "User account has been activated successfully");
            }
        }
    }//GEN-LAST:event_processJButtonActionPerformed

    private void lblRefreshMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRefreshMousePressed
        // TODO add your handling code here:
        populateTable();
    }//GEN-LAST:event_lblRefreshMousePressed

    private void lblRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRefreshMouseClicked
        // TODO add your handling code here:
        populateTable();
    }//GEN-LAST:event_lblRefreshMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRefresh;
    private javax.swing.JTable ngoTaskRequest;
    private javax.swing.JButton processJButton;
    // End of variables declaration//GEN-END:variables
}

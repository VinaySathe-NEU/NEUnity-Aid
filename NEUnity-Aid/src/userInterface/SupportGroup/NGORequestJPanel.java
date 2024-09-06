/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userInterface.SupportGroup;

import Business.NGO.NGO;
import Business.NGO.NGODirectory;
import Business.Ecosystem;
import Business.Enterprise.Enterprise;
import Business.Organization.SupportGroupOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.TaskQueue.NGOProcessTaskRequest;
import Business.TaskQueue.TaskRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 * Adoption Request JPanel
 * @author RakshitaJ
 */
public class NGORequestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AdoptionRequestJPanel
     */
    JPanel userProcessContainer;
    UserAccount account;
    Enterprise enterprise;
    Ecosystem business;
    NGODirectory ngoDirectory;
    SupportGroupOrganization supportGroupOrganization;
    NGO ngo;
    
    public NGORequestJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, Ecosystem business, NGODirectory ngoDirectory) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ngoDirectory = ngoDirectory;
        this.account = account;
        this.enterprise = enterprise;
        this.business = business;
        this.supportGroupOrganization = (SupportGroupOrganization) organization;
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

        btnProcess = new javax.swing.JButton();
        btnAssignToMe = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAdoptersRequest = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(158, 228, 147));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnProcess.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnProcess.setText("Process");
        btnProcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcessActionPerformed(evt);
            }
        });
        add(btnProcess, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 460, 112, -1));

        btnAssignToMe.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnAssignToMe.setText("Assign To Me");
        btnAssignToMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignToMeActionPerformed(evt);
            }
        });
        add(btnAssignToMe, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, 132, -1));

        tblAdoptersRequest.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        tblAdoptersRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Message", "Adopter Name", "Receiver", "Adopter ID", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAdoptersRequest);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 830, 160));

        jLabel2.setBackground(new java.awt.Color(246, 226, 187));
        jLabel2.setForeground(new java.awt.Color(71, 52, 58));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/grandparents-parents-kids-icon-family-design-vector-graph-cartoon-concept-represented-isolated-colorfull-illustration-74239628 (1).png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 730, 530));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(71, 52, 58));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Process Adoption Requests");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 357, -1));
    }// </editor-fold>//GEN-END:initComponents
// Process Button
    
    private void btnProcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcessActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblAdoptersRequest.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a work request");
            return;
        }
        TaskRequest req = (TaskRequest) tblAdoptersRequest.getValueAt(selectedRow, 0);
        Object receiverval = tblAdoptersRequest.getValueAt(selectedRow, 2);
        Object statusval = tblAdoptersRequest.getValueAt(selectedRow, 4);
        for (NGO n : ngoDirectory.getNGOList()) {
            if (n.getUserID() == req.getUserID()) {
                ngo = n;
            }
        }
        if (receiverval == null) {
            JOptionPane.showMessageDialog(null, "Please first assign it to yourself");
        }
        
        else {
            if (receiverval.equals(account.getUsername()) && "Pending with Adoption Organization".equals(statusval)) {
                NGOCheckProcess panel = new NGOCheckProcess(userProcessContainer, account, supportGroupOrganization, enterprise, business, ngoDirectory, (NGOProcessTaskRequest) req, ngo);
                this.userProcessContainer.add("AdoptionCheckProcessRequestJPanel", panel);
                CardLayout layout = (CardLayout) this.userProcessContainer.getLayout();
                layout.next(userProcessContainer);
           
            }
        }
    }//GEN-LAST:event_btnProcessActionPerformed

    public void populateWorkRequest() {

        DefaultTableModel dtm = (DefaultTableModel) tblAdoptersRequest.getModel();
        dtm.setRowCount(0);
        for (TaskRequest request : this.business.getTaskQueue().getTaskRequestList()) {

            if (request instanceof NGOProcessTaskRequest) {
                Object[] row = new Object[dtm.getColumnCount()];
                row[0] = request;
                row[1] = request.getName();
                row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
                row[3] = request.getUserID();
                row[4] = request.getStatus();

                dtm.addRow(row);
            }
        }
    }
    private void btnAssignToMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignToMeActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblAdoptersRequest.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a work request to process");
            return;
        }
        Object receiverval = tblAdoptersRequest.getValueAt(selectedRow, 2);
        Object statusval = tblAdoptersRequest.getValueAt(selectedRow, 4);
        if (receiverval == null && (statusval == null || "".equalsIgnoreCase((String) statusval))) {
            TaskRequest re = (TaskRequest) tblAdoptersRequest.getValueAt(selectedRow, 0);
            re.setReceiver(account);
            re.setStatus("Pending with Adoption Organization");
            JOptionPane.showMessageDialog(null, "Request has been assigned to you");
            populateWorkRequest();
        } else if ("Initialized BGC".equals(statusval))
        JOptionPane.showMessageDialog(null, "Please select some other request, this work request is already processed");
        else if (!receiverval.equals(account.getUsername()))
        JOptionPane.showMessageDialog(null, "Work request is assigned to someone else");
        else if (receiverval.equals(account.getUsername())) {
            JOptionPane.showMessageDialog(null, "Work request is already assigned to you");
        }
    }//GEN-LAST:event_btnAssignToMeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssignToMe;
    private javax.swing.JButton btnProcess;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAdoptersRequest;
    // End of variables declaration//GEN-END:variables
}

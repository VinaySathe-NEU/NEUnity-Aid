/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package userInterface.LabOrganization;

import Business.TaskQueue.LabAssistanceTaskRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author tarunangrish
 */
public class LabProcessJPanel extends javax.swing.JPanel {

    /**
     * Creates new form LabProcessJPanel
     */
    JPanel userProcessContainer;
    LabAssistanceTaskRequest request;
    
    public LabProcessJPanel(JPanel userProcessContainer, LabAssistanceTaskRequest request) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLab = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        lblResult = new javax.swing.JLabel();
        txtResult = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(134, 187, 216));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLab.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lblLab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLab.setText("Lab Organization");
        add(lblLab, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 480, 30));

        btnSave.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 360, 130, -1));

        lblResult.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblResult.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblResult.setText("Result");
        add(lblResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 120, 20));
        add(txtResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 290, 100));

        jLabel1.setBackground(new java.awt.Color(246, 226, 187));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/LabOrganization-removebg-preview.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 840, 370));

        jLabel2.setBackground(new java.awt.Color(246, 226, 187));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/labIcon.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, -10, 720, 370));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if (txtResult.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter the test result");
        } else {
            request.setResult(txtResult.getText());
            request.setStatus("Completed");
            JOptionPane.showMessageDialog(null, "Results saved!");
        }
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        LabJPanel panel = (LabJPanel) component;
        panel.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblLab;
    private javax.swing.JLabel lblResult;
    private javax.swing.JTextField txtResult;
    // End of variables declaration//GEN-END:variables
}

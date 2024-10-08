/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.AdministrativeRole;



import Business.Enterprise.NGOEnterprise;
import Business.Enterprise.SupportGroupEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.NEUnityAidEnterprise;
import Business.Enterprise.FundingEnterprise;

import Business.Enterprise.HospitalEnterprise;
import Business.Organization.Organization;
import Business.Organization.Organization.Type;
import Business.Organization.OrganizationDirectory;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author RakshitaJ
 */
public class ManageOrganizationJPanel extends javax.swing.JPanel {

    private OrganizationDirectory directory;
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    /**
     * Creates new form ManageOrganizationJPanel
     */
    public ManageOrganizationJPanel(JPanel userProcessContainer,OrganizationDirectory directory, Enterprise enterprise) {
       initComponents();
        this.userProcessContainer = userProcessContainer;
        this.directory = directory;
        this.enterprise = enterprise;
        
        
        populateTable();

         organizationJComboBox.removeAllItems();
        if(enterprise instanceof HospitalEnterprise){
             organizationJComboBox.addItem(Type.Doctor);
               organizationJComboBox.addItem(Type.Lab);
               organizationJComboBox.addItem(Type.Pharmacist);
        }
        if(enterprise instanceof NEUnityAidEnterprise){
          organizationJComboBox.addItem(Type.PersonCare);
          organizationJComboBox.addItem(Type.PersonRegistration);
        }
        if(enterprise instanceof NGOEnterprise){
           organizationJComboBox.addItem(Type.Adopter);
               organizationJComboBox.addItem(Type.Espousal);
               organizationJComboBox.addItem(Type.FinanceCheck); 
                 organizationJComboBox.addItem(Type.CriminalCheck); 
        }
        if(enterprise instanceof FundingEnterprise){
           organizationJComboBox.addItem(Type.FinanceOrganization);
           organizationJComboBox.addItem(Type.Donor);
               
        }
        if(enterprise instanceof SupportGroupEnterprise){
          organizationJComboBox.addItem(Type.PersonCare);
          organizationJComboBox.addItem(Type.PersonRegistration);
          organizationJComboBox.addItem(Type.Education);
          organizationJComboBox.addItem(Type.Espousal);
          organizationJComboBox.addItem(Type.Adopter);
          organizationJComboBox.addItem(Type.Pharmacist);
        }
    }
    
    private void populateCombo(){
        organizationJComboBox.removeAllItems();
       
        for (Type type : Organization.Type.values()){
            if (!type.getValue().equals(Type.Admin.getValue()))
                organizationJComboBox.addItem(type);
        }
    }
    
    private void populateTable(){
        DefaultTableModel model = (DefaultTableModel) organizationJTable.getModel();
        model.setRowCount(0);
        for (Organization organization : directory.getOrganizationList()){
            Object[] row = new Object[2];
            row[0] = organization.getType();
            row[1] = organization.getName();
            
            model.addRow(row);
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
        organizationJTable = new javax.swing.JTable();
        addJButton = new javax.swing.JButton();
        organizationJComboBox = new javax.swing.JComboBox();
        organizationTypeJLabel = new javax.swing.JLabel();
        nameJLabel = new javax.swing.JLabel();
        orgInstanceName = new javax.swing.JTextField();
        manageOrganizationJLabel = new javax.swing.JLabel();
        pageBackgroundImageJLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(47, 72, 88));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        organizationJTable.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        organizationJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Organization Type", "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(organizationJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 680, 130));

        addJButton.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        addJButton.setText("Add Organization");
        addJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJButtonActionPerformed(evt);
            }
        });
        add(addJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 490, 150, 33));

        organizationJComboBox.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        add(organizationJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 210, 40));

        organizationTypeJLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        organizationTypeJLabel.setForeground(new java.awt.Color(255, 255, 255));
        organizationTypeJLabel.setText("Organization Type ");
        add(organizationTypeJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, -1, 35));

        nameJLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        nameJLabel.setForeground(new java.awt.Color(255, 255, 255));
        nameJLabel.setText("Name");
        add(nameJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, -1, -1));

        orgInstanceName.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        orgInstanceName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orgInstanceNameActionPerformed(evt);
            }
        });
        add(orgInstanceName, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, 210, 30));

        manageOrganizationJLabel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        manageOrganizationJLabel.setForeground(new java.awt.Color(255, 255, 255));
        manageOrganizationJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        manageOrganizationJLabel.setText("Manage Organization");
        add(manageOrganizationJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 370, 30));

        pageBackgroundImageJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/org.png"))); // NOI18N
        add(pageBackgroundImageJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 750, 570));
    }// </editor-fold>//GEN-END:initComponents

    private void addJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJButtonActionPerformed
        Type type = (Type) organizationJComboBox.getSelectedItem();
       if ("".equals(orgInstanceName.getText())) {
            JOptionPane.showMessageDialog(null, "Enter organization name!");
        } else { 
           // if (directory.isUnique(orgInstanceName.getText())) {
                directory.createOrganization(orgInstanceName.getText(), type);
                System.out.println(directory.getOrganizationList());
                JOptionPane.showMessageDialog(null, "Organization Successfully Created");
                orgInstanceName.setText("");
                populateTable();
           /* } else {
                JOptionPane.showMessageDialog(null, "Organization name already exists!");
            }  */         
        }

    }//GEN-LAST:event_addJButtonActionPerformed

    private void orgInstanceNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orgInstanceNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_orgInstanceNameActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addJButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel manageOrganizationJLabel;
    private javax.swing.JLabel nameJLabel;
    private javax.swing.JTextField orgInstanceName;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JTable organizationJTable;
    private javax.swing.JLabel organizationTypeJLabel;
    private javax.swing.JLabel pageBackgroundImageJLabel;
    // End of variables declaration//GEN-END:variables
}

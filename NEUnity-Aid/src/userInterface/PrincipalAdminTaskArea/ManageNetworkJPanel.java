/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.PrincipalAdminTaskArea;

import Business.Ecosystem;
import Business.Network.Network;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vinaysathe
 */
public class ManageNetworkJPanel extends javax.swing.JPanel {
    private JPanel userProcessContainer;
    private Ecosystem system;

    /**
     *
     * Creates new form ManageNetworkJPanel
     */
    public ManageNetworkJPanel(JPanel userProcessContainer, Ecosystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        populateNetworkTable();
    }

    private void populateNetworkTable() {
        DefaultTableModel model = (DefaultTableModel) networkJTable.getModel();
        model.setRowCount(0);
        for (Network network : system.getNetworkCatalog()) {
            Object[] row = new Object[1];
            row[0] = network.getName();
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
        networkJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        submitJButton = new javax.swing.JButton();
        nameJTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(134, 187, 216));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        networkJTable.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        networkJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(networkJTable);
        if (networkJTable.getColumnModel().getColumnCount() > 0) {
            networkJTable.getColumnModel().getColumn(0).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 540, 150));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Name");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 85, 30));

        submitJButton.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        submitJButton.setText("Submit");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });
        add(submitJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 370, 133, 33));

        nameJTextField.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        add(nameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 320, 170, 30));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Manage Network");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 300, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed

        String name = nameJTextField.getText().trim();
        if (!name.isEmpty()) {
            if (system.isUnique(name)) {       
                Network network = system.createAndAddNetwork();
                network.setName(name);
                JOptionPane.showMessageDialog(null, "Network Successfully Created");
                nameJTextField.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Network Already Exits");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Enter network name");
        }
        populateNetworkTable();
    }//GEN-LAST:event_submitJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JTable networkJTable;
    private javax.swing.JButton submitJButton;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.PrincipalAdminTaskArea;

import Business.Ecosystem;
import Business.TaskQueue.NGOProcessTaskRequest;
import Business.TaskQueue.PersonCareTaskRequest;
import Business.TaskQueue.MedicalAssistanceTaskRequest;
import Business.TaskQueue.EducationAssistTaskRequest;

import Business.TaskQueue.TaskRequest;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author vinaysathe
 */
public class Services extends javax.swing.JPanel {
    
    JPanel userProcessContainer;
    Ecosystem system;
    JFreeChart barChart;

    public Services(JPanel userProcessContainer, Ecosystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        populateBarGraph();
    }
    
    public void populateBarGraph() {
        ArrayList<NGOProcessTaskRequest> ngoProcessTaskRequest = new ArrayList<>();
        ArrayList<MedicalAssistanceTaskRequest> medicalAssistanceTaskRequest = new ArrayList<>();
        ArrayList<EducationAssistTaskRequest> educationAssistTaskRequest = new ArrayList<>();
        ArrayList<PersonCareTaskRequest> personCareTaskRequest = new ArrayList<>();
        Map<String, Integer> workReqMap = new HashMap<>();
        for (TaskRequest workQue : system.getTaskQueue().getTaskRequestList()) {
            if (workQue instanceof NGOProcessTaskRequest) {
                ngoProcessTaskRequest.add((NGOProcessTaskRequest) workQue);
            } else if (workQue instanceof MedicalAssistanceTaskRequest) {
                medicalAssistanceTaskRequest.add((MedicalAssistanceTaskRequest) workQue);
            } else if (workQue instanceof EducationAssistTaskRequest) {
                educationAssistTaskRequest.add((EducationAssistTaskRequest) workQue);
            }
            else if (workQue instanceof PersonCareTaskRequest) {
                personCareTaskRequest.add((PersonCareTaskRequest) workQue);
        }

        }
        workReqMap.put("Adoption Services", ngoProcessTaskRequest.size());
        workReqMap.put("Medical Help Services", medicalAssistanceTaskRequest.size());
        workReqMap.put("Financial Help Services", educationAssistTaskRequest.size());
        workReqMap.put("Care Co-ordination Services", personCareTaskRequest.size());

        barChart = ChartFactory.createPieChart(
                "Services At a Glance",
                createDataset(workReqMap),
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(barChart);
        jPanel1.removeAll();
        jPanel1.add(chartPanel, BorderLayout.CENTER);
        jPanel1.validate();
    }
    
    private PieDataset createDataset(Map<String, Integer> taskReqMap) {
        final DefaultPieDataset dataset = new DefaultPieDataset();
        for (String r : taskReqMap.keySet()) {
            dataset.setValue(r, taskReqMap.get(r));
        }
        return dataset;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(134, 187, 216));
        setPreferredSize(new java.awt.Dimension(1058, 840));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new java.awt.BorderLayout());
        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 860, 600));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(71, 52, 58));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Services we provide ");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 594, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
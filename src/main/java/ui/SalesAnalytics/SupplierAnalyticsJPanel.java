/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.SalesAnalytics;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import model.Business.Business;
import model.ProductManagement.ProductSummary;
import model.ProductManagement.ProductsReport;
import model.Supplier.Supplier;
import model.UserAccountManagement.UserAccount;

/**
 *
 * @author anupbochare
 */
public class SupplierAnalyticsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SupplierAnalyticsJPanel
     */
    JPanel cardSequencePanel;
    Business business;
    UserAccount marketAnalyst;

    public SupplierAnalyticsJPanel(JPanel cardSequencePanel, Business business, UserAccount userAccount) {
        initComponents();
        this.cardSequencePanel = cardSequencePanel;
        this.business = business;
        this.marketAnalyst = userAccount;
        populateSupplierCombo();
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
        tblProductSummary = new javax.swing.JTable();
        labelOverperformingSol = new javax.swing.JLabel();
        cmbSupplier = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnBack1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 0, 0));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblProductSummary.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Product", "Sales Above Target Count", "Sales Below Target Count", "Product Price Performance", "Sales Volume"
            }
        ));
        jScrollPane1.setViewportView(tblProductSummary);

        labelOverperformingSol.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        labelOverperformingSol.setForeground(new java.awt.Color(255, 255, 255));
        labelOverperformingSol.setText("Performance Report");

        cmbSupplier.setMaximumRowCount(100);
        cmbSupplier.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cmbSupplier.setOpaque(true);
        cmbSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSupplierActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Supplier :");

        btnBack1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        btnBack1.setText("<< Back");
        btnBack1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBack1.setOpaque(true);
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnBack1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cmbSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(labelOverperformingSol, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                            .addGap(395, 395, 395)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 762, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(339, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnBack1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbSupplier)
                    .addComponent(jLabel1))
                .addGap(19, 19, 19)
                .addComponent(labelOverperformingSol)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(249, 249, 249))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSupplierActionPerformed
        populateProductSummary();
    }//GEN-LAST:event_cmbSupplierActionPerformed

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        // TODO add your handling code here:
        cardSequencePanel.remove(this);
        CardLayout layout = (CardLayout) cardSequencePanel.getLayout();
        layout.previous(cardSequencePanel);
    }//GEN-LAST:event_btnBack1ActionPerformed

    private void populateProductSummary() {
        Supplier supplier = (Supplier) cmbSupplier.getSelectedItem();
        if (supplier != null) {
            //populate the table
            DefaultTableModel model = (DefaultTableModel) tblProductSummary.getModel();
            model.setRowCount(0);
            ProductsReport pr = business.getSupplierPerformanceReport(String.valueOf(supplier));
            for (ProductSummary ps : pr.getProductSummaryList()) {
                Object[] row = new Object[5];
                row[0] = ps.getProductName();
                row[1] = ps.getNumberAboveTarget();
                row[2] = ps.getNumberBelowTarget();
                row[3] = ps.getProductPricePerformance();
                row[4] = ps.getSalesRevenues();
                model.addRow(row);
            }
        }
    }

    private void populateSupplierCombo() {
        cmbSupplier.removeAllItems();
        for (Supplier supplier : business.getSupplierDirectory().getSupplierList()) {
            cmbSupplier.addItem(supplier);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack1;
    private javax.swing.JComboBox<Supplier> cmbSupplier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelOverperformingSol;
    private javax.swing.JTable tblProductSummary;
    // End of variables declaration//GEN-END:variables
}

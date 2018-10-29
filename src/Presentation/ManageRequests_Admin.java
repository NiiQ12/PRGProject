/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import javax.swing.JOptionPane;

/**
 *
 * @author Nicky
 */
public class ManageRequests_Admin extends javax.swing.JFrame
{

    /**
     * Creates new form OrderStocks
     */
    public ManageRequests_Admin()
    {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        cmbSort = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRequests = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRequestDetails = new javax.swing.JTable();
        btnRejectRequest = new javax.swing.JButton();
        btnAcceptRequest = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(650, 500));
        setSize(new java.awt.Dimension(650, 500));
        getContentPane().setLayout(null);

        cmbSort.setName("cmbStationery"); // NOI18N
        cmbSort.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cmbSortActionPerformed(evt);
            }
        });
        getContentPane().add(cmbSort);
        cmbSort.setBounds(230, 80, 260, 20);

        jLabel3.setText("VIEW :");
        jLabel3.setName(""); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(180, 80, 50, 20);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setText("MANAGE REQUESTS");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(240, 20, 270, 29);

        btnBack.setText("BACK");
        btnBack.setName("btnBack"); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(530, 20, 90, 30);

        tblRequests.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "RequestID", "AdminID", "RequestDate", "ReceiveDate", "Accepted"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex)
            {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        tblRequests.setName("tblStationery"); // NOI18N
        tblRequests.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblRequests.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                tblRequestsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblRequests);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(20, 110, 600, 140);

        tblRequestDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "RequestID", "Code", "Category", "Description", "Quantity"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex)
            {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        tblRequestDetails.setName("tblRequestDetails"); // NOI18N
        tblRequestDetails.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblRequestDetails);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 260, 600, 140);

        btnRejectRequest.setText("REJECT REQUEST");
        btnRejectRequest.setActionCommand("REMOVE ITEM");
        btnRejectRequest.setName("btnRejectRequest"); // NOI18N
        btnRejectRequest.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnRejectRequestActionPerformed(evt);
            }
        });
        getContentPane().add(btnRejectRequest);
        btnRejectRequest.setBounds(20, 410, 180, 35);

        btnAcceptRequest.setActionCommand("REMOVE ITEM");
        btnAcceptRequest.setLabel("ACCEPT REQUEST");
        btnAcceptRequest.setName("btnAcceptRequest"); // NOI18N
        btnAcceptRequest.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAcceptRequestActionPerformed(evt);
            }
        });
        getContentPane().add(btnAcceptRequest);
        btnAcceptRequest.setBounds(440, 410, 180, 35);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BG.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 650, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbSortActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cmbSortActionPerformed
    {//GEN-HEADEREND:event_cmbSortActionPerformed
        
    }//GEN-LAST:event_cmbSortActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBackActionPerformed
    {//GEN-HEADEREND:event_btnBackActionPerformed
        AdminMain frame = new AdminMain();
        frame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRejectRequestActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnRejectRequestActionPerformed
    {//GEN-HEADEREND:event_btnRejectRequestActionPerformed

    }//GEN-LAST:event_btnRejectRequestActionPerformed

    private void tblRequestsMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_tblRequestsMouseClicked
    {//GEN-HEADEREND:event_tblRequestsMouseClicked
        
    }//GEN-LAST:event_tblRequestsMouseClicked

    private void btnAcceptRequestActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAcceptRequestActionPerformed
    {//GEN-HEADEREND:event_btnAcceptRequestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAcceptRequestActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(ManageRequests_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ManageRequests_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ManageRequests_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ManageRequests_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new ManageRequests_Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcceptRequest;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRejectRequest;
    private javax.swing.JComboBox<String> cmbSort;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblRequestDetails;
    private javax.swing.JTable tblRequests;
    // End of variables declaration//GEN-END:variables
}

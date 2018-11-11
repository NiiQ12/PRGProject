/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import BusinessLogic.IReport;
import BusinessLogic.ReportType;
import BusinessLogic.Staff;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nicky
 */
public class AdminMain extends javax.swing.JFrame
{
    /**
     * Creates new form Main
     *
     * @throws java.rmi.RemoteException
     * @throws java.rmi.NotBoundException
     */
    public AdminMain() throws RemoteException, NotBoundException
    {
        initComponents();
        this.setLocationRelativeTo(null);

        Registry r = LocateRegistry.getRegistry("localhost", 420);
        ir = (IReport) r.lookup("Report");
    }

    IReport ir;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        btnManageStock = new javax.swing.JButton();
        btnGenerateOrderReport = new javax.swing.JButton();
        btnManageUsers = new javax.swing.JButton();
        btnManageRequests = new javax.swing.JButton();
        btnGenerateStockReport = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(650, 500));
        setResizable(false);
        getContentPane().setLayout(null);

        btnManageStock.setText("MANAGE STOCKS");
        btnManageStock.setName("btnManageStock"); // NOI18N
        btnManageStock.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnManageStockActionPerformed(evt);
            }
        });
        getContentPane().add(btnManageStock);
        btnManageStock.setBounds(240, 100, 160, 40);

        btnGenerateOrderReport.setLabel("ORDER REPORT");
        btnGenerateOrderReport.setName("btnGenerateOrderReport"); // NOI18N
        btnGenerateOrderReport.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnGenerateOrderReportActionPerformed(evt);
            }
        });
        getContentPane().add(btnGenerateOrderReport);
        btnGenerateOrderReport.setBounds(240, 340, 160, 40);

        btnManageUsers.setText("MANAGE USERS");
        btnManageUsers.setName("btnManageUsers"); // NOI18N
        btnManageUsers.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnManageUsersActionPerformed(evt);
            }
        });
        getContentPane().add(btnManageUsers);
        btnManageUsers.setBounds(240, 160, 160, 40);

        btnManageRequests.setText("MANAGE REQUESTS");
        btnManageRequests.setName("btnManageRequests"); // NOI18N
        btnManageRequests.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnManageRequestsActionPerformed(evt);
            }
        });
        getContentPane().add(btnManageRequests);
        btnManageRequests.setBounds(240, 220, 160, 40);

        btnGenerateStockReport.setText("STOCK REPORT");
        btnGenerateStockReport.setActionCommand("GENERATE STOCK REPORT");
        btnGenerateStockReport.setName("btnGenerateStockReport"); // NOI18N
        btnGenerateStockReport.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnGenerateStockReportActionPerformed(evt);
            }
        });
        getContentPane().add(btnGenerateStockReport);
        btnGenerateStockReport.setBounds(240, 280, 160, 40);

        btnBack.setText("LOG OUT");
        btnBack.setMaximumSize(null);
        btnBack.setName("btnBack"); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(510, 20, 110, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setText("ADMIN MENU");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(250, 20, 170, 29);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Logo.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 650, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageStockActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnManageStockActionPerformed
    {//GEN-HEADEREND:event_btnManageStockActionPerformed
        try
        {
            ManageStocks frame = new ManageStocks();
            frame.setVisible(true);
            this.setVisible(false);
        } catch (RemoteException ex)
        {
            Logger.getLogger(AddStocks.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex)
        {
            Logger.getLogger(AddStocks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnManageStockActionPerformed


    private void btnGenerateOrderReportActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnGenerateOrderReportActionPerformed
    {//GEN-HEADEREND:event_btnGenerateOrderReportActionPerformed
        boolean validReportOption = false;

        ReportType rt = null;

        do
        {
            String reportOption = JOptionPane.showInputDialog("Daily (D)\nWeekly (W)\nMonthly (M)");

            switch (reportOption.toUpperCase())
            {
                case "D":
                    validReportOption = true;
                    rt = ReportType.Daily;
                    break;
                case "W":
                    validReportOption = true;
                    rt = ReportType.Weekly;
                    break;
                case "M":
                    validReportOption = true;
                    rt = ReportType.Monthly;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option!");
            }
        } while (!validReportOption);

        try
        {
            ir.GenerateOrderReport(rt);

            JOptionPane.showMessageDialog(null, "The order report has successfully been generated!");
        } catch (SQLException ex)
        {
            Logger.getLogger(AdminMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(AdminMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(AdminMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGenerateOrderReportActionPerformed

    private void btnManageUsersActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnManageUsersActionPerformed
    {//GEN-HEADEREND:event_btnManageUsersActionPerformed
        try
        {
            ManageUsers frame = new ManageUsers();
            frame.setVisible(true);
            this.setVisible(false);
        } catch (RemoteException ex)
        {
            Logger.getLogger(AddStocks.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex)
        {
            Logger.getLogger(AddStocks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnManageUsersActionPerformed

    private void btnManageRequestsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnManageRequestsActionPerformed
    {//GEN-HEADEREND:event_btnManageRequestsActionPerformed
        try
        {
            ManageRequests_Admin frame = new ManageRequests_Admin();
            frame.setVisible(true);
            this.setVisible(false);
        } catch (RemoteException ex)
        {
            Logger.getLogger(AddStocks.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex)
        {
            Logger.getLogger(AddStocks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnManageRequestsActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBackActionPerformed
    {//GEN-HEADEREND:event_btnBackActionPerformed
        Staff.loggedInStaffID = "";

        try
        {
            Login frame = new Login();
            frame.setVisible(true);
            this.setVisible(false);
        } catch (RemoteException ex)
        {
            Logger.getLogger(AdminMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex)
        {
            Logger.getLogger(AdminMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnGenerateStockReportActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnGenerateStockReportActionPerformed
    {//GEN-HEADEREND:event_btnGenerateStockReportActionPerformed
        try
        {
            ir.GenerateStockReport();

            JOptionPane.showMessageDialog(null, "The stock report has successfully been generated!");
        } catch (SQLException ex)
        {
            Logger.getLogger(AdminMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(AdminMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(AdminMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGenerateStockReportActionPerformed

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
            java.util.logging.Logger.getLogger(AdminMain.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(AdminMain.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(AdminMain.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(AdminMain.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    new AdminMain().setVisible(true);
                } catch (RemoteException ex)
                {
                    Logger.getLogger(AdminMain.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotBoundException ex)
                {
                    Logger.getLogger(AdminMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnGenerateOrderReport;
    private javax.swing.JButton btnGenerateStockReport;
    private javax.swing.JButton btnManageRequests;
    private javax.swing.JButton btnManageStock;
    private javax.swing.JButton btnManageUsers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    // End of variables declaration//GEN-END:variables
}
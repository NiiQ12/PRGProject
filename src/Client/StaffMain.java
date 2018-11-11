/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import BusinessLogic.IStaff;
import BusinessLogic.Staff;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicky
 */
public class StaffMain extends javax.swing.JFrame
{

    /**
     * Creates new form Main
     */
    public StaffMain() throws RemoteException, NotBoundException
    {
        initComponents();
        this.setLocationRelativeTo(null);

        Registry r = LocateRegistry.getRegistry("localhost", 420);
        is = (IStaff) r.lookup("Staff");

        try
        {
            is.CheckAdminResponses(Staff.loggedInStaffID);
        } catch (ClassNotFoundException | SQLException ex)
        {
            Logger.getLogger(StaffMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    IStaff is;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        btnRequestStationery = new javax.swing.JButton();
        btnManageAccount = new javax.swing.JButton();
        btnManageRequests = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(650, 500));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowActivated(java.awt.event.WindowEvent evt)
            {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        btnRequestStationery.setLabel("REQUEST STATIONERY");
        btnRequestStationery.setName("btnRequestStationery"); // NOI18N
        btnRequestStationery.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnRequestStationeryActionPerformed(evt);
            }
        });
        getContentPane().add(btnRequestStationery);
        btnRequestStationery.setBounds(230, 130, 180, 40);

        btnManageAccount.setActionCommand("MANAGE ACCOUNT");
        btnManageAccount.setLabel("MANAGE ACCOUNT");
        btnManageAccount.setName("btnManageAccount"); // NOI18N
        btnManageAccount.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnManageAccountActionPerformed(evt);
            }
        });
        getContentPane().add(btnManageAccount);
        btnManageAccount.setBounds(230, 250, 180, 40);

        btnManageRequests.setActionCommand("MANAGE REQUESTS");
        btnManageRequests.setLabel("MANAGE REQUESTS");
        btnManageRequests.setName("btnManageRequests"); // NOI18N
        btnManageRequests.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnManageRequestsActionPerformed(evt);
            }
        });
        getContentPane().add(btnManageRequests);
        btnManageRequests.setBounds(230, 190, 180, 40);

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
        jLabel10.setText("STAFF MENU");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(250, 20, 170, 29);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Logo.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 650, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            Logger.getLogger(StaffMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex)
        {
            Logger.getLogger(StaffMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRequestStationeryActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnRequestStationeryActionPerformed
    {//GEN-HEADEREND:event_btnRequestStationeryActionPerformed
        try
        {
            RequestStationery frame = new RequestStationery();
            frame.setVisible(true);
            this.setVisible(false);
        } catch (RemoteException ex)
        {
            Logger.getLogger(StaffMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex)
        {
            Logger.getLogger(StaffMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRequestStationeryActionPerformed

    private void btnManageAccountActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnManageAccountActionPerformed
    {//GEN-HEADEREND:event_btnManageAccountActionPerformed
        try
        {
            ManageAccount frame = new ManageAccount();
            frame.setVisible(true);
            this.setVisible(false);
        } catch (RemoteException ex)
        {
            Logger.getLogger(StaffMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex)
        {
            Logger.getLogger(StaffMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnManageAccountActionPerformed

    private void btnManageRequestsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnManageRequestsActionPerformed
    {//GEN-HEADEREND:event_btnManageRequestsActionPerformed
        try
        {
            ManageRequests_Staff frame = new ManageRequests_Staff();
            frame.setVisible(true);
            this.setVisible(false);
        } catch (RemoteException ex)
        {
            Logger.getLogger(StaffMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex)
        {
            Logger.getLogger(StaffMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnManageRequestsActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowActivated
    {//GEN-HEADEREND:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(StaffMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(StaffMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(StaffMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(StaffMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    new StaffMain().setVisible(true);
                } catch (RemoteException ex)
                {
                    Logger.getLogger(StaffMain.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotBoundException ex)
                {
                    Logger.getLogger(StaffMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnManageAccount;
    private javax.swing.JButton btnManageRequests;
    private javax.swing.JButton btnRequestStationery;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    // End of variables declaration//GEN-END:variables
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import BusinessLogic.Administrator;
import BusinessLogic.EmployeeType;
import BusinessLogic.ILogin;
import BusinessLogic.Staff;
import java.awt.Color;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nicky
 */
public class Login extends javax.swing.JFrame
{
    public Login() throws RemoteException, NotBoundException
    {
        initComponents();
        this.setLocationRelativeTo(null);

        Registry r = LocateRegistry.getRegistry("localhost", 420);
        il = (ILogin) r.lookup("Login");
    }

    ILogin il;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        btnLogin = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnRegister = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        panel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(650, 500));
        setName("frmLogin"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(650, 500));
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowActivated(java.awt.event.WindowEvent evt)
            {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        btnLogin.setText("Login");
        btnLogin.setName("btnLogin"); // NOI18N
        btnLogin.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin);
        btnLogin.setBounds(290, 230, 110, 30);

        txtUsername.setText("HendrikoA");
        txtUsername.setName(""); // NOI18N
        getContentPane().add(txtUsername);
        txtUsername.setBounds(290, 160, 150, 20);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("USERNAME");
        jLabel1.setName(""); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(200, 160, 69, 20);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PASSWORD");
        jLabel2.setName(""); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(200, 190, 69, 20);

        btnRegister.setText("Register");
        btnRegister.setName("btnRegister"); // NOI18N
        btnRegister.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnRegisterActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegister);
        btnRegister.setBounds(290, 270, 110, 30);

        txtPassword.setText("123");
        txtPassword.setName("txtPassword"); // NOI18N
        getContentPane().add(txtPassword);
        txtPassword.setBounds(290, 190, 150, 20);
        getContentPane().add(panel);
        panel.setBounds(180, 140, 290, 180);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Logo.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 650, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnRegisterActionPerformed
    {//GEN-HEADEREND:event_btnRegisterActionPerformed
        try
        {
            Register frame = new Register();
            frame.setVisible(true);
            this.setVisible(false);
        } catch (RemoteException ex)
        {
            Logger.getLogger(AddStocks.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex)
        {
            Logger.getLogger(AddStocks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnLoginActionPerformed
    {//GEN-HEADEREND:event_btnLoginActionPerformed
        String username = txtUsername.getText();
        String password = txtPassword.getText();

        List<Object> lst;

        try
        {
            if (!(lst = il.TestLogin(username, password)).isEmpty())
            {
                switch ((EmployeeType) lst.get(1))
                {
                    case Staff:
                        Staff.loggedInStaffID = lst.get(0).toString();
                        
                        StaffMain sFrame = new StaffMain();
                        sFrame.setVisible(true);
                        this.setVisible(false);
                        break;
                    case Admin:
                        Administrator.loggedInAdminID = lst.get(0).toString();
                        
                        AdminMain aFrame = new AdminMain();
                        aFrame.setVisible(true);
                        this.setVisible(false);
                        break;
                }
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(BusinessLogic.Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(BusinessLogic.Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex)
        {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex)
        {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowActivated
    {//GEN-HEADEREND:event_formWindowActivated
        panel.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.7f));
    }//GEN-LAST:event_formWindowActivated

    public static void main(String args[])
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    new Client.Login().setVisible(true);
                } catch (RemoteException ex)
                {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotBoundException ex)
                {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel panel;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}

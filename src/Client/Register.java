/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import BusinessLogic.Address;
import BusinessLogic.Department;
import BusinessLogic.Employee;
import BusinessLogic.EmployeeFactory;
import BusinessLogic.IDepartment;
import BusinessLogic.ILogin;
import BusinessLogic.IStaff;
import BusinessLogic.Staff;
import BusinessLogic.Validation;
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
public class Register extends javax.swing.JFrame
{

    /**
     * Creates new form Register
     *
     * @throws java.rmi.RemoteException
     * @throws java.rmi.NotBoundException
     */
    public Register() throws RemoteException, NotBoundException
    {
        initComponents();
        this.setLocationRelativeTo(null);

        Registry r = LocateRegistry.getRegistry("localhost", 420);
        il = (ILogin) r.lookup("Login");
        is = (IStaff) r.lookup("Staff");
        id = (IDepartment) r.lookup("Department");
    }

    ILogin il;
    IStaff is;
    IDepartment id;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        txtSurname = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCellNo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cmbDepartment = new javax.swing.JComboBox<>();
        txtUsername = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        txtSuburb = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        txtPort = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtStreet = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cmbCampus = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(650, 500));
        setName("frmRegister"); // NOI18N
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

        txtSurname.setName("txtSurname"); // NOI18N
        getContentPane().add(txtSurname);
        txtSurname.setBounds(160, 210, 150, 20);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setLabelFor(txtID);
        jLabel1.setText("ID NUMBER");
        jLabel1.setName(""); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(70, 150, 90, 20);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NAME");
        jLabel2.setName(""); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 180, 90, 20);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("SURNAME");
        jLabel3.setName(""); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 210, 90, 20);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CELL NUM");
        jLabel5.setName(""); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(340, 150, 90, 20);

        txtCellNo.setName("txtCellNo"); // NOI18N
        getContentPane().add(txtCellNo);
        txtCellNo.setBounds(430, 150, 150, 20);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("EMAIL");
        jLabel6.setName(""); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(340, 180, 90, 20);

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("STAFF DETAILS");
        jLabel7.setOpaque(true);
        getContentPane().add(jLabel7);
        jLabel7.setBounds(70, 110, 512, 30);

        txtName.setName("txtName"); // NOI18N
        getContentPane().add(txtName);
        txtName.setBounds(160, 180, 150, 20);

        txtEmail.setName("txtEmail"); // NOI18N
        getContentPane().add(txtEmail);
        txtEmail.setBounds(430, 180, 150, 20);

        txtID.setName("txtID"); // NOI18N
        getContentPane().add(txtID);
        txtID.setBounds(160, 150, 150, 20);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setText("REGISTRATION");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(420, 49, 180, 50);

        jButton1.setText("REGISTER");
        jButton1.setName("btnRegister"); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(250, 410, 141, 35);

        cmbDepartment.setName("cmbDepartment"); // NOI18N
        getContentPane().add(cmbDepartment);
        cmbDepartment.setBounds(160, 240, 150, 20);

        txtUsername.setName("txtCity"); // NOI18N
        getContentPane().add(txtUsername);
        txtUsername.setBounds(430, 210, 150, 20);

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("PASSWORD");
        jLabel15.setName(""); // NOI18N
        getContentPane().add(jLabel15);
        jLabel15.setBounds(340, 240, 90, 20);

        txtPassword.setName("txtStreet"); // NOI18N
        getContentPane().add(txtPassword);
        txtPassword.setBounds(430, 240, 150, 20);

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("USERNAME");
        jLabel17.setName(""); // NOI18N
        getContentPane().add(jLabel17);
        jLabel17.setBounds(340, 210, 90, 20);

        jButton5.setText("BACK");
        jButton5.setName("btnBack"); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(530, 20, 90, 30);

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("DEPARTMENT");
        jLabel16.setName(""); // NOI18N
        getContentPane().add(jLabel16);
        jLabel16.setBounds(70, 240, 90, 20);

        panel.setLayout(null);

        txtSuburb.setName("txtSuburb"); // NOI18N
        panel.add(txtSuburb);
        txtSuburb.setBounds(110, 270, 150, 20);

        txtCity.setName("txtCity"); // NOI18N
        panel.add(txtCity);
        txtCity.setBounds(110, 240, 150, 20);

        txtPort.setName("txtPort"); // NOI18N
        panel.add(txtPort);
        txtPort.setBounds(380, 270, 150, 20);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("STREET");
        jLabel8.setName(""); // NOI18N
        panel.add(jLabel8);
        jLabel8.setBounds(290, 240, 90, 20);

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("PORT");
        jLabel9.setName(""); // NOI18N
        panel.add(jLabel9);
        jLabel9.setBounds(290, 270, 90, 20);

        txtStreet.setName("txtStreet"); // NOI18N
        panel.add(txtStreet);
        txtStreet.setBounds(380, 240, 150, 20);

        jLabel11.setBackground(new java.awt.Color(0, 0, 0));
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("ADDRESS DETAILS");
        jLabel11.setOpaque(true);
        panel.add(jLabel11);
        jLabel11.setBounds(20, 200, 512, 30);

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("CITY");
        jLabel12.setName(""); // NOI18N
        panel.add(jLabel12);
        jLabel12.setBounds(20, 240, 90, 20);

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("SUBURB");
        jLabel13.setName(""); // NOI18N
        panel.add(jLabel13);
        jLabel13.setBounds(20, 270, 90, 20);

        cmbCampus.setName("cmbDepartment"); // NOI18N
        panel.add(cmbCampus);
        cmbCampus.setBounds(110, 170, 150, 20);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CAMPUS");
        jLabel4.setName(""); // NOI18N
        panel.add(jLabel4);
        jLabel4.setBounds(20, 170, 90, 20);

        getContentPane().add(panel);
        panel.setBounds(50, 100, 550, 300);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BG.jpg"))); // NOI18N
        getContentPane().add(jLabel14);
        jLabel14.setBounds(0, 0, 650, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton5ActionPerformed
    {//GEN-HEADEREND:event_jButton5ActionPerformed
        try
        {
            Login frame = new Login();
            frame.setVisible(true);
            this.setVisible(false);
        } catch (RemoteException ex)
        {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex)
        {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        Validation.ClearErrors();

        String staffID = txtID.getText();
        Validation.IsValidStaffID(staffID);

        String name = txtName.getText();
        Validation.IsValidName(name);

        String surname = txtSurname.getText();
        Validation.IsValidSurname(surname);

        int department = cmbDepartment.getSelectedIndex() + 1;

        String cellNo = txtCellNo.getText();
        Validation.IsValidCellNo(cellNo);

        String email = txtEmail.getText();
        Validation.IsValidEmail(email);

        String username = txtUsername.getText();
        Validation.IsValidUsername(username);

        String password = txtPassword.getText();
        Validation.IsValidPassword(password);

        String city = txtCity.getText();
        Validation.IsValidCity(city);

        String street = txtStreet.getText();
        Validation.IsValidStreet(street);

        String suburb = txtSuburb.getText();
        Validation.IsValidSuburb(suburb);

        String port = txtPort.getText();
        Validation.IsValidPort(port);

        List<String> errors = Validation.GetErrors();
        String errorMessage = "";

        try
        {
            if (il.CheckLogin(username))
            {
                errors.add("Username Has Already Been Taken");
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex)
        {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (!(errors.isEmpty()))
        {
            for (int i = 0; i < errors.size(); i++)
            {
                errorMessage += (i + 1) + ": " + errors.get(i) + "\n";
            }

            JOptionPane.showMessageDialog(null, errorMessage, "Some Fields Are Incorrect", JOptionPane.WARNING_MESSAGE);
        } else
        {            
            Employee staff = EmployeeFactory.MakeEmployee("Staff", staffID, new Department(department, ""), name, surname, cellNo, email, new Address(0, city, suburb, street, port), new BusinessLogic.Login(0, username, password, false));

            try
            {
                is.AddNewStaffMember((Staff) staff, cmbCampus.getSelectedItem().toString());
            } catch (ClassNotFoundException ex)
            {
                Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex)
            {
                Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex)
            {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }

            try
            {
                Login form = new Login();
                form.setVisible(true);
                this.setVisible(false);
            } catch (RemoteException ex)
            {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NotBoundException ex)
            {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowActivated
    {//GEN-HEADEREND:event_formWindowActivated
        panel.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.7f));

        if (cmbDepartment.getItemCount() == 0)
        {
            try
            {
                List<String> departments = id.GetDepartmentsFromDatabase();

                for (int i = 0; i < departments.size(); i++)
                {
                    cmbDepartment.addItem(departments.get(i));
                }
            } catch (SQLException ex)
            {
                Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex)
            {
                Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex)
            {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (cmbCampus.getItemCount() == 0)
        {
            try
            {
                List<String> campuses = is.GetCampuses();

                for (int i = 0; i < campuses.size(); i++)
                {
                    cmbCampus.addItem(campuses.get(i));
                }
            } catch (SQLException ex)
            {
                Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex)
            {
                Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
            } catch (RemoteException ex)
            {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    new Register().setVisible(true);
                } catch (RemoteException ex)
                {
                    Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotBoundException ex)
                {
                    Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbCampus;
    private javax.swing.JComboBox<String> cmbDepartment;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField txtCellNo;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPort;
    private javax.swing.JTextField txtStreet;
    private javax.swing.JTextField txtSuburb;
    private javax.swing.JTextField txtSurname;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}

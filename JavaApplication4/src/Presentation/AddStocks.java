/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import BusinessLogic.Category;
import BusinessLogic.Manufacturer;
import BusinessLogic.Stationery;
import java.awt.Color;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 *
 * @author Nicky
 */
public class AddStocks extends javax.swing.JFrame
{

    /**
     * Creates new form AddStocks
     */
    public AddStocks()
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

        jLabel10 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtCode = new javax.swing.JTextField();
        cmbManufacturer = new javax.swing.JComboBox<>();
        cmbCategory = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        panel = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(650, 500));
        setMinimumSize(new java.awt.Dimension(650, 500));
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

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setText("ADD STOCKS");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(440, 49, 160, 50);

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

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CODE");
        jLabel1.setName(""); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(70, 210, 90, 20);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DESCRIPTION");
        jLabel2.setName(""); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 240, 90, 20);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CATEGORY");
        jLabel4.setName(""); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(70, 270, 90, 20);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("QUANTITY");
        jLabel5.setName(""); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(325, 210, 100, 20);

        txtQuantity.setText("0");
        txtQuantity.setToolTipText("");
        txtQuantity.setEnabled(false);
        txtQuantity.setName("txtQuantity"); // NOI18N
        getContentPane().add(txtQuantity);
        txtQuantity.setBounds(430, 210, 150, 20);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("PRICE");
        jLabel6.setName(""); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(325, 240, 100, 20);

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("STOCK DETAILS");
        jLabel7.setOpaque(true);
        getContentPane().add(jLabel7);
        jLabel7.setBounds(70, 170, 512, 30);

        txtDescription.setName("txtDescription"); // NOI18N
        getContentPane().add(txtDescription);
        txtDescription.setBounds(160, 240, 150, 20);

        txtPrice.setName("txtPrice"); // NOI18N
        getContentPane().add(txtPrice);
        txtPrice.setBounds(430, 240, 150, 20);

        txtCode.setEnabled(false);
        txtCode.setName("txtCode"); // NOI18N
        getContentPane().add(txtCode);
        txtCode.setBounds(160, 210, 150, 20);

        cmbManufacturer.setName("cmbManufacturer"); // NOI18N
        getContentPane().add(cmbManufacturer);
        cmbManufacturer.setBounds(430, 270, 150, 20);

        cmbCategory.setName("cmbCategory"); // NOI18N
        getContentPane().add(cmbCategory);
        cmbCategory.setBounds(160, 270, 150, 20);

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("MANUFACTURER");
        jLabel16.setName(""); // NOI18N
        getContentPane().add(jLabel16);
        jLabel16.setBounds(325, 270, 100, 20);

        btnAdd.setText("ADD");
        btnAdd.setName("btnAdd"); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd);
        btnAdd.setBounds(260, 380, 141, 35);
        getContentPane().add(panel);
        panel.setBounds(60, 160, 530, 140);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BG.jpg"))); // NOI18N
        getContentPane().add(jLabel14);
        jLabel14.setBounds(0, 0, 650, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBackActionPerformed
    {//GEN-HEADEREND:event_btnBackActionPerformed
        ManageStocks frame = new ManageStocks();
        frame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAddActionPerformed
    {//GEN-HEADEREND:event_btnAddActionPerformed
        boolean validDescription = (!txtDescription.getText().equals("") && txtDescription.getText().trim().length() != 0);
        
        Pattern p = Pattern.compile("[0-9]+([,.][0-9]{1,2})?");
        Matcher matcher = p.matcher(txtPrice.getText());
        
        boolean validPrice = matcher.matches();
        
        boolean validCategory = (cmbCategory.getSelectedIndex() != 0);
        boolean validManufacturer = (cmbManufacturer.getSelectedIndex() != 0);
        
        if (!validDescription)
        {
            txtDescription.setBorder(BorderFactory.createLineBorder(Color.RED));
            txtDescription.setText("");
        }
        else
        {
            txtDescription.setBorder(defaultTextBorder);
        }
        
        if (!validPrice)
        {
            txtPrice.setBorder(BorderFactory.createLineBorder(Color.RED));
            txtPrice.setText("");
        }
        else
        {
            txtPrice.setBorder(defaultTextBorder);
        }
        
        if (!validCategory)
        {
            cmbCategory.setBorder(BorderFactory.createLineBorder(Color.RED));
        }
        else
        {
            cmbCategory.setBorder(defaultCmbBorder);
        }
        
        if (!validManufacturer)
        {
            cmbManufacturer.setBorder(BorderFactory.createLineBorder(Color.RED));
        }
        else
        {
            cmbManufacturer.setBorder(defaultCmbBorder);
        }
        
        if (validCategory && validDescription && validManufacturer &&  validPrice)
        {
            int StationeryCode = Integer.parseInt(txtCode.getText());
            String description = txtDescription.getText();
            int categoryID = cmbCategory.getSelectedIndex() + 1;
            int quantity = 0;
            Double price = Double.parseDouble(txtPrice.getText());
            int manufacturerID = cmbManufacturer.getSelectedIndex() + 1;   
            
            try
            {
                Stationery.AddStationery(categoryID, description, quantity, price, manufacturerID);
                
                ManageStocks form = new ManageStocks();
                form.setVisible(true);
                this.setVisible(false);
            } catch (SQLException ex)
            {
                Logger.getLogger(AddStocks.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex)
            {
                Logger.getLogger(AddStocks.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    Border defaultTextBorder, defaultCmbBorder;
    
    private void formWindowActivated(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowActivated
    {//GEN-HEADEREND:event_formWindowActivated
        panel.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.7f));
        
        cmbCategory.removeAll();
        cmbManufacturer.removeAll();
        
        defaultTextBorder = txtCode.getBorder();
        defaultCmbBorder = cmbCategory.getBorder();
        
        try
        {
            txtCode.setText(Integer.toString(Stationery.GetLastStationeryCode()));
            
            List<Category> categories = Category.GetCategories();

            cmbCategory.addItem("-");

            for (Category category : categories)
            {
                cmbCategory.addItem(category.getDescription());
            }
            
            List<Manufacturer> manufacturers = Manufacturer.GetManufacturers();

            cmbManufacturer.addItem("-");

            for (Manufacturer manufacturer : manufacturers)
            {
                cmbManufacturer.addItem(manufacturer.getName());
            }
        } catch (SQLException ex)
        {
            Logger.getLogger(ManageStocks.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(ManageStocks.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(AddStocks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(AddStocks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(AddStocks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(AddStocks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new AddStocks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JComboBox<String> cmbCategory;
    private javax.swing.JComboBox<String> cmbManufacturer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}

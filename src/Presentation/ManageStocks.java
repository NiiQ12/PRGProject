/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.print.Collation;
import javax.swing.table.DefaultTableModel;
import BusinessLogic.Category;
import BusinessLogic.Stationery;
import BusinessLogic.StationeryCodeSort;
import BusinessLogic.StationeryDescriptionSort;
import BusinessLogic.StationeryStockSort;
import javax.swing.JOptionPane;

/**
 *
 * @author Nicky
 */
public class ManageStocks extends javax.swing.JFrame
{

    /**
     * Creates new form ManageStocks
     */
    public ManageStocks()
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblStocks = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnDeleteStock = new javax.swing.JButton();
        btnOrderStock = new javax.swing.JButton();
        btnUpdateStock = new javax.swing.JButton();
        txtSearchDescription = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbSort = new javax.swing.JComboBox<>();
        cmbSearchCategory = new javax.swing.JComboBox<>();
        btnAddStock = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(650, 500));
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowActivated(java.awt.event.WindowEvent evt)
            {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        tblStocks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Code", "Category", "Description", "Stock", "Price", "Manufacturer"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, false, false
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
        tblStocks.setName("tblStocks"); // NOI18N
        tblStocks.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblStocks);
        if (tblStocks.getColumnModel().getColumnCount() > 0)
        {
            tblStocks.getColumnModel().getColumn(0).setPreferredWidth(10);
            tblStocks.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblStocks.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblStocks.getColumnModel().getColumn(3).setPreferredWidth(10);
            tblStocks.getColumnModel().getColumn(4).setPreferredWidth(10);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 130, 600, 260);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setText("MANAGE STOCKS");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(320, 20, 190, 29);

        btnSearch.setText("SEARCH");
        btnSearch.setName("btnSearch"); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch);
        btnSearch.setBounds(190, 70, 90, 50);

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

        btnDeleteStock.setText("DELETE STOCK");
        btnDeleteStock.setName("btnDeleteStock"); // NOI18N
        btnDeleteStock.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnDeleteStockActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeleteStock);
        btnDeleteStock.setBounds(500, 400, 120, 35);

        btnOrderStock.setText("ORDER STOCK");
        btnOrderStock.setName("btnOrderStock"); // NOI18N
        btnOrderStock.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnOrderStockActionPerformed(evt);
            }
        });
        getContentPane().add(btnOrderStock);
        btnOrderStock.setBounds(20, 400, 130, 35);

        btnUpdateStock.setText("UPDATE STOCK");
        btnUpdateStock.setName("btnUpdateStock"); // NOI18N
        btnUpdateStock.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnUpdateStockActionPerformed(evt);
            }
        });
        getContentPane().add(btnUpdateStock);
        btnUpdateStock.setBounds(340, 400, 130, 35);

        txtSearchDescription.setName("txtSearchDescription"); // NOI18N
        getContentPane().add(txtSearchDescription);
        txtSearchDescription.setBounds(20, 100, 150, 20);

        jLabel3.setText("SORT BY :");
        jLabel3.setName(""); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(360, 70, 70, 20);

        jLabel4.setText("CATEGORY :");
        jLabel4.setName(""); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(360, 100, 80, 20);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("DESCRIPTION");
        jLabel5.setName(""); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 70, 120, 30);

        cmbSort.setName("cmbSort"); // NOI18N
        cmbSort.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cmbSortActionPerformed(evt);
            }
        });
        getContentPane().add(cmbSort);
        cmbSort.setBounds(470, 70, 150, 20);

        cmbSearchCategory.setName("cmbSearchCategory"); // NOI18N
        cmbSearchCategory.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cmbSearchCategoryActionPerformed(evt);
            }
        });
        getContentPane().add(cmbSearchCategory);
        cmbSearchCategory.setBounds(470, 100, 150, 20);

        btnAddStock.setText("ADD STOCK");
        btnAddStock.setName("btnAddStock"); // NOI18N
        btnAddStock.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddStockActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddStock);
        btnAddStock.setBounds(180, 400, 130, 35);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BG.jpg"))); // NOI18N
        getContentPane().add(jLabel15);
        jLabel15.setBounds(0, 0, 650, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSearchActionPerformed
    {//GEN-HEADEREND:event_btnSearchActionPerformed
        String description = txtSearchDescription.getText();
        int categoryID = cmbSearchCategory.getSelectedIndex();

        try
        {
            SetTableValues(description, categoryID);
        } catch (SQLException ex)
        {
            Logger.getLogger(ManageStocks.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(ManageStocks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBackActionPerformed
    {//GEN-HEADEREND:event_btnBackActionPerformed
        AdminMain frame = new AdminMain();
        frame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnOrderStockActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnOrderStockActionPerformed
    {//GEN-HEADEREND:event_btnOrderStockActionPerformed
        OrderStocks form = new OrderStocks();
        form.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnOrderStockActionPerformed

    private void btnUpdateStockActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnUpdateStockActionPerformed
    {//GEN-HEADEREND:event_btnUpdateStockActionPerformed
        if (tblStocks.getSelectedRow() >= 0)
        {
            int selectedRowIndex = tblStocks.getSelectedRow();
            int selectedCode = (int) tblStocks.getValueAt(selectedRowIndex, 0);

            Stationery s = new Stationery();

            for (Stationery stationery : stationeries)
            {
                if (stationery.getStationeryCode() == selectedCode)
                {
                    s = stationery;
                }
            }

            UpdateStocks frame = new UpdateStocks(s);
            frame.setVisible(true);
            this.setVisible(false);
        } else
        {
            JOptionPane.showMessageDialog(null, "Select an item to be updated!");
        }
    }//GEN-LAST:event_btnUpdateStockActionPerformed

    private void btnDeleteStockActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnDeleteStockActionPerformed
    {//GEN-HEADEREND:event_btnDeleteStockActionPerformed
        if (tblStocks.getSelectedRow() >= 0)
        {
            int selectedRowIndex = tblStocks.getSelectedRow();
            int selectedCode = (int) tblStocks.getValueAt(selectedRowIndex, 0);

            int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete item " + selectedCode + "?");

            if (answer == JOptionPane.YES_OPTION)
            {
                try
                {
                    Stationery.DeleteStationery(selectedCode);

                    String description = txtSearchDescription.getText();
                    int categoryID = cmbSearchCategory.getSelectedIndex();
                    SetTableValues(description, categoryID);
                } catch (SQLException ex)
                {
                    Logger.getLogger(ManageStocks.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex)
                {
                    Logger.getLogger(ManageStocks.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else
        {
            JOptionPane.showMessageDialog(null, "Select an item to be deleted!");
        }
    }//GEN-LAST:event_btnDeleteStockActionPerformed

    private void btnAddStockActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAddStockActionPerformed
    {//GEN-HEADEREND:event_btnAddStockActionPerformed
        AddStocks frame = new AddStocks();
        frame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAddStockActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        cmbSort.removeAllItems();
        cmbSearchCategory.removeAllItems();

        cmbSort.addItem("Code");
        cmbSort.addItem("Stock");
        cmbSort.addItem("Description");

        try
        {
            List<Category> categories = Category.GetCategories();

            cmbSearchCategory.addItem("ALL");

            for (Category category : categories)
            {
                cmbSearchCategory.addItem(category.getDescription());
            }

            SetTableValues("", 0);
        } catch (SQLException ex)
        {
            Logger.getLogger(ManageStocks.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(ManageStocks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowActivated

    private void cmbSortActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cmbSortActionPerformed
    {//GEN-HEADEREND:event_cmbSortActionPerformed
        String description = txtSearchDescription.getText();
        int categoryID = cmbSearchCategory.getSelectedIndex();

        try
        {
            SetTableValues(description, categoryID);
        } catch (SQLException ex)
        {
            Logger.getLogger(ManageStocks.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(ManageStocks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbSortActionPerformed

    private void cmbSearchCategoryActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cmbSearchCategoryActionPerformed
    {//GEN-HEADEREND:event_cmbSearchCategoryActionPerformed
        String description = txtSearchDescription.getText();
        int categoryID = cmbSearchCategory.getSelectedIndex();

        try
        {
            SetTableValues(description, categoryID);
        } catch (SQLException ex)
        {
            Logger.getLogger(ManageStocks.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(ManageStocks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbSearchCategoryActionPerformed

    List<Stationery> stationeries;

    private void SetTableValues(String description, int categoryID) throws SQLException, ClassNotFoundException
    {
        DefaultTableModel model = (DefaultTableModel) tblStocks.getModel();
        model.setRowCount(0);

        stationeries = Stationery.GetStationery(description, categoryID);

        switch (cmbSort.getSelectedIndex())
        {
            case 0:
                Collections.sort(stationeries, new StationeryCodeSort());
                break;
            case 1:
                Collections.sort(stationeries, new StationeryStockSort());
                break;
            case 2:
                Collections.sort(stationeries, new StationeryDescriptionSort());
                break;
            default:
                break;
        }

        Object[] rowData = new Object[6];

        for (int i = 0; i < stationeries.size(); i++)
        {
            rowData[0] = stationeries.get(i).getStationeryCode();
            rowData[1] = stationeries.get(i).getCategory();
            rowData[2] = stationeries.get(i).getDescription();
            rowData[3] = stationeries.get(i).getStock();
            rowData[4] = stationeries.get(i).getPrice();
            rowData[5] = stationeries.get(i).getManufacturer();

            model.addRow(rowData);
        }
    }

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
            java.util.logging.Logger.getLogger(ManageStocks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ManageStocks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ManageStocks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ManageStocks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new ManageStocks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddStock;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeleteStock;
    private javax.swing.JButton btnOrderStock;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdateStock;
    private javax.swing.JComboBox<String> cmbSearchCategory;
    private javax.swing.JComboBox<String> cmbSort;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblStocks;
    private javax.swing.JTextField txtSearchDescription;
    // End of variables declaration//GEN-END:variables
}

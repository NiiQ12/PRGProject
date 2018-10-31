/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import BusinessLogic.Administrator;
import BusinessLogic.Order;
import BusinessLogic.OrderDetail;
import BusinessLogic.Stationery;
import DataAccess.DataHandler;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nicky
 */
public class OrderStocks extends javax.swing.JFrame
{

    /**
     * Creates new form OrderStocks
     */
    public OrderStocks()
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

        cmbStationery = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStationery = new javax.swing.JTable();
        btnRemoveItem = new javax.swing.JButton();
        btnClearItems = new javax.swing.JButton();
        btnPlaceOrder = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(650, 500));
        setMinimumSize(new java.awt.Dimension(650, 500));
        setPreferredSize(new java.awt.Dimension(650, 500));
        setSize(new java.awt.Dimension(650, 500));
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowActivated(java.awt.event.WindowEvent evt)
            {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        cmbStationery.setName("cmbStationery"); // NOI18N
        cmbStationery.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cmbStationeryActionPerformed(evt);
            }
        });
        getContentPane().add(cmbStationery);
        cmbStationery.setBounds(230, 80, 260, 20);

        jLabel3.setText("STATIONERY : ");
        jLabel3.setName(""); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(140, 80, 90, 20);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setText("ORDER STOCKS");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(320, 20, 190, 29);

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
        btnAdd.setBounds(530, 80, 90, 20);

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

        tblStationery.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Code", "Category", "Description", "Quantity", "Price", "Manufacturer"
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
        tblStationery.setName("tblStationery"); // NOI18N
        tblStationery.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblStationery.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                tblStationeryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStationery);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 110, 590, 280);

        btnRemoveItem.setActionCommand("REMOVE ITEM");
        btnRemoveItem.setLabel("REMOVE ITEM");
        btnRemoveItem.setName("btnRemoveItem"); // NOI18N
        btnRemoveItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnRemoveItemActionPerformed(evt);
            }
        });
        getContentPane().add(btnRemoveItem);
        btnRemoveItem.setBounds(190, 400, 130, 35);

        btnClearItems.setLabel("CLEAR ITEMS");
        btnClearItems.setName("btnClearItems"); // NOI18N
        btnClearItems.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnClearItemsActionPerformed(evt);
            }
        });
        getContentPane().add(btnClearItems);
        btnClearItems.setBounds(30, 400, 130, 35);

        btnPlaceOrder.setActionCommand("PLACE ORDER");
        btnPlaceOrder.setLabel("PLACE ORDER");
        btnPlaceOrder.setName("btnPlaceOrder"); // NOI18N
        btnPlaceOrder.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnPlaceOrderActionPerformed(evt);
            }
        });
        getContentPane().add(btnPlaceOrder);
        btnPlaceOrder.setBounds(500, 400, 120, 35);

        lblTotal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(255, 255, 255));
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblTotal.setText("R 0.00");
        lblTotal.setName("lblTotal"); // NOI18N
        getContentPane().add(lblTotal);
        lblTotal.setBounds(370, 414, 120, 20);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("TOTAL");
        jLabel6.setName("lbl"); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(430, 400, 60, 14);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BG.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 650, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    ArrayList<Stationery> stationery = new ArrayList<>();

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAddActionPerformed
    {//GEN-HEADEREND:event_btnAddActionPerformed
        String description = cmbStationery.getSelectedItem().toString();
        boolean validQuantity = false;

        int quantity = 0;
        String answer = "";

        answer = JOptionPane.showInputDialog("How Many Would You Like To Order?");

        if (answer == null)
        {
            validQuantity = false;
        } else if (answer.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Invalid Value");
            validQuantity = false;
        } else
        {
            quantity = Integer.parseInt(answer);
            validQuantity = true;
        }

        if (validQuantity)
        {
            boolean alreadyOrdered = false;
            int index = 0;

            if (!stationery.isEmpty())
            {
                for (int i = 0; i < stationery.size(); i++)
                {
                    if (stationery.get(i).getDescription().equals(description))
                    {
                        alreadyOrdered = true;
                        index = i;
                    }
                }
            }

            if (alreadyOrdered)
            {
                if (JOptionPane.showConfirmDialog(null, "You Already Added " + stationery.get(index).getQuantity() + " '" + stationery.get(index).getDescription() + "' Are You Sure You Want To Add " + quantity + " More?", "WARNING",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                {
                    stationery.get(index).setQuantity(stationery.get(index).getQuantity() + quantity);
                }
            } else
            {
                try
                {
                    stationery.add(Stationery.GetStationery(description, 0).get(0));
                    stationery.get(stationery.size() - 1).setQuantity(quantity);
                } catch (SQLException ex)
                {
                    Logger.getLogger(OrderStocks.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex)
                {
                    Logger.getLogger(OrderStocks.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            alreadyOrdered = false;

            PopulateTable();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void PopulateTable()
    {
        DefaultTableModel model = (DefaultTableModel) tblStationery.getModel();
        model.setRowCount(0);

        Object[] rowData = new Object[6];

        for (int i = 0; i < stationery.size(); i++)
        {
            rowData[0] = stationery.get(i).getStationeryCode();
            rowData[1] = stationery.get(i).getCategory();
            rowData[2] = stationery.get(i).getDescription();
            rowData[3] = stationery.get(i).getQuantity();
            rowData[4] = stationery.get(i).getPrice();
            rowData[5] = stationery.get(i).getManufacturer();

            model.addRow(rowData);
        }

        CalculateTotal();
    }

    private void CalculateTotal()
    {
        double total = 0;

        for (int i = 0; i < stationery.size(); i++)
        {
            total += stationery.get(i).getQuantity() * stationery.get(i).getPrice();
        }

        lblTotal.setText(String.format("%s%1.2f", "R", total));
    }

    private void cmbStationeryActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cmbStationeryActionPerformed
    {//GEN-HEADEREND:event_cmbStationeryActionPerformed

    }//GEN-LAST:event_cmbStationeryActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBackActionPerformed
    {//GEN-HEADEREND:event_btnBackActionPerformed
        ManageStocks frame = new ManageStocks();
        frame.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRemoveItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnRemoveItemActionPerformed
    {//GEN-HEADEREND:event_btnRemoveItemActionPerformed
        if (stationery.size() > 0)
        {
            stationery.remove(rowIndex);
        } else
        {
            JOptionPane.showMessageDialog(null, "No Items Selected", "Warning!", JOptionPane.WARNING_MESSAGE);
        }

        PopulateTable();
    }//GEN-LAST:event_btnRemoveItemActionPerformed

    private void ClearTable()
    {
        DefaultTableModel model = (DefaultTableModel) tblStationery.getModel();
        model.setRowCount(0);

        stationery.clear();
        
        lblTotal.setText("R 0.00");
    }

    private void btnClearItemsActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnClearItemsActionPerformed
    {//GEN-HEADEREND:event_btnClearItemsActionPerformed
        if (tblStationery.getRowCount() > 0)
        {
            ClearTable();
        } else
        {
            JOptionPane.showMessageDialog(null, "Table Is Empty", "Warning!", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnClearItemsActionPerformed

    private void btnPlaceOrderActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnPlaceOrderActionPerformed
    {//GEN-HEADEREND:event_btnPlaceOrderActionPerformed
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);

        List<OrderDetail> orderDetails = new ArrayList<>();

        Order order = new Order(0, date, Administrator.loggedInAdminID, null);
        
        for (int i = 0; i < stationery.size(); i++)
        {
            orderDetails.add(new OrderDetail(0, stationery.get(i).getStationeryCode(), stationery.get(i).getQuantity()));
        }

        order.setOrderDetails(orderDetails);
        
        try
        {
            order.AddOrder();
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(OrderStocks.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex)
        {
            Logger.getLogger(OrderStocks.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ClearTable();
    }//GEN-LAST:event_btnPlaceOrderActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowActivated
    {//GEN-HEADEREND:event_formWindowActivated

        List<String> descriptions = new ArrayList<>();
        try
        {
            descriptions = Stationery.GetStationeryDescriptions();

        } catch (SQLException ex)
        {
            Logger.getLogger(OrderStocks.class
                    .getName()).log(Level.SEVERE, null, ex);

        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(OrderStocks.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        if (cmbStationery.getItemCount() == 0)
        {
            for (int i = 0; i < descriptions.size(); i++)
            {
                cmbStationery.addItem(descriptions.get(i));
            }
        }
    }//GEN-LAST:event_formWindowActivated

    int rowIndex;

    private void tblStationeryMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_tblStationeryMouseClicked
    {//GEN-HEADEREND:event_tblStationeryMouseClicked
        if (tblStationery.getSelectedRow() >= 0)
        {
            rowIndex = tblStationery.getSelectedRow();
        }
    }//GEN-LAST:event_tblStationeryMouseClicked

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
            java.util.logging.Logger.getLogger(OrderStocks.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(OrderStocks.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(OrderStocks.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(OrderStocks.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new OrderStocks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClearItems;
    private javax.swing.JButton btnPlaceOrder;
    private javax.swing.JButton btnRemoveItem;
    private javax.swing.JComboBox<String> cmbStationery;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblStationery;
    // End of variables declaration//GEN-END:variables
}

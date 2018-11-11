/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import BusinessLogic.IRequest;
import BusinessLogic.Request;
import BusinessLogic.RequestDetail;
import BusinessLogic.RequestType;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
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
public class ManageRequests_Staff extends javax.swing.JFrame
{
    /**
     * Creates new form OrderStocks
     */
    public ManageRequests_Staff() throws RemoteException, NotBoundException
    {
        initComponents();
        this.setLocationRelativeTo(null);

        requests = new ArrayList<>();
        requestDetails = new ArrayList<>();

        Registry r = LocateRegistry.getRegistry("localhost", 420);
        ir = (IRequest) r.lookup("Request");
    }

    IRequest ir;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        cmbView = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRequestDetails = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRequests = new javax.swing.JTable();
        btnCancelRequest = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtTotalItems = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(650, 500));
        setSize(new java.awt.Dimension(650, 500));
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowActivated(java.awt.event.WindowEvent evt)
            {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        cmbView.setName("cmbView"); // NOI18N
        cmbView.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cmbViewActionPerformed(evt);
            }
        });
        getContentPane().add(cmbView);
        cmbView.setBounds(230, 80, 260, 20);

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
        if (tblRequestDetails.getColumnModel().getColumnCount() > 0)
        {
            tblRequestDetails.getColumnModel().getColumn(0).setMinWidth(100);
            tblRequestDetails.getColumnModel().getColumn(0).setMaxWidth(100);
            tblRequestDetails.getColumnModel().getColumn(1).setMinWidth(100);
            tblRequestDetails.getColumnModel().getColumn(1).setMaxWidth(100);
            tblRequestDetails.getColumnModel().getColumn(4).setMinWidth(100);
            tblRequestDetails.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 260, 590, 140);

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
        if (tblRequests.getColumnModel().getColumnCount() > 0)
        {
            tblRequests.getColumnModel().getColumn(0).setMinWidth(100);
            tblRequests.getColumnModel().getColumn(0).setMaxWidth(100);
            tblRequests.getColumnModel().getColumn(4).setMinWidth(100);
            tblRequests.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(30, 110, 590, 140);

        btnCancelRequest.setText("CANCEL REQUEST");
        btnCancelRequest.setName("btnCancelRequest"); // NOI18N
        btnCancelRequest.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCancelRequestActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelRequest);
        btnCancelRequest.setBounds(250, 410, 180, 35);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("TOTAL ITEMS : ");
        jLabel6.setName("lbl"); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(480, 410, 100, 20);

        txtTotalItems.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTotalItems.setForeground(new java.awt.Color(255, 255, 255));
        txtTotalItems.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        txtTotalItems.setText("___");
        txtTotalItems.setToolTipText("");
        txtTotalItems.setName("lblTotal"); // NOI18N
        getContentPane().add(txtTotalItems);
        txtTotalItems.setBounds(500, 410, 110, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BG.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 650, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    RequestType rt = RequestType.All;

    private void cmbViewActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cmbViewActionPerformed
    {//GEN-HEADEREND:event_cmbViewActionPerformed
        txtTotalItems.setText("___");

        ClearRequestDetailsTable();

        switch (cmbView.getSelectedIndex())
        {
            case 0:
                rt = RequestType.All;
                break;
            case 1:
                rt = RequestType.Completed;
                break;
            case 2:
                rt = RequestType.Uncompleted;
                break;
        }

        try
        {
            SetRequestsTableValues();
        } catch (SQLException ex)
        {
            Logger.getLogger(ManageRequests_Staff.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(ManageRequests_Staff.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex)
        {
            Logger.getLogger(ManageRequests_Staff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cmbViewActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBackActionPerformed
    {//GEN-HEADEREND:event_btnBackActionPerformed
        try
        {
            StaffMain frame = new StaffMain();
            frame.setVisible(true);
            this.setVisible(false);
        } catch (RemoteException ex)
        {
            Logger.getLogger(AddStocks.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex)
        {
            Logger.getLogger(AddStocks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCancelRequestActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCancelRequestActionPerformed
    {//GEN-HEADEREND:event_btnCancelRequestActionPerformed
        int rowIndex = tblRequests.getSelectedRow();

        if (rowIndex >= 0)
        {
            if (tblRequests.getValueAt(rowIndex, 1) == null)
            {
                int requestID = (int) tblRequests.getValueAt(rowIndex, 0);

                int answer = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel request " + requestID + "?");

                if (answer == JOptionPane.OK_OPTION)
                {
                    try
                    {
                        Request requestToCancel = new Request();

                        for (Request request : requests)
                        {
                            if (request.getRequestID() == requestID)
                            {
                                requestToCancel = request;
                            }
                        }

                        requestToCancel.setRequestDetails(requestDetails);

                        ir.CancelRequest(requestToCancel);

                        SetRequestsTableValues();
                        ClearRequestDetailsTable();
                    } catch (SQLException ex)
                    {
                        Logger.getLogger(ManageRequests_Staff.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex)
                    {
                        Logger.getLogger(ManageRequests_Staff.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (RemoteException ex)
                    {
                        Logger.getLogger(ManageRequests_Staff.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } else
            {
                JOptionPane.showMessageDialog(null, "This request has already been completed!");
            }
        } else
        {
            JOptionPane.showMessageDialog(null, "Select a request to be cancelled!");
        }
    }//GEN-LAST:event_btnCancelRequestActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowActivated
    {//GEN-HEADEREND:event_formWindowActivated
        cmbView.removeAllItems();

        cmbView.addItem("ALL REQUESTS");
        cmbView.addItem("COMPLETED REQUESTS");
        cmbView.addItem("UNCOMPLETED REQUESTS");

        try
        {
            SetRequestsTableValues();
        } catch (SQLException ex)
        {
            Logger.getLogger(ManageRequests_Staff.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(ManageRequests_Staff.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex)
        {
            Logger.getLogger(ManageRequests_Staff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowActivated

    private void tblRequestsMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_tblRequestsMouseClicked
    {//GEN-HEADEREND:event_tblRequestsMouseClicked
        if (tblRequests.getSelectedRow() >= 0)
        {
            try
            {
                SetRequestDetailsTableValues();

                int total = 0;

                for (int i = 0; i < tblRequestDetails.getRowCount(); i++)
                {
                    total += (int) tblRequestDetails.getValueAt(i, 4);
                }

                txtTotalItems.setText(Integer.toString(total));
            } catch (SQLException ex)
            {
                Logger.getLogger(ManageRequests_Staff.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex)
            {
                Logger.getLogger(ManageRequests_Staff.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_tblRequestsMouseClicked

    List<Request> requests;

    private void SetRequestsTableValues() throws SQLException, ClassNotFoundException, RemoteException
    {
        requests = ir.GetRequests(rt);

        DefaultTableModel model = (DefaultTableModel) tblRequests.getModel();
        model.setRowCount(0);

        Object[] rowData = new Object[5];

        for (int i = 0; i < requests.size(); i++)
        {
            rowData[0] = requests.get(i).getRequestID();
            rowData[1] = requests.get(i).getAdminID();
            rowData[2] = requests.get(i).getRequestDate();
            rowData[3] = requests.get(i).getReceiveDate();
            rowData[4] = requests.get(i).isRequestAccepted();

            model.addRow(rowData);
        }
    }

    List<RequestDetail> requestDetails;

    private void SetRequestDetailsTableValues() throws SQLException, ClassNotFoundException
    {
        requestDetails.clear();

        int rowIndex = tblRequests.getSelectedRow();
        int requestID = requests.get(rowIndex).getRequestID();

        for (RequestDetail requestDetail : requests.get(rowIndex).getRequestDetails())
        {
            if (requestDetail.getId() == requestID)
            {
                requestDetails.add(requestDetail);
            }
        }

        DefaultTableModel model = (DefaultTableModel) tblRequestDetails.getModel();
        model.setRowCount(0);

        Object[] rowData = new Object[5];

        for (int i = 0; i < requestDetails.size(); i++)
        {
            rowData[0] = requestDetails.get(i).getId();
            rowData[1] = requestDetails.get(i).getStationeryCode();
            rowData[2] = requestDetails.get(i).getCategory();
            rowData[3] = requestDetails.get(i).getDescription();
            rowData[4] = requestDetails.get(i).getQuantity();

            model.addRow(rowData);
        }
    }

    private void ClearRequestDetailsTable()
    {
        DefaultTableModel model = (DefaultTableModel) tblRequestDetails.getModel();
        model.setRowCount(0);
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
            java.util.logging.Logger.getLogger(ManageRequests_Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(ManageRequests_Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(ManageRequests_Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(ManageRequests_Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                try
                {
                    new ManageRequests_Staff().setVisible(true);
                } catch (RemoteException ex)
                {
                    Logger.getLogger(ManageRequests_Staff.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NotBoundException ex)
                {
                    Logger.getLogger(ManageRequests_Staff.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCancelRequest;
    private javax.swing.JComboBox<String> cmbView;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblRequestDetails;
    private javax.swing.JTable tblRequests;
    private javax.swing.JLabel txtTotalItems;
    // End of variables declaration//GEN-END:variables
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import myclass.HoaDon;

/**
 *
 * @author Hunter95
 */
public class frmQLDoanhThu extends javax.swing.JFrame {
    private final HoaDon hd = new HoaDon();  
    private final DefaultTableModel tableModel = new DefaultTableModel(); 
    private final DefaultTableModel tableModel1 = new DefaultTableModel();
    /**
     * Creates new form frmQLDoanhThu
     */
    public frmQLDoanhThu() throws SQLException {
        initComponents();
         String []colsName = {"Số HD","Ngày lập","Tổng tiền","Giảm giá","Thuế","Thành tiền","ID bán"};
        tableModel.setColumnIdentifiers(colsName); 
        
        jTable_hoadon.setModel(tableModel);
        ShowData();
    }
    
    public final void ShowData() throws SQLException {         
        ResultSet result=null;           
        result = hd.getListHD(); 
        try {   
            ClearData(); 
            while(result.next()){  
                String rows[] = new String[7]; 
                rows[0] = result.getString(1);  
                rows[1] = result.getString(2);  
                rows[2] = result.getString(3);  
                rows[3] = result.getString(4); 
                rows[4] = result.getString(5); 
                rows[5] = result.getString(6); 
                rows[6] = result.getString(7); 
                tableModel.addRow(rows); 
            } 
        }  
        catch (SQLException e) { 
        }  
    }
    
      public void ClearData() throws SQLException{ 
         //Lay chi so dong cuoi cung 
         int n=tableModel.getRowCount()-1; 
         for(int i=n;i>=0;i--) 
            tableModel.removeRow(i);//Remove tung dong          
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_hoadon = new javax.swing.JTable();
        jButton_in = new javax.swing.JButton();
        jButton_xoa = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jComboBox_ngay = new javax.swing.JComboBox();
        jComboBox_thang = new javax.swing.JComboBox();
        jTextField_nam = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton_xuatdoanhthu = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_doanhthungay = new javax.swing.JTable();
        jTextField_tongtien = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setText("Quản Lý Doanh Thu");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Quản lý hóa đơn"));

        jTable_hoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Số HD", "Ngày lập", "Tổng tiền", "Giảm giá", "Thuế", "Thành tiền", "ID bán"
            }
        ));
        jScrollPane1.setViewportView(jTable_hoadon);

        jButton_in.setText("In");
        jButton_in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_inActionPerformed(evt);
            }
        });

        jButton_xoa.setText("Xóa");
        jButton_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_xoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_in)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_xoa)
                        .addGap(57, 57, 57))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_in)
                    .addComponent(jButton_xoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("In doanh thu theo ngày"));

        jComboBox_ngay.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        jComboBox_thang.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jLabel2.setText("Ngày:");

        jLabel3.setText("Tháng:");

        jLabel4.setText("Năm:");

        jButton_xuatdoanhthu.setText("Xuất doanh thu");
        jButton_xuatdoanhthu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_xuatdoanhthuActionPerformed(evt);
            }
        });

        jTable_doanhthungay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable_doanhthungay);

        jLabel5.setText("Tổng Tiền: ");

        jLabel6.setText("VND");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox_ngay, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox_thang, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_xuatdoanhthu))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addGap(21, 21, 21))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_ngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox_thang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_nam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jButton_xuatdoanhthu))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField_tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_xuatdoanhthuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_xuatdoanhthuActionPerformed
        // TODO add your handling code here:
         String []colsName1 = {"ID Hóa Đơn","Tổng Tiền","Giảm Giá","Thuế","Thành Tiền"};
        tableModel1.setColumnIdentifiers(colsName1); 
        jTable_doanhthungay.setModel(tableModel1);
        try {
            ShowData_DoanhThuNgay();
        } catch (SQLException ex) {
            Logger.getLogger(frmQLDoanhThu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_xuatdoanhthuActionPerformed

    private void jButton_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_xoaActionPerformed
        // TODO add your handling code here:
        int t = jTable_hoadon.getSelectedRow();
         if(t==-1)
         {
             JOptionPane.showMessageDialog(this, "Vui lòng chọn hoá đơn cần xoá");
             return ;
         }
         int soHD = Integer.parseInt(tableModel.getValueAt(t, 0).toString());
         
        try {
            hd.xoaHd(soHD);
            tableModel.removeRow(t);
            JOptionPane.showMessageDialog(null, "Xoá thành công");
        } catch (SQLException ex) {
            Logger.getLogger(frmQLDoanhThu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_xoaActionPerformed

    private void jButton_inActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_inActionPerformed
        if(jTable_hoadon.getSelectedRowCount()<=0)
        {
            
        JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn cần in");
        }else
        {
            try {
                int id = Integer.valueOf(jTable_hoadon.getValueAt(jTable_hoadon.getSelectedRow(), 0).toString());
                hd.printInVoice(id);
            } catch (SQLException ex) {
                Logger.getLogger(frmQLDoanhThu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton_inActionPerformed
    public final void ShowData_DoanhThuNgay() throws SQLException {         
        ResultSet result=null;  
        ResultSet price = null;
        if(jTextField_nam.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập năm!");
        }else
        {
            if(checkNumber(jTextField_nam.getText())){
                int ngay = Integer.parseInt(jComboBox_ngay.getSelectedItem().toString());
                int thang = Integer.parseInt(jComboBox_thang.getSelectedItem().toString());
                int nam = Integer.parseInt(jTextField_nam.getText());
                result = hd.getPriceofDay(ngay, thang, nam);
                try {   
                    ClearData_DoanhThuNgay(); 
                    while(result.next()){  
                        String rows[] = new String[5]; 
                        rows[0] = result.getString(1);  
                        rows[1] = result.getString(3);  
                        rows[2] = result.getString(4);  
                        rows[3] = result.getString(5); 
                        rows[4] = result.getString(6);  
                        tableModel1.addRow(rows); 
                    } 
                price = hd.getSumPrice(ngay, thang, nam);
                    try{
                        while(price.next()){
                            jTextField_tongtien.setText(price.getString(1));
                        }
                    }catch(SQLException e){

                    }
                }  
                catch (SQLException e) { 
                }  
            }else
            {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập năm là số!");
                jTextField_nam.setText(null);
            }
           
        }  
    }
      public void ClearData_DoanhThuNgay() throws SQLException{ 
         //Lay chi so dong cuoi cung 
         int n=tableModel1.getRowCount()-1; 
         for(int i=n;i>=0;i--) 
            tableModel1.removeRow(i);//Remove tung dong          
    } 
      public boolean checkNumber(String str){
          try{
              int num = Integer.parseInt(str);
              return true;
          }catch(NumberFormatException e){
              return false;
          }
      }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws SQLException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmQLDoanhThu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmQLDoanhThu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmQLDoanhThu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmQLDoanhThu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        frmQLDoanhThu f = new frmQLDoanhThu(); 
        f.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_in;
    private javax.swing.JButton jButton_xoa;
    private javax.swing.JButton jButton_xuatdoanhthu;
    private javax.swing.JComboBox jComboBox_ngay;
    private javax.swing.JComboBox jComboBox_thang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_doanhthungay;
    private javax.swing.JTable jTable_hoadon;
    private javax.swing.JTextField jTextField_nam;
    private javax.swing.JTextField jTextField_tongtien;
    // End of variables declaration//GEN-END:variables
}

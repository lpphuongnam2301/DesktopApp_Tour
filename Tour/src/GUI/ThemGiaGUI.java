/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import BLL.GiatourBLL;
import DTO.GiaTourDTO;
import static GUI.GiaGUI.table;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author nngia
 */
public class ThemGiaGUI extends javax.swing.JFrame {

    /**
     * Creates new form ThemGiaGUI
     */
    public static int row;
    public ThemGiaGUI() {
        initComponents();
        load();
        setLocationRelativeTo(null);
       // setUndecorated(true);
    }
    public void load(){
        try{
            tentxt.setText(GUI.TourGUI.table.getValueAt(GUI.TourGUI.table.getRowCount()-1,1).toString());
        }catch(Exception e){
            
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        date = new com.toedter.calendar.JDateChooser();
        tentxt = new javax.swing.JTextField();
        btn = new javax.swing.JButton();
        tientxt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        date.setDateFormatString("dd/MM/yyyy");
        getContentPane().add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 178, 40));

        tentxt.setEditable(false);
        getContentPane().add(tentxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 126, 178, 40));

        btn.setText("Xác nhận");
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });
        getContentPane().add(btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 113, 35));
        getContentPane().add(tientxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 178, 40));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel12.setText("Tên tour:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, 30));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel14.setText("Từ ngày:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, -1, 30));

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel15.setText("Số tiền");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, -1, 30));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Thêm giá");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 270, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
        // TODO add your handling code here:
        String tb = "",ngay="";
        double tien=0;
        try{
            if(!date.getDate().after(new Date())){
                tb+="Ngày đã qua.Kiểm tra lại\n";
            }else{
                ngay = new SimpleDateFormat("yyyy-MM-dd").format(date.getDate());
            }
        }catch(Exception e){
            tb+="Ngày không được để trống\n";
        }
       
        if(tientxt.getText().equals("")){
            tb+="Tiền không được để trống\n";
        }else{
            try{
                tien = Double.parseDouble(tientxt.getText().toString());
            }catch(Exception e){
                tb+="Số tiền không hợp lệ\n";
            }
        }
        if(!tb.equals("")){
             JOptionPane.showMessageDialog(null,tb);
        }else{
            int id;
            if(new GiatourBLL().them(new GiaTourDTO(1,GUI.ThemTourGUI.id2,tien,ngay))){
                try{
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.addRow(new Object[]{table.getRowCount(),tien,ngay});
                    table.setModel(model);
                }catch(Exception e){
                   // System.out.println(e);
                }
                JOptionPane.showMessageDialog(null,"Thành công");
                this.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null,"Thất bại");
            }
        }
    }//GEN-LAST:event_btnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(ThemGiaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemGiaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemGiaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemGiaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThemGiaGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JTextField tentxt;
    private javax.swing.JTextField tientxt;
    // End of variables declaration//GEN-END:variables
}
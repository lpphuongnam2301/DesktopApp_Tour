/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BLL.GiatourBLL;
import DTO.GiaTourDTO;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import static javax.swing.ListSelectionModel.SINGLE_SELECTION;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author nngia
 */
public class GiaGUI extends javax.swing.JFrame {

    /**
     * Creates new form GiaGUI
     */   
    public static int row;

    public GiaGUI() {
        initComponents();
        load();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupmenu = new javax.swing.JPopupMenu();
        them = new javax.swing.JMenuItem();
        sua = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        label = new javax.swing.JLabel();

        them.setText("Thêm");
        them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themActionPerformed(evt);
            }
        });
        popupmenu.add(them);

        sua.setText("Sửa");
        sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suaActionPerformed(evt);
            }
        });
        popupmenu.add(sua);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table.setModel(new javax.swing.table.DefaultTableModel(
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 471, 334));

        label.setFont(new java.awt.Font("Times New Roman", 1, 19)); // NOI18N
        label.setForeground(new java.awt.Color(255, 0, 0));
        label.setText("Giá tour:");
        getContentPane().add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 350, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseReleased
        // TODO add your handling code here:
         if(evt.isPopupTrigger()){
            popupmenu.show(this,evt.getX(),evt.getY());
        }
    }//GEN-LAST:event_tableMouseReleased

    private void themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themActionPerformed
        // TODO add your handling code here:
        GUI.ThemTourGUI.id2 = Integer.parseInt(GUI.TourGUI.table.getValueAt(GUI.TourGUI.table.getSelectedRow(),0).toString());
        new ThemGiaGUI().setVisible(true);
    }//GEN-LAST:event_themActionPerformed

    private void suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suaActionPerformed
        // TODO add your handling code here:
        if(this.table.getSelectedRow() < -1){
            JOptionPane.showMessageDialog(null,"Chọn tour cần sửa");
            row = table.getSelectedRow();
        }else{
            new SuaGiaGUI().setVisible(true);
        }
    }//GEN-LAST:event_suaActionPerformed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        // TODO add your handling code here:
        if(evt.isPopupTrigger()){
            popupmenu.show(this,evt.getX(),evt.getY());
        }
    }//GEN-LAST:event_formMouseReleased
    public void load(){
        String[] header = {"#","Giá tour","Từ ngày"};
        DefaultTableModel model = new DefaultTableModel(header,0){
            public boolean isCellEditable(int row,int col){
                return false;
            }
        };
       this.table.setSelectionMode(SINGLE_SELECTION);
        this.table.setModel(model);
        for(GiaTourDTO gia : new GiatourBLL().docdsgia()){
            if(Integer.parseInt(GUI.TourGUI.table.getValueAt(GUI.TourGUI.table.getSelectedRow(),0).toString()) == gia.gettour_id()){
                Object [] data = {gia.getGia_id(),gia.getGia_sotien(),gia.getGia_ngay()};
                model.addRow(data);
            }
        }
        this.table.getColumnModel().getColumn(0).setPreferredWidth(1);
        this.table.getColumnModel().getColumn(1).setPreferredWidth(50);
        this.table.getColumnModel().getColumn(2).setPreferredWidth(100);
        label.setText(label.getText()+" "+GUI.TourGUI.table.getValueAt(GUI.TourGUI.table.getSelectedRow(),1));
    }
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
            java.util.logging.Logger.getLogger(GiaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GiaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GiaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GiaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GiaGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private javax.swing.JPopupMenu popupmenu;
    private javax.swing.JMenuItem sua;
    public static javax.swing.JTable table;
    private javax.swing.JMenuItem them;
    // End of variables declaration//GEN-END:variables
}
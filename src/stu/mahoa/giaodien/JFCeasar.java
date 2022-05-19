package stu.mahoa.giaodien;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import stu.mahoa.dulieu.CeaSar;

public class JFCeasar extends javax.swing.JFrame {

    public JFCeasar() {
        initComponents();
        setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnd = new javax.swing.JButton();
        txtkey = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt2 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt1 = new javax.swing.JTextArea();
        btne = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabel1.setText("CeaSar");

        jLabel2.setText("Key");

        btnd.setText("Decryption");
        btnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndActionPerformed(evt);
            }
        });

        txt2.setColumns(20);
        txt2.setRows(5);
        jScrollPane1.setViewportView(txt2);

        txt1.setColumns(20);
        txt1.setRows(5);
        jScrollPane2.setViewportView(txt1);

        btne.setText("Encryption");
        btne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneActionPerformed(evt);
            }
        });
        btne.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btneKeyPressed(evt);
            }
        });

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnd, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(btne, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtkey, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtkey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btne))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //phương thức mã hóa 
    private void btneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneActionPerformed
        CeaSar a = new CeaSar();//khỏi tạo đối tượng caesar
        StringBuilder sb = new StringBuilder();//khởi tạo lớp StringBuilder để tạo chuỗi
        a.setTextip(txt1.getText().toUpperCase());//lấy giá trị của chuỗi đã nhập vào
        txt2.setText("");
        if (txtkey.getText().equals("")) {//kiểm tra xem đã nhập key hay chưa
            sb.append("vui lòng nhập key");
//            if (sb.length() > 0) {
            txtkey.setBackground(Color.red);//backgruop của ô key sẽ chuyển sang màu đỏ
            txtkey.requestFocus();//trỏ chuột chỉ vào ô key
            JOptionPane.showMessageDialog(this, sb.toString());//hiển thị bảng thông báo vui lòng nhập key
            return;
        } else {
            txtkey.setBackground(Color.white);
            a.setKey(Integer.parseInt(txtkey.getText()));//chuyển key từ gt string sang gt int
            if (a.kiemTraKey() == false) {
                sb.append("nhập sai key");
                JOptionPane.showMessageDialog(this, sb.toString());
                return;
            }

            txt2.append(a.maHoa());//xuất ra kết quả sau khi gọi phương thức mã hóa
        }

    }//GEN-LAST:event_btneActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

    }//GEN-LAST:event_formMouseClicked

    private void btneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btneKeyPressed

    }//GEN-LAST:event_btneKeyPressed

    private void btndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndActionPerformed
        CeaSar b = new CeaSar();
        StringBuilder sb = new StringBuilder();
        b.setTextip(txt2.getText().toUpperCase());
        txt1.setText("");
        if (txtkey.getText().equals("")) {
            sb.append("vui lòng nhập key");

//            if (sb.length() > 0) {
            txtkey.setBackground(Color.red);
            txtkey.requestFocus();
            JOptionPane.showMessageDialog(this, sb.toString());
            return;

        } else {
            txtkey.setBackground(Color.white);
            b.setKey(Integer.parseInt(txtkey.getText()));

            if (b.kiemTraKey() == false) {
                sb.append("nhập sai key");
                JOptionPane.showMessageDialog(this, sb.toString());
                return;
            }

            txt1.append(b.giaiMa());
        }
    }//GEN-LAST:event_btndActionPerformed
    public void close()
{
    WindowEvent closewindow = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closewindow);
    
}
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       close();
        MeNu a = new MeNu();
        a.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(JFCeasar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFCeasar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFCeasar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFCeasar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFCeasar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnd;
    private javax.swing.JButton btne;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txt1;
    private javax.swing.JTextArea txt2;
    private javax.swing.JTextField txtkey;
    // End of variables declaration//GEN-END:variables
}

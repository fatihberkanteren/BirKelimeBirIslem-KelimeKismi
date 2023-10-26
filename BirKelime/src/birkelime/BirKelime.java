package birkelime;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 * Bu sınıf "Bir kelime bir işlem" uygulamasının bir kelime kısmıdır.
 *
 * @author Berkant EREN
 * @version 1.0.0
 *
 */
public class BirKelime extends javax.swing.JFrame {

    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    Random random = new Random();
    char[] alfabe = {'a', 'b', 'c', 'ç', 'd', 'e', 'f', 'g', 'ğ', 'h', 'ı', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'ö', 'p', 'r', 's', 'ş', 't', 'u', 'ü', 'v', 'y', 'z'};
    char[] rastgeleHarfler;
    ArrayList<String> kelimes = null;
    ArrayList<String> bulunanKelimeler;
    DefaultListModel<String> defaultListModel = new DefaultListModel<>();
    JList<String> list = new JList<>(defaultListModel);

    /**
     * Bu metot veritabanına bağlanır ve veritabanındaki kelimeleri ArrayListe
     * aktarır.
     *
     * @return String ArrayList
     * @throws java.sql.SQLException
     */
    public ArrayList<String> getKelime() throws SQLException {
        conn = null;
        Statement statement = null;
        try {
            conn = DbHelper.kys_kelimeler();
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT * FROM kelimeler");
            kelimes = new ArrayList<>();
            while (rs.next()) {
                //System.out.println(rs.getString("kelimeAdi").toLowerCase());
                kelimes.add(rs.getString("kelimeAdi").toLowerCase());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getErrorCode());
        } finally {
            statement.close();
            conn.close();
        }
        return kelimes;
    }

    public BirKelime() throws SQLException {
        initComponents();
        getKelime();
        jList2.setModel(defaultListModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        btn_rastgeleAta = new javax.swing.JButton();
        btn_kelimeleriBul = new javax.swing.JButton();
        btn_temizle = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTextField2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTextField3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTextField4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTextField5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTextField6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTextField7.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTextField8.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTextField9.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btn_rastgeleAta.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btn_rastgeleAta.setText("Rastgele Harf Ata");
        btn_rastgeleAta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rastgeleAtaActionPerformed(evt);
            }
        });

        btn_kelimeleriBul.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btn_kelimeleriBul.setText("Kelimeleri Bul");
        btn_kelimeleriBul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kelimeleriBulActionPerformed(evt);
            }
        });

        btn_temizle.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btn_temizle.setText("Temizle");
        btn_temizle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_temizleActionPerformed(evt);
            }
        });

        jList2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jScrollPane2.setViewportView(jList2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_temizle, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_rastgeleAta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(btn_kelimeleriBul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(btn_rastgeleAta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_kelimeleriBul, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_temizle, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_rastgeleAtaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rastgeleAtaActionPerformed
        rastgeleHarfler = new char[9];
        for (int i = 0; i < rastgeleHarfler.length; i++) {
            rastgeleHarfler[i] = alfabe[random.nextInt(29)];
        }
        jTextField1.setText(String.valueOf(rastgeleHarfler[0]));
        jTextField2.setText(String.valueOf(rastgeleHarfler[1]));
        jTextField3.setText(String.valueOf(rastgeleHarfler[2]));
        jTextField4.setText(String.valueOf(rastgeleHarfler[3]));
        jTextField5.setText(String.valueOf(rastgeleHarfler[4]));
        jTextField6.setText(String.valueOf(rastgeleHarfler[5]));
        jTextField7.setText(String.valueOf(rastgeleHarfler[6]));
        jTextField8.setText(String.valueOf(rastgeleHarfler[7]));
        jTextField9.setText(String.valueOf(rastgeleHarfler[8]));
    }//GEN-LAST:event_btn_rastgeleAtaActionPerformed

    /**
     * Bu metot girilen restgele harflerden uygun kelimeyi bulup listeye
     * aktarıyor
     *
     * @return nothing
     *
     */

    private void btn_kelimeleriBulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kelimeleriBulActionPerformed
        bulunanKelimeler = new ArrayList<>();
        char[] ayrilmisHarfler;
        for (String kelime : kelimes) {
            ayrilmisHarfler = new char[kelime.length()];
            for (int i = 0; i < kelime.length(); i++) {
                ayrilmisHarfler[i] = kelime.charAt(i);
            }
            int num = 0;
            int sayac = 0;

            for (int i = 0; i < kelime.length(); i++) {
                for (int j = 0; j < 9; j++) {
                    if (ayrilmisHarfler[i] == rastgeleHarfler[j]) {
                        num++;
                        if (num == kelime.length()) {
                            bulunanKelimeler.add(kelime);
                            //System.out.println(kelime);
                            sayac++;
                        }
                        break;
                    }
                }
            }
        }
        for (String kelime : bulunanKelimeler) {
            defaultListModel.addElement(kelime);
        }
    }//GEN-LAST:event_btn_kelimeleriBulActionPerformed

    /**
     * Bu metot tüm alanlardaki içeriği temizliyor
     *
     * @return nothing
     *
     */
    private void btn_temizleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_temizleActionPerformed
        defaultListModel.clear();
        jTextField1.setText(null);
        jTextField2.setText(null);
        jTextField3.setText(null);
        jTextField4.setText(null);
        jTextField5.setText(null);
        jTextField6.setText(null);
        jTextField7.setText(null);
        jTextField8.setText(null);
        jTextField9.setText(null);
    }//GEN-LAST:event_btn_temizleActionPerformed

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
            java.util.logging.Logger.getLogger(BirKelime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BirKelime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BirKelime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BirKelime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new BirKelime().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(BirKelime.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_kelimeleriBul;
    private javax.swing.JButton btn_rastgeleAta;
    private javax.swing.JButton btn_temizle;
    private javax.swing.JList<String> jList2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}

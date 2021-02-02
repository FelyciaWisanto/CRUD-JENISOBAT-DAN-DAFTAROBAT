package jenisobat;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class JenisObatGUI extends javax.swing.JFrame {
public Statement st;
    public ResultSet rs;
    boolean edit;
    String sId;
    public DefaultTableModel tabModel;
    Connection cn = TesDB.TesDB();
    public JenisObatGUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        setVisible(true);
        judul();
        tampilData("");
        refresh();
    }

    public void judul() {
    Object[] judul = {"Kode Jenis", "Jenis Obat"};
    tabModel = new DefaultTableModel(null, judul);
    jTable1.setModel(tabModel);
    }
    
    public void refresh(){
    txtKode.setEnabled(false);
    txtJenis.setEnabled(false);
    
    btnTambah.setEnabled(true);
    btnSimpan.setEnabled(false);
    btnEdit.setEnabled(false);
    btnHapus.setEnabled(false);
    btnBatal.setEnabled(true);
    btnSimpan.setText("Simpan");
    
    edit=false;
    }

    public void tampilData(String where) {
    try {
    st = cn.createStatement();
    tabModel.getDataVector().removeAllElements();
    tabModel.fireTableDataChanged();
    rs = st.executeQuery("SELECT * FROM jenisobat " + where);
    while (rs.next()) {
    Object[] data = {
    rs.getString("kodejenis"),
    rs.getString("jenisobat")
    };
    tabModel.addRow(data);
    }
    }catch(Exception e) {
        e.printStackTrace();
    }
    }
    
        private void cariData(String key){
        try{
            st = cn.createStatement();
            tabModel.getDataVector().removeAllElements();
            
            rs =st.executeQuery("SELECT * from jenisobat WHERE kodejenis LIKE '%"+key+"%' OR jenisobat LIKE '%"+key+"%'");  
            while(rs.next()){
                Object[] data={
                rs.getString("kodejenis"),
                rs.getString("jenisobat")
                };
               tabModel.addRow(data);
            }                
        } catch (Exception e) {
        e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtJenis = new javax.swing.JTextField();
        btnBatal = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnTutup = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnTambah = new javax.swing.JButton();
        txtKode = new javax.swing.JTextField();
        txtCari = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 255, 255));
        setForeground(new java.awt.Color(0, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Entri Data Jenis Obat");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Kode Jenis");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Jenis Obat");

        txtJenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJenisActionPerformed(evt);
            }
        });

        btnBatal.setBackground(new java.awt.Color(0, 255, 255));
        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(0, 255, 255));
        btnHapus.setText("Hapus");
        btnHapus.setPreferredSize(new java.awt.Dimension(67, 23));
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(0, 255, 255));
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnSimpan.setBackground(new java.awt.Color(0, 255, 255));
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnTutup.setBackground(new java.awt.Color(0, 255, 255));
        btnTutup.setText("Tutup");
        btnTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutupActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Jenis", "Jenis Obat"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnTambah.setBackground(new java.awt.Color(0, 255, 255));
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        txtKode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKodeActionPerformed(evt);
            }
        });

        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(241, 241, 241)
                        .addComponent(btnTutup)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(62, 62, 62)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtJenis)
                                .addGap(10, 10, 10))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtCari))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(131, 131, 131)
                    .addComponent(txtKode)
                    .addGap(20, 20, 20)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnEdit)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBatal)
                    .addComponent(btnTambah))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTutup)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(62, 62, 62)
                    .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(249, Short.MAX_VALUE)))
        );

        setSize(new java.awt.Dimension(567, 370));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtJenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJenisActionPerformed

    }//GEN-LAST:event_txtJenisActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        refresh();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        try {
            int jawab;
            if ((jawab = JOptionPane.showConfirmDialog(null, "Ingin menghapus data?", "konfirmasi", JOptionPane.YES_NO_OPTION)) == 0) {
            st = cn.createStatement();
            st.executeUpdate("DELETE FROM jenisobat WHERE kodejenis='"+ tabModel.getValueAt(jTable1.getSelectedRow(), 0) + "'");
            tampilData("");
            refresh();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        txtKode.setEnabled(true);
        txtJenis.setEnabled(true);
        
        btnEdit.setText("Update");
        btnTambah.setEnabled(false);
        btnSimpan.setEnabled(false);
        btnEdit.setEnabled(true);
        btnHapus.setEnabled(false);
        btnBatal.setEnabled(true);
        
        try {
        st = cn.createStatement();
            st.executeUpdate("UPDATE jenisobat set kodejenis='"+ txtKode.getText() + "', " + "jenisobat='" + txtJenis.getText() + "' WHERE kodejenis ='" + sId + "' ");
           
            tampilData("");
            refresh();
                JOptionPane.showMessageDialog(null, "Update Berhasil");
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Update Gagal");
        e.printStackTrace();
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        try {
            st = cn.createStatement();
                st.executeUpdate("INSERT INTO jenisobat VALUES ('"+txtKode.getText()+"','"+txtJenis.getText()+"')");
            tampilData("");
            refresh();
                JOptionPane.showMessageDialog(null, "Simpan Berhasil");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Simpan Gagal");
        e.printStackTrace();
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutupActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnTutupActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        sId=(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
        txtJenis.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
        
        txtKode.setText(sId);
        txtKode.setEnabled(true);
        txtJenis.setEnabled(true);
        btnTambah.setEnabled(false);
        btnSimpan.setEnabled(false);
        btnEdit.setText("Update");
        btnEdit.setEnabled(true);
        btnHapus.setEnabled(true);
        btnBatal.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        txtJenis.setEnabled(true);
        txtJenis.setText(" ");
        txtKode.setEnabled(true);
        txtKode.setText(" ");
       
        btnSimpan.setEnabled(true);
        btnEdit.setEnabled(false);
        btnHapus.setEnabled(false);
        btnBatal.setEnabled(true);
        btnSimpan.setText("Simpan");
        
    }//GEN-LAST:event_btnTambahActionPerformed

    private void txtKodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKodeActionPerformed

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        String key=txtCari.getText();
        System.out.println(key);  
        
        if(key!=""){
            cariData(key);
        }else{
            tampilData("");
        }
    }//GEN-LAST:event_txtCariKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnTutup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtJenis;
    private javax.swing.JTextField txtKode;
    // End of variables declaration//GEN-END:variables
}

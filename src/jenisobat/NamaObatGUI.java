package jenisobat;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

public class NamaObatGUI extends javax.swing.JFrame {
    public Statement st;
    public ResultSet rs;
    boolean edit;
    String sId;
    public DefaultTableModel tabModel;
    Connection cn = TesDB.TesDB();
    public NamaObatGUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        setVisible(true);
        judul();
        tampilData("");
        refresh();
        dataFromDataBaseToComboBox();
    }
    
    public void judul() {
    Object[] judul = {"Kode Obat","Nama Obat", "Jenis Obat","Jumlah","Satuan"};
    tabModel = new DefaultTableModel(null, judul);
    jTable3.setModel(tabModel);
    }
    
    public void refresh(){
    txtKode.setEnabled(false);
    cmbJenis.setEnabled(false);
    txtNama.setEnabled(false);
    txtJumlah.setEnabled(false);
    cmbSatuan.setEnabled(false);
    
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
    rs = st.executeQuery("SELECT * FROM daftarobat " + where);
    while (rs.next()) {
    Object[] data = {
    rs.getString("kode"),
    rs.getString("namaobat"),
    rs.getString("jenisobat"),
    rs.getString("jumlah"),
    rs.getString("satuan")
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
            
            rs =st.executeQuery("SELECT * from daftarobat WHERE kode LIKE '%"+key+"%' OR namaobat LIKE '%"+key+"%'");  
            while(rs.next()){
                Object[] data={
                rs.getString("kode"),
                rs.getString("namaobat"),
                rs.getString("jenisobat"),
                rs.getString("jumlah"),
                rs.getString("satuan")
                };
               tabModel.addRow(data);
            }                
        } catch (Exception e) {
        e.printStackTrace();
        }
    }
    public void dataFromDataBaseToComboBox(){
    try {
        st = cn.createStatement();
        rs = st.executeQuery("SELECT * FROM jenisobat ");
        
        cmbJenis.addItem("-Pilih Jenis Obat");
    while (rs.next()) {
        cmbJenis.addItem(rs.getString("jenisobat"));
    }
        rs.last();
        int jumlahdata = rs.getRow();
        rs.first();
        } catch(Exception e) {
            
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtKode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtJumlah = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnTutup = new javax.swing.JButton();
        cmbJenis = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        cmbSatuan = new javax.swing.JComboBox<>();
        txtCari = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 255, 255));
        setForeground(new java.awt.Color(51, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Entri Daftar Obat");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Kode Obat");

        txtKode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKodeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Nama Obat");

        txtNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Jenis Obat");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Jumlah");

        txtJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtJumlahActionPerformed(evt);
            }
        });

        btnTambah.setBackground(new java.awt.Color(0, 255, 255));
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnSimpan.setBackground(new java.awt.Color(0, 255, 255));
        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(0, 255, 255));
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
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

        btnBatal.setBackground(new java.awt.Color(0, 255, 255));
        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnTutup.setBackground(new java.awt.Color(0, 255, 255));
        btnTutup.setText("Tutup");
        btnTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutupActionPerformed(evt);
            }
        });

        cmbJenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbJenisActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Obat", "Nama Obat", "Jenis Obat", "Jumlah"
            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        cmbSatuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Papan", "Sachet", "Botol" }));

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtJumlah, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addComponent(cmbJenis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(425, 425, 425)
                        .addComponent(cmbSatuan, 0, 241, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                        .addComponent(btnTutup))
                    .addComponent(txtCari))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBatal)
                    .addComponent(btnTambah)
                    .addComponent(btnTutup)
                    .addComponent(btnEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtKodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKodeActionPerformed

    private void txtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaActionPerformed

    private void txtJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtJumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtJumlahActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        cmbJenis.setEnabled(true);
        cmbSatuan.setEnabled(true);
        
        txtKode.setEnabled(true);
        txtKode.setText(" ");
        txtNama.setEnabled(true);
        txtNama.setText(" ");
        txtJumlah.setEnabled(true);
        txtJumlah.setText(" ");

        btnSimpan.setEnabled(true);
        btnEdit.setEnabled(false);
        btnHapus.setEnabled(false);
        btnBatal.setEnabled(true);
        btnSimpan.setText("Simpan");

    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        try {
            st = cn.createStatement();
            st.executeUpdate("INSERT INTO daftarobat VALUES ('"+txtKode.getText()+"','"+txtNama.getText()+"','"+cmbJenis.getSelectedItem()+"','"+txtJumlah.getText()+"','"+cmbSatuan.getSelectedItem()+"')");
            tampilData("");
            refresh();
            JOptionPane.showMessageDialog(null, "Simpan Berhasil");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Simpan Gagal");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        txtKode.setEnabled(true);
        cmbJenis.setEnabled(true);
        cmbSatuan.setEnabled(true);
        txtNama.setEnabled(true);
        txtJumlah.setEnabled(true);

        btnEdit.setText("Update");
        btnTambah.setEnabled(false);
        btnSimpan.setEnabled(false);
        btnEdit.setEnabled(true);
        btnHapus.setEnabled(false);
        btnBatal.setEnabled(true);

        try {
            st = cn.createStatement();
            st.executeUpdate("UPDATE daftarobat set kode='"+ txtKode.getText() + "', " + "namaobat='" + txtNama.getText() + "', " + "jenisobat='" + cmbJenis.getSelectedItem()+ "', " + "jumlah='" + txtJumlah.getText()+ "', " + "satuan='" + cmbSatuan.getSelectedItem() + "' WHERE kode ='" + sId + "' ");

            tampilData("");
            refresh();
            JOptionPane.showMessageDialog(null, "Update Berhasil");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Update Gagal");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        try {
            int jawab;
            if ((jawab = JOptionPane.showConfirmDialog(null, "Ingin menghapus data?", "konfirmasi", JOptionPane.YES_NO_OPTION)) == 0) {
                st = cn.createStatement();
                st.executeUpdate("DELETE FROM daftarobat WHERE kode='"+ tabModel.getValueAt(jTable3.getSelectedRow(), 0) + "'");
                tampilData("");
                refresh();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        refresh();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutupActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnTutupActionPerformed

    private void cmbJenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbJenisActionPerformed
        
    }//GEN-LAST:event_cmbJenisActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        sId=(jTable3.getValueAt(jTable3.getSelectedRow(), 0).toString());
        txtNama.setText(jTable3.getValueAt(jTable3.getSelectedRow(), 1).toString());
        txtJumlah.setText(jTable3.getValueAt(jTable3.getSelectedRow(), 3).toString());
        
        txtKode.setText(sId);
        txtKode.setEnabled(true);
        txtNama.setEnabled(true);
        cmbJenis.setEnabled(true);
        txtJumlah.setEnabled(true);
        cmbSatuan.setEnabled(true);
        
        btnTambah.setEnabled(false);
        btnSimpan.setEnabled(false);
        btnEdit.setText("Update");
        btnEdit.setEnabled(true);
        btnHapus.setEnabled(true);
        btnBatal.setEnabled(true);
    }//GEN-LAST:event_jTable3MouseClicked

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
    private javax.swing.JComboBox<String> cmbJenis;
    private javax.swing.JComboBox<String> cmbSatuan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtKode;
    private javax.swing.JTextField txtNama;
    // End of variables declaration//GEN-END:variables
}

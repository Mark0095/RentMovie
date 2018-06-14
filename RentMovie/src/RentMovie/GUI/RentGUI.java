package RentMovie.GUI;

import RentMovie.Control.Mechanics;
import java.util.Date;

public class RentGUI extends javax.swing.JFrame {

    RentMovieGUI rentmoviegui;
    Date date = new Date();
    
    public RentGUI(RentMovieGUI rentmoviegui) {
        this.rentmoviegui = rentmoviegui;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        rentButton = new javax.swing.JButton();
        startRentDate = new org.jdesktop.swingx.JXDatePicker();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kölcsönadás");
        setLocation(new java.awt.Point(637, 510));
        setResizable(false);

        jLabel1.setText("Név:");

        jLabel2.setText("Kölcsönadás dátuma:");

        rentButton.setText("Kölcsönad");
        rentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentButtonActionPerformed(evt);
            }
        });

        startRentDate.setDate(date);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(startRentDate, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(rentButton)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(rentButton)
                    .addComponent(startRentDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentButtonActionPerformed
        Mechanics.rentMovie(Mechanics.getFreeMovieTitles()[rentmoviegui.getFreeFilmBox().getSelectedIndex()], name.getText(), new java.sql.Date(startRentDate.getDate().getTime()), null);
        rentmoviegui.getFreeFilmBox().setModel(new javax.swing.DefaultComboBoxModel<>(Mechanics.getFreeMovieTitles()));
        rentmoviegui.getRentFilmBox().setModel(new javax.swing.DefaultComboBoxModel<>(Mechanics.getRentedMovieTitlesByName()));
        rentmoviegui.getNameBox().setModel(new javax.swing.DefaultComboBoxModel<>(Mechanics.getNames()));
        Mechanics.updateRentMoviesByName((String) rentmoviegui.getNameBox().getSelectedItem());
        rentmoviegui.getRentFilmBox().setModel(new javax.swing.DefaultComboBoxModel<>(Mechanics.getRentedMovieTitlesByName()));
        this.dispose();
    }//GEN-LAST:event_rentButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField name;
    private javax.swing.JButton rentButton;
    private org.jdesktop.swingx.JXDatePicker startRentDate;
    // End of variables declaration//GEN-END:variables
}

package RentMovie.GUI;

import RentMovie.Control.Mechanics;
import java.util.Arrays;
import java.util.Date;

public class BackGUI extends javax.swing.JFrame {

    RentMovieGUI rentmoviegui;
    Date date = new Date();
    
    public BackGUI(RentMovieGUI rentmoviegui) {
        this.rentmoviegui = rentmoviegui;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backDatePick = new org.jdesktop.swingx.JXDatePicker();
        backButton = new javax.swing.JButton();
        backDateLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Visszaadás");
        setLocation(new java.awt.Point(835, 492));
        setResizable(false);

        backDatePick.setDate(date);

        backButton.setText("Visszaad");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        backDateLabel.setText("Visszaadás dátuma:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(backButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backDatePick, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(backDateLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backDateLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backDatePick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        Mechanics.backMovie((String) rentmoviegui.getRentFilmBox().getSelectedItem(), new java.sql.Date(backDatePick.getDate().getTime()));
        rentmoviegui.getFreeFilmBox().setModel(new javax.swing.DefaultComboBoxModel<>(Mechanics.getFreeMovieTitles()));
        if(!Arrays.asList(Mechanics.getNames()).contains((String) rentmoviegui.getNameBox().getSelectedItem())){
            rentmoviegui.getNameBox().setModel(new javax.swing.DefaultComboBoxModel<>(Mechanics.getNames()));
        }
        Mechanics.updateRentMoviesByName((String) rentmoviegui.getNameBox().getSelectedItem());
        rentmoviegui.getRentFilmBox().setModel(new javax.swing.DefaultComboBoxModel<>(Mechanics.getRentedMovieTitlesByName()));
        this.dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel backDateLabel;
    private org.jdesktop.swingx.JXDatePicker backDatePick;
    // End of variables declaration//GEN-END:variables
}

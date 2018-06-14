package RentMovie.GUI;

import RentMovie.Control.Mechanics;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class NewMovieGUI extends JFrame {

    RentMovieGUI rentmoviegui;
    
    public NewMovieGUI(RentMovieGUI rentmoviegui) {
        this.rentmoviegui = rentmoviegui;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        title = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        director = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        actors = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        type = new javax.swing.JTextField();
        time = new javax.swing.JTextField();
        year = new javax.swing.JTextField();
        button = new javax.swing.JButton();
        original = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Új Film");
        setLocation(new java.awt.Point(670, 476));
        setResizable(false);

        jLabel1.setText("Cím:");

        title.setText("");

        jLabel2.setText("Rendező:");

        director.setText("");

        jLabel3.setText("Főszereplő:");

        actors.setText("");

        jLabel4.setText("Gyártási év:");

        jLabel5.setText("Hossz(perc):");

        jLabel6.setText("Típus(DVD/VHS):");

        type.setText("");

        time.setText("");

        year.setText("");

        button.setText("Új film felvétele");
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        original.setText("Eredeti");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(director, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(type, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(actors))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(original)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(director, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(actors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button)
                    .addComponent(original))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed
        try{
            if((type.getText().equals("DVD") || type.getText().equals("VHS")) && !Arrays.asList(Mechanics.getFilmcim()).contains(title.getText())){
                Mechanics.addMovie(title.getText(), director.getText(), actors.getText(), Integer.parseInt(year.getText()), Integer.parseInt(time.getText()), type.getText(), original.isSelected(), 0, true);
                rentmoviegui.getFreeFilmBox().setModel(new javax.swing.DefaultComboBoxModel<>(Mechanics.getFreeMovieTitles()));
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this, "Ez a film már létezik vagy a típust rosszul adta meg!", "Hibás adat", JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "A Gyártási év/Hossz(Perc) nem megfelelő! Kérem ellenőrizze!", "Hibás adatok", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JTextField actors;
    protected javax.swing.JButton button;
    protected javax.swing.JTextField director;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    protected javax.swing.JCheckBox original;
    protected javax.swing.JTextField time;
    protected javax.swing.JTextField title;
    protected javax.swing.JTextField type;
    protected javax.swing.JTextField year;
    // End of variables declaration//GEN-END:variables
}

package RentMovie.GUI;

import RentMovie.GUI.RentMovieGUI;
import RentMovie.Control.Mechanics;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ModifyGUI extends JFrame {

    private int index;
    private String filmnev;
    private RentMovieGUI rentmoviegui;
    
    public ModifyGUI(int index, String filmnev, RentMovieGUI rentmoviegui) {
        this.index = Mechanics.getIndex(Mechanics.getFreeMovieTitles()[index]);
        //System.out.println(Mechanics.getIndex(Mechanics.getFreeMovieTitles()[index]));
        this.filmnev = filmnev;
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
        year = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        time = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        type = new javax.swing.JTextField();
        original = new javax.swing.JCheckBox();
        modifyButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Módosítás");
        setLocation(new java.awt.Point(609, 477));
        setResizable(false);

        jLabel1.setText("Cím:");

        title.setText(Mechanics.getFreeMovieTitles()[rentmoviegui.getFreeFilmBox().getSelectedIndex()]);

        jLabel2.setText("Rendező:");

        director.setText(Mechanics.getRendezo()[index]);

        jLabel3.setText("Főszereplő:");

        actors.setText(Mechanics.getFoszereplo()[index]);

        jLabel4.setText("Gyártási év:");

        year.setText(Integer.toString(Mechanics.getGyartasiev()[index]));

        jLabel5.setText("Hossz(Perc):");

        time.setText(Integer.toString(Mechanics.getHossz()[index]));

        jLabel6.setText("Típus(DVD/VHS):");

        type.setText(Mechanics.getTipus()[index]);

        original.setText("Eredeti");
        original.setSelected(Mechanics.getEredeti().get(index));

        modifyButton.setText("Módosít");
        modifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(year))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(original, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(director, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                            .addComponent(time))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(actors, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(type)))
                    .addComponent(modifyButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {actors, director, title});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(director, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(actors, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modifyButton)
                    .addComponent(original))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyButtonActionPerformed
        try{
            if(type.getText().equals("DVD") || type.getText().equals("VHS")){
                Mechanics.modifyMovie(title.getText(), director.getText(), actors.getText(), Integer.parseInt(year.getText()), Integer.parseInt(time.getText()), type.getText(), original.isSelected(), filmnev);
                rentmoviegui.getFreeFilmBox().setModel(new javax.swing.DefaultComboBoxModel<>(Mechanics.getFreeMovieTitles()));
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(this, "A típushoz DVD/VHS-t adhat meg!", "Hibás adat", JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Az egyik adathoz rossz formátumot adott meg! Kérem ellenőrizze!", "Hibás adatok", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_modifyButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField actors;
    protected javax.swing.JTextField director;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton modifyButton;
    private javax.swing.JCheckBox original;
    private javax.swing.JTextField time;
    protected javax.swing.JTextField title;
    private javax.swing.JTextField type;
    private javax.swing.JTextField year;
    // End of variables declaration//GEN-END:variables
}

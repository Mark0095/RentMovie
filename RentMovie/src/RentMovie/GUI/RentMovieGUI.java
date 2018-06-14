package RentMovie.GUI;

import RentMovie.Control.Mechanics;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class RentMovieGUI extends JFrame {

    public RentMovieGUI() {
        Mechanics.makeConnection();
        Mechanics.adatbazisFeltoltes();
        Mechanics.updateALL();
        initComponents();
        Mechanics.updateRentMoviesByName((String) nameBox.getSelectedItem());
        getRentFilmBox().setModel(new javax.swing.DefaultComboBoxModel<>(Mechanics.getRentedMovieTitlesByName()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panicButton = new javax.swing.JButton();
        rentMovieList = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        freeFilmBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        rentFilmBox = new javax.swing.JComboBox<>();
        backButton = new javax.swing.JButton();
        modifyButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        rentButton = new javax.swing.JButton();
        newMovieButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        nameBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Film kölcsönző");
        setLocation(new java.awt.Point(660, 428));
        setResizable(false);

        panicButton.setText("Pánik!");
        panicButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                panicButtonActionPerformed(evt);
            }
        });

        rentMovieList.setText("Filmek Listázása");
        rentMovieList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentMovieListActionPerformed(evt);
            }
        });

        jLabel1.setText("Szabad Filmek:");

        freeFilmBox.setModel(new javax.swing.DefaultComboBoxModel<>(Mechanics.getFreeMovieTitles()));

        jLabel2.setText("Kölcsönadott Filmek:");

        rentFilmBox.setModel(new javax.swing.DefaultComboBoxModel<>(Mechanics.getRentedMovieTitlesByName()));

        backButton.setText("Visszaadva");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        modifyButton.setText("Módosít");
        modifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Töröl");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        rentButton.setText("Kölcsönad");
        rentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rentButtonActionPerformed(evt);
            }
        });

        newMovieButton.setText("Új film");
        newMovieButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMovieButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Név:");

        nameBox.setModel(new javax.swing.DefaultComboBoxModel<>(Mechanics.getNames()));
        nameBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(rentMovieList)
                            .addGap(154, 154, 154)
                            .addComponent(panicButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(newMovieButton, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(freeFilmBox, 0, 206, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addComponent(nameBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(modifyButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(rentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel2)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(rentFilmBox, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(backButton))))))
                .addGap(0, 35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(freeFilmBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifyButton)
                    .addComponent(deleteButton)
                    .addComponent(rentButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rentFilmBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(backButton))
                    .addComponent(nameBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rentMovieList)
                    .addComponent(panicButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newMovieButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {panicButton, rentMovieList});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        if (Mechanics.getRentedMovieTitles().length != 0) {
            RentMovieGUI gui = this;
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BackGUI(gui).setVisible(true);
            }
            });
            
        }else{
            JOptionPane.showMessageDialog(this, "Jelenleg nincs kölcsönadott film!");
        }
    }//GEN-LAST:event_backButtonActionPerformed

    private void panicButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_panicButtonActionPerformed
        Mechanics.panic();
        getFreeFilmBox().setModel(new javax.swing.DefaultComboBoxModel<>(Mechanics.getFreeMovieTitles()));
    }//GEN-LAST:event_panicButtonActionPerformed

    private void modifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyButtonActionPerformed
        if (Mechanics.getFreeMovieTitles().length != 0) {
            RentMovieGUI gui = this;
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    String filmnev = (String) freeFilmBox.getSelectedItem();
                    int index = freeFilmBox.getSelectedIndex();
                    new ModifyGUI(index, filmnev, gui).setVisible(true);
                }
            });
        }else{
            JOptionPane.showMessageDialog(this, "Jelenleg nincs egyetlen szabad film se amit módosítani tudna!");
        }
    }//GEN-LAST:event_modifyButtonActionPerformed

    private void rentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentButtonActionPerformed
        RentMovieGUI gui = this;
        if (Mechanics.getFreeMovieTitles().length != 0) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new RentGUI(gui).setVisible(true);
                }
            });
        }else{
            JOptionPane.showMessageDialog(this, "Jelenleg nincs egyetlen szabad film se!");
        }
    }//GEN-LAST:event_rentButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        if (Mechanics.getFreeMovieTitles().length != 0) {
            Mechanics.deleteMovie(String.valueOf(freeFilmBox.getSelectedItem()));
            getFreeFilmBox().setModel(new javax.swing.DefaultComboBoxModel<>(Mechanics.getFreeMovieTitles()));
        } else {
            JOptionPane.showMessageDialog(this, "Jelenleg nincs egyetlen szabad film se amit törölni tudna!");
        }

    }//GEN-LAST:event_deleteButtonActionPerformed

    private void newMovieButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMovieButtonActionPerformed
        RentMovieGUI gui = this;
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewMovieGUI(gui).setVisible(true);
            }
        });
    }//GEN-LAST:event_newMovieButtonActionPerformed

    private void nameBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameBoxActionPerformed
        Mechanics.updateRentMoviesByName((String) nameBox.getSelectedItem());
        getRentFilmBox().setModel(new javax.swing.DefaultComboBoxModel<>(Mechanics.getRentedMovieTitlesByName()));
    }//GEN-LAST:event_nameBoxActionPerformed

    private void rentMovieListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rentMovieListActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListMovieGUI().setVisible(true);
            }
        });
    }//GEN-LAST:event_rentMovieListActionPerformed

    public JComboBox<String> getFreeFilmBox() {
        return freeFilmBox;
    }

    public JComboBox<String> getRentFilmBox() {
        return rentFilmBox;
    }
    
    public JComboBox<String> getNameBox(){
        return nameBox;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox<String> freeFilmBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton modifyButton;
    private javax.swing.JComboBox<String> nameBox;
    private javax.swing.JButton newMovieButton;
    private javax.swing.JButton panicButton;
    private javax.swing.JButton rentButton;
    private javax.swing.JComboBox<String> rentFilmBox;
    private javax.swing.JButton rentMovieList;
    // End of variables declaration//GEN-END:variables

}

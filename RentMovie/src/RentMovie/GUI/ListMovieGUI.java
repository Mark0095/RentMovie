package RentMovie.GUI;

import RentMovie.Control.Mechanics;
import java.sql.Statement;
import java.util.Arrays;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ListMovieGUI extends javax.swing.JFrame {

    Statement createStatement = null;
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    
    public ListMovieGUI() {
        initComponents();
        Mechanics.addAllToMovieList(MovieList);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        MovieList = new javax.swing.JTable();
        allRentButton = new javax.swing.JButton();
        nowRentButton = new javax.swing.JButton();
        allMovieButton = new javax.swing.JButton();
        whatComboBox = new javax.swing.JComboBox<>();
        searchButton = new javax.swing.JButton();
        stringField = new javax.swing.JTextField();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Filmek listája");
        setLocation(new java.awt.Point(719, 391));
        setResizable(false);

        MovieList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Film cím"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        MovieList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MovieListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(MovieList);

        allRentButton.setText("Eddigi összes kölcsönadás");
        allRentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allRentButtonActionPerformed(evt);
            }
        });

        nowRentButton.setText("Jelenlegi kölcsönadások");
        nowRentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nowRentButtonActionPerformed(evt);
            }
        });

        allMovieButton.setText("Összes film");
        allMovieButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allMovieButtonActionPerformed(evt);
            }
        });

        whatComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cím", "Rendező", "Szereplők", "Gyártási év", "Hossz(Perc)", "Típus", "Kölcsönző neve" }));

        searchButton.setText("Keresés");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(whatComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(stringField, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(allMovieButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nowRentButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(allRentButton))
                            .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(allRentButton)
                    .addComponent(allMovieButton)
                    .addComponent(nowRentButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(whatComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stringField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void allRentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allRentButtonActionPerformed
        MovieList.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {}, new String [] { "Film cím", "Kölcsönvevő", "Kiadás dátum", "Visszavétel dátum"}){
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        if (MovieList.getColumnModel().getColumnCount() > 0) {
            MovieList.getColumnModel().getColumn(1).setPreferredWidth(100);
            MovieList.getColumnModel().getColumn(0).setPreferredWidth(140);
            MovieList.getColumnModel().getColumn(2).setPreferredWidth(70);
            MovieList.getColumnModel().getColumn(3).setPreferredWidth(90);
            centerRenderer.setHorizontalAlignment( JLabel.CENTER );
            MovieList.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
            MovieList.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
            MovieList.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
        }
        Mechanics.addRentedToMovieList(MovieList);
    }//GEN-LAST:event_allRentButtonActionPerformed

    private void allMovieButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allMovieButtonActionPerformed
        MovieList.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {}, new String [] {"Film cím"}){
            boolean[] canEdit = new boolean [] {
                false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Mechanics.addAllToMovieList(MovieList);
    }//GEN-LAST:event_allMovieButtonActionPerformed

    private void nowRentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nowRentButtonActionPerformed
        MovieList.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {}, new String [] {"Film cím", "Kölcsönvevő", "Kiadás dátum"}){
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        if (MovieList.getColumnModel().getColumnCount() > 0) {
            MovieList.getColumnModel().getColumn(1).setPreferredWidth(80);
            MovieList.getColumnModel().getColumn(0).setPreferredWidth(188);
            MovieList.getColumnModel().getColumn(2).setPreferredWidth(32);
            centerRenderer.setHorizontalAlignment( JLabel.CENTER );
            MovieList.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
            MovieList.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
        }
        Mechanics.addActRentedToMovieList(MovieList);
    }//GEN-LAST:event_nowRentButtonActionPerformed

    private void MovieListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MovieListMouseClicked
        int row = MovieList.rowAtPoint(evt.getPoint());
        String selected = MovieList.getValueAt(row,0).toString();
        if (row >= 0 && Arrays.asList(Mechanics.getFilmcim()).contains(selected)) {
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectedMovieInfGUI(selected).setVisible(true);
            }
        });
        }else{
            JOptionPane.showMessageDialog(this, "Ezt a filmet már törölték az adatbázisból", "Hiba", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_MovieListMouseClicked

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        MovieList.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {}, new String [] {"Film cím"}){
            boolean[] canEdit = new boolean [] {
                false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        String selection = whatComboBox.getSelectedItem().toString();
        switch(selection) {
            case "Cím" :
                Mechanics.addStringSearchedToMovieList(MovieList, stringField.getText(), "title");
                break;
            case "Rendező" :
                Mechanics.addStringSearchedToMovieList(MovieList, stringField.getText(), "director");
                break;
            case "Szereplők" :
                Mechanics.addStringSearchedToMovieList(MovieList, stringField.getText(), "actors");
                break;
            case "Gyártási év" :
                Mechanics.addIntSearchedToMovieList(MovieList, stringField.getText(), "date");
                break;
            case "Hossz(Perc)" :
                Mechanics.addIntSearchedToMovieList(MovieList, stringField.getText(), "time");
                break;
            case "Típus" :
                Mechanics.addStringSearchedToMovieList(MovieList, stringField.getText(), "type");
                break;
            case "Kölcsönző neve" :
                Mechanics.addNameSearchedToMovieList(MovieList, stringField.getText());
                break;
      }
    }//GEN-LAST:event_searchButtonActionPerformed
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable MovieList;
    private javax.swing.JButton allMovieButton;
    private javax.swing.JButton allRentButton;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton nowRentButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField stringField;
    private javax.swing.JComboBox<String> whatComboBox;
    // End of variables declaration//GEN-END:variables
}

package RentMovie.GUI;

import RentMovie.Control.Mechanics;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;

public class SelectedMovieInfGUI extends javax.swing.JFrame {

    String selected;
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    
    public SelectedMovieInfGUI(String selected) {
        this.selected = selected;
        initComponents();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        SelectedTable.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
        SelectedTable.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
        SelectedTable.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
        Mechanics.addSelectedToSelectedTable(SelectedTable, selected);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        SelectedTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Film információ");
        setLocation(new java.awt.Point(636, 515));

        SelectedTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cím", "Rendező", "Főszereplők", "Gyártási év", "Hossz(Perc)", "Típus", "Eredeti", "Szabad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(SelectedTable);
        if (SelectedTable.getColumnModel().getColumnCount() > 0) {
            SelectedTable.getColumnModel().getColumn(3).setMaxWidth(80);
            SelectedTable.getColumnModel().getColumn(4).setMaxWidth(90);
            SelectedTable.getColumnModel().getColumn(5).setMinWidth(5);
            SelectedTable.getColumnModel().getColumn(5).setMaxWidth(40);
            SelectedTable.getColumnModel().getColumn(6).setMaxWidth(50);
            SelectedTable.getColumnModel().getColumn(7).setMaxWidth(55);
        }
        SelectedTable.getAccessibleContext().setAccessibleParent(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable SelectedTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

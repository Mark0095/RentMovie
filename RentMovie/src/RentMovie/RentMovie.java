package RentMovie;

import RentMovie.GUI.RentMovieGUI;

public class RentMovie {
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RentMovieGUI().setVisible(true);
            }
        });
    }
}
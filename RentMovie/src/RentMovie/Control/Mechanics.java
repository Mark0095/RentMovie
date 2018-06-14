package RentMovie.Control;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Arrays;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Mechanics {

    private static String[] filmcim;
    private static String[] filmcimsort;
    private static String[] rendezo;
    private static String[] foszereplo;
    private static int[] gyartasiev;
    private static int[] hossz;
    private static String[] tipus;
    private static ArrayList<Boolean> eredeti;
    private static String[] rentedMovieTitles;
    private static String[] freeMovieTitles;
    private static String[] nevek;
    private static String[] rentedMovieTitlesByName = {"-"};

    final static String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    final static String URL = "jdbc:derby:RentMovie;create=true";
    final static String USERNAME = "";
    final static String PASSWORD = "";

    static Connection conn = null;
    static Statement createStatement = null;
    static DatabaseMetaData dbmd = null;
    
    private Mechanics(){}

    public static void makeConnection() {
        try {
            conn = DriverManager.getConnection(URL);
        } catch (SQLException ex) {
            System.out.println("Valami baj van a connection (híd) létrehozásakor.");
            System.out.println("" + ex);
        }

        if (conn != null) {
            try {
                createStatement = conn.createStatement();
            } catch (SQLException ex) {
                System.out.println("Valami baj van van a createStatament (teherautó) létrehozásakor.");
                System.out.println("" + ex);
            }
        }

        try {
            dbmd = conn.getMetaData();
        } catch (SQLException ex) {
            System.out.println("Valami baj van a DatabaseMetaData (adatbázis leírása) létrehozásakor..");
            System.out.println("" + ex);
        }

        try {
            ResultSet rs = dbmd.getTables(null, "APP", "MOVIES", null);
            if (!rs.next()) {
                createStatement.execute("create table movies(title varchar(100), director varchar(100), actors varchar(200), date int, time int, type varchar(3), origin boolean, howmanyrent int, free boolean)");
            }
        } catch (SQLException ex) {
            System.out.println("Valami baj van az adattáblák létrehozásakor.");
            System.out.println("" + ex);
        }
        
        try {
            ResultSet rs = dbmd.getTables(null, "APP", "USERS", null);
            if (!rs.next()) {
                createStatement.execute("create table users(name varchar(40), rentmovie varchar(100), rentdate date, backdate date)");
            }
        } catch (SQLException ex) {
            System.out.println("Valami baj van az adattáblák2 létrehozásakor.");
            System.out.println("" + ex);
        }
    }

    public static void addMovie(String title, String director, String actors, int year, int time, String type, boolean original, int howmanyrent, boolean free) {
        try {
            String sql = "insert into movies values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, director);
            preparedStatement.setString(3, actors);
            preparedStatement.setInt(4, year);
            preparedStatement.setInt(5, time);
            preparedStatement.setString(6, type);
            preparedStatement.setBoolean(7, original);
            preparedStatement.setInt(8, howmanyrent);
            preparedStatement.setBoolean(9, free);
            preparedStatement.execute();
            updateALL();
        } catch (SQLException ex) {
            System.out.println("Valami baj van a film hozzáadásakor");
            System.out.println("" + ex);
        }
    }

    public static void deleteMovie(String title) {
        try {
            String sql = "DELETE FROM movies WHERE title = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, title);
            preparedStatement.execute();
            updateALL();
        } catch (SQLException ex) {
            System.out.println("Valami baj van a film törlésekor");
            System.out.println("" + ex);
        }
    }
    
    public static void panic(){
        try {
            String sql = "DELETE FROM movies WHERE origin = '0' AND free = '1'";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.execute();
            updateALL();
        } catch (SQLException ex) {
            System.out.println("Valami baj van a pánik használatakor");
            System.out.println("" + ex);
        }
    }

    public static void rentMovie(String title, String name, Date ki, Date be) {
        try {
            String sql = "update movies set free = false where title = ?";
            String sql2 = "update movies set howmanyrent = howmanyrent + 1 where title = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, title);
            preparedStatement.execute();
            preparedStatement = conn.prepareStatement(sql2);
            preparedStatement.setString(1, title);
            preparedStatement.execute();
            updateALL();
        } catch (SQLException ex) {
            System.out.println("Valami baj van a film kölcsönadásakor");
            System.out.println("" + ex);
        }
        try {
            String sql = "insert into users values (?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, title);
            preparedStatement.setDate(3, ki);
            preparedStatement.setDate(4, be);
            preparedStatement.execute();
            updateALL();
        } catch (SQLException ex) {
            System.out.println("Valami baj van a film kölcsönadásakor");
            System.out.println("" + ex);
        }
    }

    public static void backMovie(String title, Date date) {
        try {
            String sql = "update movies set free = true where title = ?";
            String sql2 = "update users set backdate = ? where rentmovie = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, title);
            preparedStatement.execute();
            preparedStatement = conn.prepareStatement(sql2);
            preparedStatement.setDate(1, date);
            preparedStatement.setString(2, title);
            preparedStatement.execute();
            updateALL();
        } catch (SQLException ex) {
            System.out.println("Valami baj van a film visszavételekor");
            System.out.println("" + ex);
        }
    }

    public static boolean checkDelete(String title) {
        String sql = "select * from movies where title = '" + title + "'";
        try {
            boolean free = true;
            ResultSet rs = createStatement.executeQuery(sql);
            while (rs.next()) {
                free = rs.getBoolean("free");
            }
            return free;
        } catch (SQLException ex) {
            System.out.println("Valami baj van a film törlésenek csekkolásakor");
            System.out.println("" + ex);
        }
        return false;
    }

    public static void modifyMovie(String title, String director, String actors, int year, int time, String type, boolean original, String what) {
        try {
            String sql = "UPDATE movies SET title = ?, director = ?, actors = ?, date = ?, time = ?, type = ?, origin = ? WHERE title = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, director);
            preparedStatement.setString(3, actors);
            preparedStatement.setInt(4, year);
            preparedStatement.setInt(5, time);
            preparedStatement.setString(6, type);
            preparedStatement.setBoolean(7, original);
            preparedStatement.setString(8, what);
            preparedStatement.execute();
            updateALL();
        } catch (SQLException ex) {
            System.out.println("Valami baj van a film hozzáadásakor");
            System.out.println("" + ex);
        }
    }

    public static void updateTitles() {
        String sql = "select title from movies";
        try {
            ResultSet rs = createStatement.executeQuery(sql);
            ArrayList<String> titles = new ArrayList<>();

            while (rs.next()) {
                String actualTitle = rs.getString("title");
                titles.add(actualTitle);
            }
            filmcim = titles.toArray(new String[titles.size()]);
            filmcimsort = titles.toArray(new String[titles.size()]);
            Arrays.sort(filmcimsort);
        } catch (SQLException ex) {
            System.out.println("Valami baj van a filmek kiolvasásakor");
            System.out.println("" + ex);
        }
    }

    public static void updateDirector() {
        String sql = "select director from movies";
        try {
            ResultSet rs = createStatement.executeQuery(sql);
            ArrayList<String> directors = new ArrayList<>();

            while (rs.next()) {
                String actualDirector = rs.getString("director");
                directors.add(actualDirector);
            }
            rendezo = directors.toArray(new String[directors.size()]);
        } catch (SQLException ex) {
            System.out.println("Valami baj van a rendezők kiolvasásakor");
            System.out.println("" + ex);
        }
    }

    public static void updateActor() {
        String sql = "select actors from movies";
        try {
            ResultSet rs = createStatement.executeQuery(sql);
            ArrayList<String> actors = new ArrayList<>();

            while (rs.next()) {
                String actualActors = rs.getString("actors");
                actors.add(actualActors);
            }
            foszereplo = actors.toArray(new String[actors.size()]);
        } catch (SQLException ex) {
            System.out.println("Valami baj van a főszereplő/k kiolvasásakor");
            System.out.println("" + ex);
        }
    }

    public static void updateDate() {
        String sql = "select date from movies";
        try {
            ResultSet rs = createStatement.executeQuery(sql);
            ArrayList<String> dates = new ArrayList<>();

            while (rs.next()) {
                String actualDate = rs.getString("date");
                dates.add(actualDate);
            }
            String[] gyartasievstring = dates.toArray(new String[dates.size()]);
            int[] result = new int[gyartasievstring.length];
            for (int i = 0; i < gyartasievstring.length; i++) {
                result[i] = Integer.parseInt(gyartasievstring[i]);
            }
            gyartasiev = result;
        } catch (SQLException ex) {
            System.out.println("Valami baj van a gyartasiev kiolvasásakor");
            System.out.println("" + ex);
        }
    }

    public static void updateTime() {
        String sql = "select time from movies";
        try {
            ResultSet rs = createStatement.executeQuery(sql);
            ArrayList<String> times = new ArrayList<>();

            while (rs.next()) {
                String actualTime = rs.getString("time");
                times.add(actualTime);
            }
            String[] hosszstring = times.toArray(new String[times.size()]);
            int[] result = new int[hosszstring.length];
            for (int i = 0; i < hosszstring.length; i++) {
                result[i] = Integer.parseInt(hosszstring[i]);
            }
            hossz = result;
        } catch (SQLException ex) {
            System.out.println("Valami baj van a hossz kiolvasásakor");
            System.out.println("" + ex);
        }
    }

    public static void updateType() {
        String sql = "select type from movies";
        try {
            ResultSet rs = createStatement.executeQuery(sql);
            ArrayList<String> types = new ArrayList<>();

            while (rs.next()) {
                String actualType = rs.getString("type");
                types.add(actualType);
            }
            tipus = types.toArray(new String[types.size()]);
        } catch (SQLException ex) {
            System.out.println("Valami baj van a tipus kiolvasásakor");
            System.out.println("" + ex);
        }
    }

    public static void updateOrigin() {
        String sql = "select origin from movies";
        try {
            ResultSet rs = createStatement.executeQuery(sql);
            ArrayList<Boolean> origins = new ArrayList<>();

            while (rs.next()) {
                boolean actualOrigin = rs.getBoolean("origin");
                origins.add(actualOrigin);
            }
            eredeti = origins;
        } catch (SQLException ex) {
            System.out.println("Valami baj van aaz eredetiség kiolvasásakor");
            System.out.println("" + ex);
        }
    }

    public static void updateFreeMovies() {
        String sql = "select title from movies where free = true";
        try {
            ResultSet rs = createStatement.executeQuery(sql);
            ArrayList<String> titles = new ArrayList<>();

            while (rs.next()) {
                String actualTitle = rs.getString("title");
                titles.add(actualTitle);
            }
            freeMovieTitles = titles.toArray(new String[titles.size()]);
            Arrays.sort(freeMovieTitles);
        } catch (SQLException ex) {
            System.out.println("Valami baj van a szabad filmek kiolvasásakor");
            System.out.println("" + ex);
        }
    }

    public static void updateRentMovies() {
        String sql = "select title from movies where free = false";
        try {
            ResultSet rs = createStatement.executeQuery(sql);
            ArrayList<String> titles = new ArrayList<>();

            while (rs.next()) {
                String actualTitle = rs.getString("title");
                titles.add(actualTitle);
            }
            rentedMovieTitles = titles.toArray(new String[titles.size()]);
        } catch (SQLException ex) {
            System.out.println("Valami baj van a foglalt filmek kiolvasásakor");
            System.out.println("" + ex);
        }
    }
    
    public static void updateRentMoviesByName(String name){
        
        try {
            String sql = "select rentmovie from users where name = '"+ name +"' AND backdate is null";
            ResultSet rs = createStatement.executeQuery(sql);
            ArrayList<String> rentmovie = new ArrayList<>();

            while (rs.next()) {
                String actualRentMovie = rs.getString("rentmovie");
                rentmovie.add(actualRentMovie);
            }
            rentedMovieTitlesByName = rentmovie.toArray(new String[rentmovie.size()]);
            Arrays.sort(rentedMovieTitlesByName);
        } catch (SQLException ex) {
            System.out.println("Valami baj van a foglalt filmek név szerinti kiolvasásakor");
            System.out.println("" + ex);
        }
    }
    
    public static void updateNames(){
        String sql = "select name from users where backdate is null";
        try {
            ResultSet rs = createStatement.executeQuery(sql);
            ArrayList<String> names = new ArrayList<>();

            while (rs.next()) {
                String actualTitle = rs.getString("name");
                if(!names.contains(actualTitle)){
                    names.add(actualTitle);
                }
            }
            nevek = names.toArray(new String[names.size()]);
            Arrays.sort(nevek);
        } catch (SQLException ex) {
            System.out.println("Valami baj van a nevek kiolvasásakor");
            System.out.println("" + ex);
        }
    }

    public static void updateALL() {
        Mechanics.updateTitles();
        Mechanics.updateActor();
        Mechanics.updateDirector();
        Mechanics.updateDate();
        Mechanics.updateTime();
        Mechanics.updateType();
        Mechanics.updateOrigin();
        Mechanics.updateFreeMovies();
        Mechanics.updateRentMovies();
        Mechanics.updateNames();
    }

    public static String[] getRendezo() {
        return rendezo;
    }

    public static String[] getFoszereplo() {
        return foszereplo;
    }

    public static int[] getGyartasiev() {
        return gyartasiev;
    }

    public static int[] getHossz() {
        return hossz;
    }

    public static String[] getTipus() {
        return tipus;
    }

    public static String[] getFilmcim() {
        return filmcim;
    }
    
    public static String[] getFilmcimSort(){
        return filmcimsort;
    }

    public static ArrayList<Boolean> getEredeti() {
        return eredeti;
    }

    public static String[] getRentedMovieTitles() {
        return rentedMovieTitles;
    }

    public static String[] getFreeMovieTitles() {
        return freeMovieTitles;
    }
    
    public static String[] getRentedMovieTitlesByName(){
        return rentedMovieTitlesByName;
    }

    public static int getIndex(String title){
        for (int i = 0; i < getFilmcim().length; i++) {
            if (Mechanics.getFilmcim()[i].equals(title)) {
                return i;
            }
        }
        return -1;
    }
    
    public static String[] getNames(){
        return nevek;
    }
    
    public static ResultSet getAllRs(){
        String sql2 = "select * from users";
        ResultSet rs = null;
        try {
            rs = createStatement.executeQuery(sql2);
        } catch (SQLException ex) {
            System.out.println("Kéne irnia valamit");
            System.out.println("" + ex);
        }
        return rs;
    }
    
    public static ResultSet getActRs(){
        String sql2 = "select * from users where backdate is null";
        ResultSet rs = null;
        try {
            rs = createStatement.executeQuery(sql2);
        } catch (SQLException ex) {
            System.out.println("Kéne irnia valamit");
            System.out.println("" + ex);
        }
        return rs;
    }
    
    public static ResultSet getSelectedMovieRs(String title){
        String sql = "select * from movies where title = '" + title + "'";
        ResultSet rs = null;
        try{
            rs = createStatement.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("Kéne irnia valamit454545");
            System.out.println("" + ex);
        }
        return rs;
    }
    
    public static ResultSet getStringSearchRs(String selection, String what){
        String sql = "select title from movies where " + selection + " like '%" + what + "%'";
        ResultSet rs = null;
        try{
            rs = createStatement.executeQuery(sql);
        }catch (SQLException ex) {
            System.out.println("Kéne irnia valamitasd");
            System.out.println("" + ex);
        }
        return rs;
    }
    
    public static ResultSet getIntSearchRs(String selection, String what){
        String sql = "select title from movies where " + selection + " = " + what + "";
        ResultSet rs = null;
        try{
            rs = createStatement.executeQuery(sql);
        }catch (SQLException ex) {
            System.out.println("Kéne irnia valamitasdasd");
            System.out.println("" + ex);
        }
        return rs;
    }
    
    public static ResultSet getNameSearchRs(String what){
        String sql = "select * from users where name like '%" + what + "%' and backdate is null";
        ResultSet rs = null;
        try{
            rs = createStatement.executeQuery(sql);
        }catch (SQLException ex) {
            System.out.println("Kéne irnia valamitasdasd");
            System.out.println("" + ex);
        }
        return rs;
    }
    
    public static void addAllToMovieList(JTable MovieList){
        DefaultTableModel model = (DefaultTableModel) MovieList.getModel();
        String[] list = getFilmcimSort();
        Object rowData[] = new Object[1];
        for(int i = 0; i < list.length; i++)
        {
            rowData[0] = list[i];
            model.addRow(rowData);
        }
    }
    
    public static void addRentedToMovieList(JTable MovieList){        
        DefaultTableModel model = (DefaultTableModel) MovieList.getModel();
        Object rowData[] = new Object[4];
        ResultSet rs = getAllRs();
        try {
            while (rs.next()) {
                String name = rs.getString("name");
                String rentmovie = rs.getString("rentmovie");
                Date rentdate = rs.getDate("rentdate");
                Date backdate = rs.getDate("backdate");
                rowData[0] = rentmovie;
                rowData[1] = name;
                rowData[2] = rentdate;
                rowData[3] = backdate;
                model.addRow(rowData);
            }
        } catch (SQLException ex) {
            System.out.println("Kéne irnia valamit");
            System.out.println("" + ex);
        }         
    }
    
    public static void addActRentedToMovieList(JTable MovieList){        
        DefaultTableModel model = (DefaultTableModel) MovieList.getModel();
        Object rowData[] = new Object[3];
        ResultSet rs = getActRs();
        try {
            while (rs.next()) {
                String name = rs.getString("name");
                String rentmovie = rs.getString("rentmovie");
                Date rentdate = rs.getDate("rentdate");
                rowData[0] = rentmovie;
                rowData[1] = name;
                rowData[2] = rentdate;
                model.addRow(rowData);
            }
        } catch (SQLException ex) {
            System.out.println("Kéne irnia valamit");
            System.out.println("" + ex);
        }         
    }
    
    public static void addSelectedToSelectedTable(JTable SelectedTable, String selected){
        DefaultTableModel model = (DefaultTableModel) SelectedTable.getModel();
        Object rowData[] = new Object[8];
        ResultSet rs = getSelectedMovieRs(selected);
        try {
            while (rs.next()) {
                String title = rs.getString("title");
                String director = rs.getString("director");
                String actors = rs.getString("actors");
                int year = rs.getInt("date");
                int time = rs.getInt("time");
                String type = rs.getString("type");
                boolean original = rs.getBoolean("origin");
                boolean free = rs.getBoolean("free");
                rowData[0] = title;
                rowData[1] = director;
                rowData[2] = actors;
                rowData[3] = year;
                rowData[4] = time;
                rowData[5] = type;
                rowData[6] = original;
                rowData[7] = free;
                model.addRow(rowData);
            }
        } catch (SQLException ex) {
            System.out.println("Kéne irnia valamit666");
            System.out.println("" + ex);
        }
    }
    
    public static void addStringSearchedToMovieList(JTable MovieList, String what, String selection){
        DefaultTableModel model = (DefaultTableModel) MovieList.getModel();
        Object rowData[] = new Object[1];
        ResultSet rs = getStringSearchRs(selection, what);
        try {
            while (rs.next()) {
                String title = rs.getString("title");
                rowData[0] = title;
                model.addRow(rowData);
            }
        } catch (SQLException ex) {
            System.out.println("Kéne irnia valamit");
            System.out.println("" + ex);
        }  
    }
    
    public static void addIntSearchedToMovieList(JTable MovieList, String what, String selection){
        DefaultTableModel model = (DefaultTableModel) MovieList.getModel();
        Object rowData[] = new Object[1];
        ResultSet rs = getIntSearchRs(selection, what);
        try {
            while (rs.next()) {
                String title = rs.getString("title");
                rowData[0] = title;
                model.addRow(rowData);
            }
        } catch (SQLException ex) {
            System.out.println("Kéne irnia valamit");
            System.out.println("" + ex);
        }  
    }
    
    public static void addNameSearchedToMovieList(JTable MovieList, String what){
        DefaultTableModel model = (DefaultTableModel) MovieList.getModel();
        Object rowData[] = new Object[1];
        ResultSet rs = getNameSearchRs(what);
        try {
            while (rs.next()) {
                String title = rs.getString("rentmovie");
                rowData[0] = title;
                model.addRow(rowData);
            }
        } catch (SQLException ex) {
            System.out.println("Kéne irnia valamita");
            System.out.println("" + ex);
        }  
    }
    
    public static void adatbazisFeltoltes(){
        addMovie("A remény rabjai", "Frank Darabont", "Tim Robbins, Morgan Freeman", 1995, 142, "VHS", false, 0, true);
        addMovie("A keresztapa", "Francis Ford Coppola", "Marlon Brando, Al Pacino", 1982, 175, "VHS", false, 0, true);
        addMovie("A keresztapa 2", "Francis Ford Coppola", "Al Pacino, Robert De Niro", 1983, 202, "VHS", false, 0, true);
        addMovie("A sötét lovag", "Chritopher Nolan", "Chrisian Bale, Heath Ledger", 2008, 152, "DVD", true, 0, true);
        addMovie("Tizenkét dühös ember", "Sidney Lumet", "Henry Fonda", 1957, 96, "VHS", false, 0, true);
        addMovie("Schindler listája", "Steven Spielberg", "Liam Neeson", 1993, 195, "VHS", false, 0, true);
        addMovie("A Gyűrűk Ura: A király visszatér", "Peter Jackson", "Elijah Wood", 2003, 201, "DVD", true, 0, true);
        addMovie("Ponyvaregény", "Quentin Tarantino", "John Travolta, Uma Thurman, Samuel L. Jackson", 1994, 154, "VHS", false, 0, true);
        addMovie("A Jó, a Rossz és a Csúf", "Sergio Leone", "Clint Eastwood", 1996, 161, "VHS", false, 0, true);
        addMovie("Harcosok klubja", "David Fincher", "Brad Pitt, Edward Norton", 1999, 139, "DVD", true, 0, true);
        addMovie("A Gyűrűk Ura: A gyűrű szövetsége", "Peter Jackson", "Elijah Wood, Ian McKellen", 2001, 178, "DVD", true, 0, true);
        addMovie("Forest Gump", "Robert Zemenckis", "Tom Hanks", 1994, 142, "VHS", false, 0, true);
        addMovie("A Birodalom visszavág", "Irvin Kershner", "Mark Hamill, Harrison Ford, Carrie Fisher", 1980, 124, "VHS", false, 0, true);
        addMovie("Eredet", "Christopher Nolan", "Leonardo DiCaprio", 2010, 148, "DVD", true, 0, true);
        addMovie("A Gyűrűk Ura: A két torony", "Peter Jackson", "Elijah Wood, Ian McKellen", 2002, 179, "DVD", true, 0, true);
        addMovie("Száll a kakukk fészkére", "Milos Forman", "Jack Nicholson", 1975, 133, "VHS", false, 0, true);
        addMovie("Nagymenők", "Martin Scorsese", "Robert De Niro, Ray Liotta", 1990, 146, "VHS", false, 0, true);
        addMovie("Bosszúállók: Végtelen háború", "Russo brothers", "Robert Downey Jr., Chris Hemsworth, Mark Ruffalo", 2018, 149, "DVD", true, 0, true);
        addMovie("Mátrix", "The Wachowski Brothers", "Keanu Reeves", 1999, 136, "DVD", true, 0, true);
        addMovie("A hét szamuráj", "Akira Kurosawa", "Toshiro Mifune", 1954, 207, "VHS", false, 0, true);
        addMovie("Isten városa", "Fernando Meirelles", "Alexandre Rodrigues, Leandro Firmino", 2002, 130, "DVD", true, 0, true);
        addMovie("Star Wars IV.rész - Egy új remény", "George Lucas", "Mark Hamill, Harrison Ford, Carrie Fisher", 1977, 121, "VHS", false, 0, true);
        addMovie("Hetedik", "David Fincher", "Morgan Freeman, Brad Pitt", 1995, 127, "VHS", false, 0, true);
        addMovie("A bárányok hallgatnak", "Jonathan Demme", "Jodie Foster, Antony Hopkins", 1991, 118, "VHS", false, 0, true);
        addMovie("Az élet csodaszép", "Frank Capra", "James Stewart", 1946, 130, "VHS", false, 0, true);
        addMovie("Az élet szép", "Roberto Benigni", "Roberto Benigni", 1997, 116, "VHS", false, 0, true);
        addMovie("Közönséges bűnözők", "Bryan Singer", "Kevin Spacey, Gabriel Byrne", 1995, 106, "VHS", false, 0, true);
        addMovie("Chihiro szellemországban", "Hayao Miyazaki", "Daveigh Chase, Suzanne Pleshette", 2001, 125, "DVD", true, 0, true);
        addMovie("Ryan közlegény megmentése", "Steven Spielberg", "Tom Hanks, Matt Damon", 1998, 169, "DVD", true, 0, true);
        addMovie("Léon, a profi", "Luc Besson", "Jean Reno, Gary Oldman", 1994, 110, "VHS", false, 0, true);
        addMovie("Halálsoron", "Frank Darabont", "Tom Hanks", 1999, 189, "DVD", true, 0, true);
        addMovie("Csillagok között", "Christopher Nolan", "Matthew McConaughey, Anna Hathaway", 2014, 169, "DVD", true, 0, true);
        addMovie("Amerikai história X", "Tony Kaye", "Edward Norton, Edward Furlong", 1998, 119, "DVD", true, 0, true);
    }
}

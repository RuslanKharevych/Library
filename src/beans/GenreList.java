package beans;

import db.DataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GenreList {


    private ArrayList<Genre> genreList = new ArrayList<Genre>();

    private ArrayList<Genre> getGenres() {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = DataBase.getConnection();

            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from genre");
            while (rs.next()) {
                Genre genre = new Genre();
                genre.setId_g(rs.getInt("id_g"));
                genre.setName_g(rs.getString("name_g"));
                genreList.add(genre);
            }

        } catch (SQLException ex) {
            Logger.getLogger(GenreList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            /*try {
                if (stmt!=null) stmt.close();
                if (rs!=null)rs.close();
                if (conn!=null)conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(GenreList.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        }

        return genreList;
    }

    public ArrayList<Genre> getGenreList() {
        if (!genreList.isEmpty()) {
            return genreList;
        } else {
            return getGenres();
        }
    }
}

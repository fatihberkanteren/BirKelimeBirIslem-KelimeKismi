package birkelime;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DbHelper {
    public DbHelper(){
        System.out.println("DbHelper sınıfı çalıştı.");
    }

    Connection conn = null;

    public static Connection kys_kelimeler() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Lenovo\\OneDrive\\Belgeler\\NetBeansProjects\\BirKelime\\kelime.sqlite");
            return conn;
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Hata : " + ex);
        }
        return null;
    }
}

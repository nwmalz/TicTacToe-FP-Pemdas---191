import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    // TODO: Ganti PASSWORD dengan password PostgreSQL kamu
    private static final String URL      = "jdbc:postgresql://localhost:54333/game_project";
    private static final String USER     = "postgres";
    private static final String PASSWORD = "password saya";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

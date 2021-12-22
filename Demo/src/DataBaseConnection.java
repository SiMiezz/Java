import java.sql.*;

public class DataBaseConnection {

    private static DataBaseConnection instance;
    private Connection conn;
    private String url = "jdbc:postgresql://localhost:5432/Progetto";
    private String username = "postgres";
    private String password = "Flegreo4";

    private DataBaseConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            this.conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.err.println(e);
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public static DataBaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DataBaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DataBaseConnection();
        }

        return instance;
    }
}

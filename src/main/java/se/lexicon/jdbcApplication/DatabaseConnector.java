package se.lexicon.jdbcApplication;

public class DatabaseConnector {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/world";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "1234";

    private Connection connection;

    public DatabaseConnector() {
        // Constructor
    }

    public void connect() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                System.out.println("Connected to the database!");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.err.println("Failed to load JDBC driver.");
            }
        }
    }

    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Disconnected from the database.");
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println("Failed to close database connection.");
            }
        }
    }

    public Connection getConnection() {
        return connection;
    }
}


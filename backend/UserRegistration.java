import java.sql.*;

public class UserRegistration {
    private static final String URL = "jdbc:mysql://localhost:3306/user_login_db";
    private static final String USER = "yourUsername"; // Replace with your MySQL username
    private static final String PASSWORD = "yourPassword"; // Replace with your MySQL password

    public static void main(String[] args) {
        // Example registration (you can modify this part to accept user input)
        String username = "test@example.com"; // Replace with user input
        String password = "yourPassword"; // Replace with user input
        String provider = "google"; // or "facebook"

        registerUser(username, password, provider);
    }

    public static void registerUser(String username, String password, String provider) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "INSERT INTO users (username, password, provider) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, provider);
            preparedStatement.executeUpdate();
            System.out.println("User registered successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean signIn(String username, String password) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // Returns true if user exists
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
package org.felix.dictionary.database;

import java.sql.*;
import org.felix.dictionary.model.City;
public class CityCrud<City> implements BaseOper<City>{
    private static String jdbcURL = "jdbc:h2:~/best";
    private static String jdbcUsername = "sa";
    private static String jdbcPassword = "";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    @Override
    public void createCity() throws SQLException{
           String createTableSQL = "create table cities (\r\n" + "  id  int(3) primary key,\r\n" +
                "  name varchar(20),\r\n" + "  region varchar(20),\r\n" + "  district varchar(20),\r\n" +
                "  population int(20),\r\n" + "  foundation int(20)\r\n" +"  );";

        System.out.println(createTableSQL);
        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             Statement statement = connection.createStatement();) {

            // Step 3: Execute the query or update query
            statement.execute(createTableSQL);

        } catch (SQLException e) {
            // print SQL exception information
            H2JDBCUtils.printSQLException(e);
        }
    }

    @Override
    public void updateCity( ) throws SQLException{
        String UPDATE_USERS_SQL = "update cities set name = ? where id = ?;";
        System.out.println(UPDATE_USERS_SQL);
        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)) {
            preparedStatement.setString(1, "Ram");
            preparedStatement.setInt(2, 1);

            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            // print SQL exception information
            H2JDBCUtils.printSQLException(e);
        }

        // Step 4: try-with-resource statement will auto close the connection.
    }

    @Override
    public void deleteCity( ) throws SQLException{
        String deleteTableSQL = "delete from cities where id = 1";
        System.out.println(deleteTableSQL);
        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             Statement statement = connection.createStatement();) {

            // Step 3: Execute the query or update query
            statement.execute(deleteTableSQL);

        } catch (SQLException e) {
            // print SQL exception information
            H2JDBCUtils.printSQLException(e);
        }
    }

    @Override
    public void readCity( ) throws SQLException {
        String QUERY = "select id,name,region,district,population,foundation from cities where id =?";
            // using try-with-resources to avoid closing resources (boiler plate code)

            // Step 1: Establishing a Connection
            try (Connection connection = H2JDBCUtils.getConnection();

                 // Step 2:Create a statement using connection object
                 PreparedStatement preparedStatement = connection.prepareStatement(QUERY);) {
                preparedStatement.setInt(1, 1);
                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                ResultSet rs = preparedStatement.executeQuery();

                // Step 4: Process the ResultSet object.
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String region = rs.getString("region");
                    String district = rs.getString("district");
                    int population = rs.getInt("population");
                    int foundation = rs.getInt("foundation");
                    System.out.println(id + "," + name + "," + region + "," + district + "," + population + "," + foundation);
                }
            } catch (SQLException e) {
                H2JDBCUtils.printSQLException(e);
            }
            // Step 4: try-with-resource statement will auto close the connection.
        }

    @Override
    public void insertCity( ) throws SQLException {
        String INSERT_USERS_SQL = "INSERT INTO cities" +
                "  (id, name, region, district , population, foundation) VALUES " +
                " (?, ?, ?, ?, ?, ?);";

        System.out.println(INSERT_USERS_SQL);
        // Step 1: Establishing a Connection
        try (Connection connection = H2JDBCUtils.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "Tony");
            preparedStatement.setString(3, "tony@gmail.com");
            preparedStatement.setString(4, "US");
            preparedStatement.setInt(5, 878787);
            preparedStatement.setInt(6, 78877);

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        } catch (SQLException e) {

            // print SQL exception information
            H2JDBCUtils.printSQLException(e);
        }

        // Step 4: try-with-resource statement will auto close the connection.
    }
}

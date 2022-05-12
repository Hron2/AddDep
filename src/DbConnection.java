
import java.sql.*;


public class DbConnection {
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "12345";
    public static final String URL = "jdbc:mysql://localhost:3306/adddep";
    public static Statement statement;
    public static Connection connection;
    public static ResultSet rs = null;
    public static String[] strNamestat = new String[12];
    public static String[] strIssues = new String[10];




    static String[] getData (String sql, String column){
        String[] strings = new String[12];


             try {
                connection = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
            }catch (SQLException throwables){
                throwables.printStackTrace();
                throw new RuntimeException();
            }


            try {

                Class.forName("com.mysql.jdbc.Driver");

                statement = connection.createStatement();
                rs = statement.executeQuery(sql);
                int i = 0;
                while (rs.next()) {
                    //Get values
                    String value = rs.getString(column);
                    strings[i] = value;
                    i++;

                }


            } catch (Exception throwables) {
                throwables.printStackTrace();
                throw new RuntimeException();
            } finally {
                try {
                    rs.close();
                    //rsIssues.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return strings;
        }


    public static void setStrNamestat(String[] strNamestat) {
        DbConnection.strNamestat = strNamestat;
    }


    public static void setStrIssues(String[] strIssues) {
        DbConnection.strIssues = strIssues;
    }


    public static String[] getStrnamestat() {
        return strNamestat;
    }

    public static String[] getStrIssues() {
        return strIssues;
    }
}

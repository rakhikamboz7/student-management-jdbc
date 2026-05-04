import java.sql.Connection;
import java.sql.DriverManager;


void main() {

    String url = "JDBC:mysql://localhost:3306/studentdb";
    String user = "root";
    String password = "Code@2026Mysql!";

    try {
        Connection con =
                DriverManager.getConnection(url, user, password);
        System.out.println("Connected Successfully!");
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

}
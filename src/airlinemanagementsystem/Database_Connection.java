package airlinemanagementsystem;

import java.sql.*;

public class Database_Connection {

        Connection c;
        Statement s;

        public Database_Connection() {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                c = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinemanagementsystem", "root", "loulouperlan");
                s = c.createStatement();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }





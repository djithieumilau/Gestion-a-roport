package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;
import java.sql.*;

public class InfoVol extends JFrame {

    public InfoVol(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JTable table = new JTable();

        try{
            Database_Connection databaseConnection = new Database_Connection();
            ResultSet rs = databaseConnection.s.executeQuery("select * from vol");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 0, 800, 500);
        add(jsp);


        setSize(800, 500);
        setLocation(400,200);
        setVisible(true);
    }




    public static void main(String[] args) {
        new InfoVol();
    }
}

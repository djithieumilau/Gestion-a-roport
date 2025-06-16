package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class CarteEmbarquement extends JFrame implements ActionListener{

    JTextField tfpnr;
    JLabel tfnom, tfnationalite, lbldepart, lblarrivee, labelfnom, labelfcode, labeldate;
    JButton allerButton;

    public CarteEmbarquement() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel subheading = new JLabel("CARTE D'EMBARQUEMENT");
        subheading.setBounds(360, 50, 300, 30);
        subheading.setFont(new Font("vineta BT", Font.PLAIN, 24));
        subheading.setForeground(Color.BLUE);
        add(subheading);

        JLabel lblID = new JLabel("PNR DETAILS");
        lblID.setBounds(60, 100, 150, 25);
        lblID.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblID);

        tfpnr = new JTextField();
        tfpnr.setBounds(220, 100, 150, 25);
        add(tfpnr);

        allerButton = new JButton("Enter");
        allerButton.setBackground(Color.BLACK);
        allerButton.setForeground(Color.WHITE);
        allerButton.setBounds(380, 100, 120, 25);
        allerButton.addActionListener(this);
        add(allerButton);

        JLabel lblnom = new JLabel("NOM");
        lblnom.setBounds(60, 140, 150, 25);
        lblnom.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnom);

        tfnom = new JLabel();
        tfnom.setBounds(220, 140, 150, 25);
        add(tfnom);

        JLabel lblnationalite = new JLabel("NATIONALITE");
        lblnationalite.setBounds(60, 180, 150, 25);
        lblnationalite.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationalite);

        tfnationalite = new JLabel();
        tfnationalite.setBounds(220, 180, 150, 25);
        add(tfnationalite);

        JLabel lbladress = new JLabel("DEPART");
        lbladress.setBounds(60, 220, 150, 25);
        lbladress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladress);

        lbldepart = new JLabel();
        lbldepart.setBounds(220, 220, 150, 25);
        add(lbldepart);

        JLabel lblgenre = new JLabel(" ARRIVEE");
        lblgenre.setBounds(380, 220, 150, 25);
        lblgenre.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladress);

        lblarrivee = new JLabel();
        lblarrivee.setBounds(540, 220, 150, 25);
        add(lblarrivee);

        JLabel lblfnom = new JLabel("Nom Vol");
        lblfnom.setBounds(60, 260, 150, 25);
        lblfnom.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnom);

        labelfnom = new JLabel();
        labelfnom.setBounds(220, 260, 150, 25);
        add(labelfnom);

        JLabel lblfcode = new JLabel("Code de Vol");
        lblfcode.setBounds(380, 260, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);

        labelfcode = new JLabel();
        labelfcode.setBounds(540, 260, 150, 25);
        add(labelfcode);

        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 300, 150, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);

        labeldate = new JLabel();
        labeldate.setBounds(220, 300, 150, 25);
        add(labeldate);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/aircameroun.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 230, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(600, 0, 300, 300);
        add(lblimage);

        setSize(1000, 450);
        setLocation(300, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String pnr = tfpnr.getText();

        try {
            Database_Connection databaseConnection = new Database_Connection();

            String query = "select * from reservation where PNR = '"+pnr+"'";

            ResultSet rs = databaseConnection.s.executeQuery(query);

            if (rs.next()) {
                tfnom.setText(rs.getString("nom"));
                tfnationalite.setText(rs.getString("nationalite"));
                lbldepart.setText(rs.getString("depart"));
                lblarrivee.setText(rs.getString("arrivee"));
                labelfnom.setText(rs.getString("nomvol"));
                labelfcode.setText(rs.getString("codevol"));
                labeldate.setText(rs.getString("ddate"));
            } else {
                JOptionPane.showMessageDialog(null, "Please enter correct PNR");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new CarteEmbarquement();
    }
}
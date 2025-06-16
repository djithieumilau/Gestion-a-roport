package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class TicketAnnulation extends JFrame implements ActionListener{

    JTextField tfpnr;
    JLabel tfnom, annulationno, lblfcode, lblannulationdate;
    JButton allerButton, vol;

    public TicketAnnulation() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        Random random = new Random();

        JLabel heading = new JLabel("ANNULATION");
        heading.setBounds(180, 20, 250, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        add(heading);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/cancel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(470, 120, 250, 250);
        add(image);

        JLabel lblID = new JLabel("NUMERO PNR");
        lblID.setBounds(60, 80, 150, 25);
        lblID.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblID);

        tfpnr = new JTextField();
        tfpnr.setBounds(220, 80, 150, 25);
        add(tfpnr);

        allerButton = new JButton("Show Details");
        allerButton.setBackground(Color.BLACK);
        allerButton.setForeground(Color.WHITE);
        allerButton.setBounds(380, 80, 120, 25);
        allerButton.addActionListener(this);
        add(allerButton);

        JLabel lblnom = new JLabel("Non");
        lblnom.setBounds(60, 130, 150, 25);
        lblnom.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnom);

        tfnom = new JLabel();
        tfnom.setBounds(220, 130, 150, 25);
        add(tfnom);

        JLabel lblnationalite = new JLabel("Numero du ticket annule");
        lblnationalite.setBounds(60, 180, 250, 25);
        lblnationalite.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationalite);

        annulationno = new JLabel("" + random.nextInt(1000000));
        annulationno.setBounds(280, 180, 150, 25);
        add(annulationno);

        JLabel lbladdress = new JLabel("Code de Vol");
        lbladdress.setBounds(60, 230, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladdress);

        lblfcode = new JLabel();
        lblfcode.setBounds(220, 230, 150, 25);
        add(lblfcode);

        JLabel lblgender = new JLabel("Date");
        lblgender.setBounds(60, 280, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);

        lblannulationdate = new JLabel();
        lblannulationdate.setBounds(220, 280, 150, 25);
        add(lblannulationdate);

        vol = new JButton("ANNULE");
        vol.setBackground(Color.BLACK);
        vol.setForeground(Color.WHITE);
        vol.setBounds(220, 330, 120, 25);
        vol.addActionListener(this);
        add(vol);

        setSize(800, 450);
        setLocation(350, 150);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == allerButton) {
            String pnr = tfpnr.getText();

            try {
                Database_Connection databaseConnection = new Database_Connection();

                String query = "select * from reservation where PNR = '"+pnr+"'";

                ResultSet rs = databaseConnection.s.executeQuery(query);

                if (rs.next()) {
                    tfnom.setText(rs.getString("nom"));
                    lblfcode.setText(rs.getString("codevol"));
                    lblannulationdate.setText(rs.getString("ddate"));
                } else {
                    JOptionPane.showMessageDialog(null, "Veuillez entrer le PNR correct");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == vol) {
            String nom = tfnom.getText();
            String pnr = tfpnr.getText();
            String annulation_nb = annulationno.getText();
            String vcode = lblfcode.getText();
            String date = lblannulationdate.getText();

            try {
                Database_Connection databaseConnection = new Database_Connection();

                String query = "insert into annulation values('"+pnr+"', '"+nom+"', '"+annulation_nb+"', '"+vcode+"', '"+date+"')";

                databaseConnection.s.executeUpdate(query);
                databaseConnection.s.executeUpdate("delete from reservation where PNR = '"+pnr+"'");

                JOptionPane.showMessageDialog(null, "Ticket Annule");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new TicketAnnulation();
    }
}
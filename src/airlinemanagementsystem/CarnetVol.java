package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

import com.toedter.calendar.JDateChooser;

public class CarnetVol extends JFrame implements ActionListener {
        JTextField tfID;
        JLabel tfnom, tfprenom, tfgenre, tfnationalite, tfadress, labelgenre, labelfnom, labelfcode;
        JButton  AllerButton, carnetvol, vol;
        Choice depart, arrivee;
    JDateChooser dcdate;

        public CarnetVol() {
            getContentPane().setBackground(Color.WHITE);
            setLayout(null);

            JLabel heading = new JLabel("CARNET DE VOL");
            heading.setBounds(540, 20, 1000, 35);
            heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
            heading.setForeground(Color.MAGENTA);
            add(heading);


            JLabel lblID = new JLabel("ID");
            lblID.setBounds(60, 80, 150, 25);
            lblID.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(lblID);
            tfID = new JTextField();
            tfID.setBounds(220, 80, 150, 25);
            add(tfID);

          AllerButton = new JButton("ALLER AU PASSAGER");
            AllerButton.setBackground(Color.BLACK);
            AllerButton.setForeground(Color.WHITE);
            AllerButton.setBounds(380, 80, 200, 25);
            AllerButton.addActionListener(this);
            add(AllerButton);


            JLabel lblnom = new JLabel("NOMS");
            lblnom.setBounds(60, 130, 150, 25);
            lblnom.setFont(new Font("Tahoma", Font.PLAIN, 16));
              add(lblnom);
            tfnom = new JLabel();
            tfnom.setBounds(220, 130, 150, 25);
            add(tfnom);

            JLabel lblprenom = new JLabel("PRENOMS");
            lblprenom.setBounds(60, 180, 150, 25);
            lblprenom.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(lblprenom);
            tfprenom = new JLabel();
            tfprenom.setBounds(220, 180, 150, 25);
            add(tfprenom);

            JLabel lblgenre = new JLabel("GENRE");
            lblgenre.setBounds(60, 230, 150, 25);
            lblgenre.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(lblgenre);
            labelgenre = new JLabel("Genre");
            labelgenre.setBounds(220, 230, 150, 25);
            add(labelgenre);

            JLabel lblnationalite = new JLabel("NATIONALITE");
            lblnationalite.setBounds(60, 280, 150, 25);
            lblnationalite.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(lblnationalite);
            tfnationalite = new JLabel();
            tfnationalite.setBounds(220, 280, 150, 25);
            add(tfnationalite);

            JLabel lbladress = new JLabel("ADRESS");
            lbladress.setBounds(60, 330, 150, 25);
            lbladress.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(lbladress);
            tfadress = new JLabel();
            tfadress.setBounds(220, 330, 150, 25);
            add(tfadress);


            JLabel lbldepart = new JLabel("DEPART");
            lbldepart.setBounds(60, 380, 150, 25);
            lbldepart.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(lbldepart);

            depart = new Choice();
            depart.setBounds(220, 380, 150, 25);
            depart.add(" ");
            add(depart);

            JLabel lblarrivee = new JLabel("ARRIVEE");
            lblarrivee.setBounds(60, 430, 150, 25);
            lblarrivee.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(lblarrivee);

            arrivee = new Choice();
            arrivee.setBounds(220, 430, 150, 25);
            arrivee.add(" ");
            add(arrivee);


            try {
                Database_Connection c = new Database_Connection();
                String query = "select * from vol";
                ResultSet rs = c.s.executeQuery(query);

                while(rs.next()) {
                    depart.add(rs.getString("depart"));
                    arrivee.add(rs.getString("arrivee"));
                }


            } catch (Exception e) {
                e.printStackTrace();
            }

            vol = new JButton("ALLER AU VOL");
            vol.setBackground(Color.BLACK);
            vol.setForeground(Color.WHITE);
            vol.setBounds(380, 530, 120, 25);
            vol.addActionListener(this);
            add(vol);

            JLabel lblfnom = new JLabel("NOM DU VOL");
            lblfnom.setBounds(60, 480, 150, 25);
            lblfnom.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(lblfnom);

            labelfnom = new JLabel();
            labelfnom.setBounds(220, 480, 150, 25);
            add(labelfnom);

            JLabel lblfcode = new JLabel("CODE DE VOL");
            lblfcode.setBounds(60, 530, 150, 25);
            lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(lblfcode);

            labelfcode = new JLabel();
            labelfcode.setBounds(220, 530, 150, 25);
            add(labelfcode);

            JLabel lbldate = new JLabel("DATE DU VOL");
            lbldate.setBounds(60, 600, 150, 25);
            lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(lbldate);

            dcdate = new JDateChooser();
            dcdate.setBounds(220, 600, 150, 25);
            add(dcdate);

            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/details.jpg"));
            Image i2 = i1.getImage().getScaledInstance(450, 500, Image.SCALE_DEFAULT);
            ImageIcon image = new ImageIcon(i2);
            JLabel lblimage = new JLabel(image);
            lblimage.setBounds(800, 0, 500, 1000);
            add(lblimage);

            carnetvol = new JButton("CARNET DE VOL");
            carnetvol.setBackground(Color.BLACK);
            carnetvol.setForeground(Color.WHITE);
            carnetvol.setBounds(300, 700, 150, 25);
            carnetvol.addActionListener(this);
            add(carnetvol);

            setSize(1100, 700);
            setLocation(200, 50);
            setVisible(true);

        }  public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == AllerButton) {
            String ID = tfID.getText();

            try {
               Database_Connection databaseConnection = new Database_Connection();

                String query = "select * from passager where ID = '"+ID+"'";

                ResultSet rs = databaseConnection.s.executeQuery(query);

                if (rs.next()) {
                    tfnom.setText(rs.getString("nom"));
                    tfprenom.setText(rs.getString("prenom"));
                    tfnationalite.setText(rs.getString("nationalite"));
                    tfadress.setText(rs.getString("adress"));
                    labelgenre.setText(rs.getString("genre"));
                } else {
                    JOptionPane.showMessageDialog(null, "Veuillez entrer un ID correct");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == vol) {
            String src = depart.getSelectedItem();
            String dest = arrivee.getSelectedItem();
            try {
              Database_Connection databaseConnection = new Database_Connection();

                String query = "select * from vol where depart = '"+src+"' and arrivee = '"+dest+"'";

                ResultSet rs = databaseConnection.s.executeQuery(query);

                if (rs.next()) {
                    labelfnom.setText(rs.getString("v_nom"));
                    labelfcode.setText(rs.getString("v_code"));
                } else {
                    JOptionPane.showMessageDialog(null, "Aucun Vol Trouve");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Random random = new Random();

            String ID = tfID.getText();
            String nom = tfnom.getText();
            String nationalite = tfnationalite.getText();
            String nomvol = labelfnom.getText();
            String codevol = labelfcode.getText();
            String src = depart.getSelectedItem();
            String dest = arrivee.getSelectedItem();
            String ddate = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();

            try {
                Database_Connection databaseConnection = new Database_Connection();
                String query = "insert into reservation values('PNR-"+random.nextInt(1000000)+"', 'TIC-"+random.nextInt(10000)+"', '"+ID+"', '"+nom+"', '"+nationalite+"', '"+nomvol+"', '"+codevol+"', '"+src+"', '"+dest+"', '"+ddate+"')";

                databaseConnection.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Ticket Booked Successfully");

                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new CarnetVol();
    }
}
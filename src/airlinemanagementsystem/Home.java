package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Home extends JFrame implements ActionListener {

    public Home() {
        setLayout(null);
        setSize(400,250);
        setLocation(600,250);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/Icons/front.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1600, 800);
        add(image);

        JLabel heading = new JLabel("BIENVENU A VOUS SUR AIR CAMEROUN ");
        heading.setBounds(420, 50, 1000, 40);
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 40));
        image.add(heading);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu tickets = new JMenu("Tickets");
        menuBar.add(tickets);

        JMenu details = new JMenu("Details");
        menuBar.add(details);

        JMenuItem volDetails = new JMenuItem("Informations sur le Vol");
        volDetails.addActionListener(this);
        details.add(volDetails);

        JMenuItem passagerDetails = new JMenuItem("Ajouter des informations sur le passager");
        passagerDetails.addActionListener(this);
        details.add(passagerDetails);

        JMenuItem ticketannulation = new JMenuItem("Tickets annulé");
        ticketannulation.addActionListener(this);
        tickets.add(ticketannulation);

        JMenuItem carnetvol = new JMenuItem("Carnet de Vol");
        carnetvol.addActionListener(this);
        details.add(carnetvol);

        JMenuItem journeeDetails = new JMenuItem("Informations sur la journée");
        journeeDetails.addActionListener(this);
        details.add(journeeDetails);


        JMenuItem carteembarquement = new JMenuItem("Carte d'embarquement");
        carteembarquement.addActionListener(this);
        tickets.add(carteembarquement);


        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

    }



    public void actionPerformed(ActionEvent ae) { //pour definir l'action du boutton
        String text = ae.getActionCommand();

        if (text.equals("Ajouter des informations sur le passager")){
            new Passager();

        }else if (text.equals("Informations sur le Vol")){
            new InfoVol();

        }else if (text.equals("Informations sur la journée")){
            new JourneeDetails();
        }else if (text.equals("Carnet de Vol")){
            new CarnetVol();
        }else if (text.equals("Tickets annulé")){
            new TicketAnnulation();
        }else if (text.equals("Carte d'embarquement")){
            new CarteEmbarquement();
        }

        }


    public static void main(String[] args) {
        new Home();
    }





}

package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton submit, reset, close; //pour rendre le boutton interactif et declre en meme temps le type de submit, reset, et close
    JTextField tfusername;  //pour pouvoir rentrer un texte dans le champ et declare en meme temp le type de tyusername et celui de tfpassword
    JPasswordField tfpassword;//la declaration doit se faiire avant d'entrer dans le constructeur

    public Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(20,20,100,20);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(130, 20, 200, 20);
        add(tfusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(20,60, 100,20);
        add(lblpassword);

        tfpassword = new JPasswordField(); //pour cacher le mot de passe
        tfpassword.setBounds(130, 60, 200, 20);
        add(tfpassword);

         reset = new JButton("reset");
        reset.setBounds(40, 120, 120, 20);
        reset.addActionListener(this);
        add(reset);

         submit = new JButton("submit");
        submit.setBounds(190, 120, 120, 20);
        submit.addActionListener(this);
        add(submit);

         close = new JButton("close");
        close.setBounds(120, 160, 120, 20);
        close.addActionListener(this);
        add(close);


        setSize(400,250);  //pour donner une taille predefini a l'interface
        setLocation(600,250); // pour centrer l'inteface sur l'ecran
        setVisible(true);  // pour rendre l'interface visible

    }


    public void actionPerformed(ActionEvent ae) { //pour definir l'action du boutton
    if (ae.getSource() == submit){
   String username = tfusername.getText();
        String password = tfpassword.getText();
        try {
            Database_Connection c = new Database_Connection();
            String query = "select * from login where username = '"+username+"' and password = '"+password+"'  ";
           ResultSet rs = c.s.executeQuery(query);

if (rs.next()){
new Home();
    setVisible(false);
}else {
    JOptionPane.showMessageDialog(null, "invalid username and password");
    setVisible(false);
}

        } catch (Exception e) {
            e.printStackTrace();
        }

    }else if (ae.getSource() == close){
    setVisible(false);

    } else if (ae.getSource() == reset){
    tfusername.setText("");
    tfpassword.setText("");
    }
    }

    public static void main(String[] args) {
        new Login();
    }
}

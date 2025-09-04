import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JButton SignIn,clear,Signup;          //global declartion to further use in actionListener
    JTextField cardNoEntry ;
    JPasswordField passEntry;
    Login(){
        setLayout(null);
        setTitle("AUTOMATED TELLER MACHINE");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));//load the image in the compiler
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);  //attach the icon to the jframe
        label.setBounds(30,40,100,100);
        add(label);                     // "

        JLabel text = new JLabel("Raunak Banking Services 😊👨‍✈️");
        text.setFont(new Font ("Osward",Font.BOLD,30));
        text.setBounds(160,40,600,80 );
        add(text);

        JLabel cardNo = new JLabel("Card No :");
        cardNo.setBounds(120,200,300,25);
        cardNo.setFont(new Font("Osward",Font.BOLD,25));
        add(cardNo);

        JLabel pass = new JLabel("Password : ");
        pass.setBounds(120,280,300,25);
        pass.setFont(new Font("Osward",Font.BOLD,25));
        add(pass);

        cardNoEntry = new JTextField();
        cardNoEntry.setBounds(280,200,300,25);
        cardNoEntry.setFont(new Font("Aerial",Font.BOLD,20));
        add(cardNoEntry);

        passEntry = new JPasswordField();   //takes character array
        passEntry.setBounds(280,280,300,25);
        passEntry.setFont(new Font("Aerial",Font.BOLD,20));
        add(passEntry);

        JLabel text2 = new JLabel("all rights reserved ©");
        text2.setBounds(300,460,400,10);
        text2.setFont(new Font("Osward",Font.BOLD,10));
        add(text2);

        SignIn = new JButton("Sign In");
        SignIn.setBounds(300,330,80,30);
        SignIn.setBackground(Color.pink);
        SignIn.addActionListener(this);
        add(SignIn);

        clear = new JButton("clear");
        clear.setBounds(400,330,80,30);
        clear.setBackground(Color.pink);
        clear.addActionListener(this);
        add(clear);

        Signup = new JButton("SIGN UP");
        Signup.setBounds(300,390,180,30);
        Signup.setBackground(Color.pink);
        Signup.addActionListener(this);
        add(Signup);


        setSize(800,600);
        setVisible(true);
        setLocation(350,100);
        getContentPane().setBackground(Color.lightGray);
    }
    
    public void actionPerformed(ActionEvent ae){
        if( ae.getSource() == SignIn){
            con c = new con();
            String cn =cardNoEntry.getText().trim();
            char[] pass =passEntry.getPassword();
            String pn ="";
            for(char i : pass){
                pn+=i;
            }

            String query = "select * from login where cardno = '"+ cn +"' and pinno = '"+ pn +"'";

            pn =""; //to remove the password
            try{
                ResultSet rs = c.s.executeQuery(query);
               // System.out.println(rs.getString(1));
                if (rs.next()){
                    System.out.println(cn + "--" + pn);

                    new transaction(cn);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Use correct credentials");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
        else if (ae.getSource() == clear){
            cardNoEntry.setText("");
            passEntry.setText("");

        }
        else if (ae.getSource() == Signup){
            new signUp1();
        }
    }
    public static void main(String[] args) {
        new Login();

    }
}

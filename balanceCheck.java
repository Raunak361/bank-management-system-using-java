import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;



public class balanceCheck extends JFrame implements ActionListener{
    String cn ;
    JButton exit;

    balanceCheck(String cn){
        this.cn = cn;
        setSize(400,300);
        setLocation(350,100);
        setLayout(null);

        JLabel name = new JLabel("Name :");
        name.setBounds(30,60,200,15);
        name.setFont(new Font("Aerial", Font.BOLD,15));
        add(name);

        

        JLabel dateOfBirth = new JLabel("Birth Date :");
        dateOfBirth.setBounds(30,90,200,15);
        dateOfBirth.setFont(new Font("Aerial", Font.BOLD,15));
        add(dateOfBirth);

        JLabel cardno = new JLabel("Card no :");
        cardno.setBounds(30,120,200,15);
        cardno.setFont(new Font("Aerial", Font.BOLD,15));
        add(cardno);

        JLabel totalBalance = new JLabel("Total Balance :");
        totalBalance.setBounds(30,150,200,15);
        totalBalance.setFont(new Font("Aerial", Font.BOLD,15));
        add(totalBalance);

        JLabel date = new JLabel("Date :");
        date.setBounds(150,10,80,15);
        date.setFont(new Font("Aerial", Font.BOLD,10));
        add(date);
        String Name = "";
        String birth = "";
        String totalbalance ="";
        con c = new con();
        String query = "select name , dateofbirth from customerdata c join customerdata2 c2 on c.formno = c2.formno where c2.cardno = '"+cn+"'";
        String query2 = "select totalbalance from accounts where cardno = '"+cn+"'";
        try{
            ResultSet rs = c.s.executeQuery(query);

            System.out.println("check 1");
            if (rs.next()){
                Name= rs.getString(1); 
                birth= rs.getString(2);
                System.out.println("check 2  " + name + " " +birth); // check 2

            }
            ResultSet rs2 = c.s.executeQuery(query2);
            if (rs2.next()){
                System.out.println("check 3");
                totalbalance = rs2.getString(1);
                System.out.println("check 4" + totalbalance);
            }
        } 
        catch(SQLException e){
            System.out.println(e);
        }

        JLabel nameFill = new JLabel(""+Name.toUpperCase());
        nameFill.setBounds(170,60,200,15);
        nameFill.setFont(new Font("Aerial", Font.BOLD,15));
        add(nameFill);

        JLabel birthFill = new JLabel(""+birth.toUpperCase());
        birthFill.setBounds(170,90,200,15);
        birthFill.setFont(new Font("Aerial", Font.BOLD,15));
        add(birthFill);

        JLabel cardFill = new JLabel(""+cn);
        cardFill.setBounds(170,120,200,15);
        cardFill.setFont(new Font("Aerial", Font.BOLD,15));
        add(cardFill);

        JLabel balanceFill = new JLabel(""+totalbalance);
        balanceFill.setBounds(170,150,200,15);
        balanceFill.setFont(new Font("Aerial", Font.BOLD,15));
        add(balanceFill);

        exit = new JButton("Exit");
        exit.setBounds(220,190,100,30);
        exit.setFont(new Font("aerial", Font.BOLD,20));
        exit.setBackground(Color.green);
        exit.addActionListener(this);
        add(exit);

        getContentPane().setBackground(Color.lightGray);
        setVisible(true);
    }

    public void actionPerformed (ActionEvent ae){
        if(ae.getSource() == exit){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new balanceCheck("");
    }
}

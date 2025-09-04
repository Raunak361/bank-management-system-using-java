import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class transaction extends JFrame implements ActionListener{

    JButton deposit ,withdrawal , balanceCheck,exit;
    String cn;

    transaction(String cn){
        this.cn=cn;

        setLayout(null);
        setTitle("Transaction");
        setSize(850, 800);
        setLocation(350, 20);

        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image I2 = I1.getImage().getScaledInstance(850,800,Image.SCALE_SMOOTH);
        ImageIcon I3 = new ImageIcon(I2);
        JLabel label = new JLabel(I3);
        label.setBounds(0,0,850,800);
        add(label);
        
        con c = new con();
        String name = "";
        String query = "select name from customerdata c join customerdata2 c2 on c.formno = c2.formno where c2.cardno = '"+cn+"'";
        try{
        ResultSet rs = c.s.executeQuery(query);
            if(rs.next()){
                name= rs.getString(1);
                rs.close();
            }
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        
        JLabel profile = new JLabel("Hello  Mr. " + name);
        profile.setBounds(115,200,300,28);
        profile.setFont(new Font( "Aerial" , Font.BOLD, 25));
        profile.setForeground(Color.black);
        label.add(profile);
        
        

        JLabel transaction = new JLabel("Please select your transaction");
        transaction.setBounds(175,260,300,20);
        transaction.setFont(new Font( "Aerial" , Font.BOLD, 20));
        transaction.setForeground(Color.white);
        label.add(transaction);

        deposit = new JButton("Deposit");
        deposit.setBounds(155,369,150,25);
        deposit.setFont(new Font("Aerial",Font.BOLD,20));
        deposit.setBackground(Color.yellow);
        deposit.addActionListener(this);
        label.add(deposit);

        withdrawal = new JButton("Withdrawal");
        withdrawal.setBounds(345,369,140,25);
        withdrawal.setFont(new Font("Aerial",Font.BOLD,20));
        withdrawal.setBackground(Color.yellow);
        withdrawal.addActionListener(this);
        label.add(withdrawal);

        balanceCheck = new JButton("Balance Check");
        balanceCheck.setBounds(155,407,330,25);
        balanceCheck.setFont(new Font("Aerial",Font.BOLD,20));
        balanceCheck.setBackground(Color.yellow);
        balanceCheck.addActionListener(this);
        label.add(balanceCheck);
        
        exit = new JButton("Exit");
        exit.setBounds(155,455,330,25);
        exit.setFont(new Font("Aerial",Font.BOLD,20));
        exit.setBorder(BorderFactory.createLineBorder(Color.red));
        exit.setBackground(Color.yellow);
        exit.setForeground(Color.red);
        exit.addActionListener(this);
        label.add(exit);



        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == deposit ){
            System.out.println("reached");
            try {
                new deposit(cn).setVisible(true);
                System.out.println("reached 2");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == withdrawal){
            new withdrawal(cn);
            setVisible(false);

        }
        else if(ae.getSource() == balanceCheck ){
            new balanceCheck(cn);

        }
        else if(ae.getSource() == exit){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new transaction("");
    }
}

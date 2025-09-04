import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class withdrawal extends JFrame implements ActionListener {
    JTextField amountField;
    JButton withdrawale , exit;
    String cn;
    withdrawal(String cn) {
        this.cn = cn;
        //setLayout(null);
        setSize(850,800);
        setLocation(350,20);
        setTitle("withdrawal page");
        getContentPane().setBackground(Color.lightGray);

        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image I2 = I1.getImage().getScaledInstance(850,800,Image.SCALE_DEFAULT);
        ImageIcon I3 = new ImageIcon(I2);
        JLabel label = new JLabel(I3);
        label.setBounds(0,0,850,800);
        add(label);




        JLabel withdrawalAmount = new JLabel("Enter the amount you want to withdrawal");
        withdrawalAmount.setBounds(180,332,300,10);
        withdrawalAmount.setFont(new Font("Aerial",Font.BOLD,10));
        withdrawalAmount.setForeground(Color.white);
        label.add(withdrawalAmount);


        amountField = new JTextField();
        amountField.setBounds(180,300,260,30);
        amountField.setFont(new Font("Aerial",Font.BOLD,30));
        label.add(amountField);

        withdrawale = new JButton("Enter");
        withdrawale.setBounds(180,390,120,30);
        withdrawale.setFont(new Font("Aerial",Font.BOLD,20));
        withdrawale.setBackground(Color.green);
        withdrawale.addActionListener(this);
        label.add(withdrawale);

        exit = new JButton("Exit");
        exit.setBounds(320,390,120,30);
        exit.setFont(new Font("Aerial",Font.BOLD,20));
        exit.setBackground(Color.green);
        exit.addActionListener(this);
        label.add(exit);

        setVisible(true);



    }
    public void actionPerformed(ActionEvent ae) {
        String amount = amountField.getText();


        if (ae.getSource() == withdrawale) {
            if (amountField.equals("")) {
                JOptionPane.showMessageDialog(null, "Amount required");
            } else {

                con c = new con();
                String query0 =  "select totalBalance from accounts where cardno = '"+cn+"' and totalBalance > '"+amount+"'";
                try {
                    ResultSet rs = c.s.executeQuery(query0);
                    if(rs.next()) {
                        String query1 = "update accounts set totalBalance = totalBalance - " + amount + " where cardno = '" + cn + "'";
                        c.s.executeUpdate(query1);
                        JOptionPane.showMessageDialog(null, ""+amount+" deducted from account \n Collect cash at  counter");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Insufficient Balance");

                    }
                }
                catch (SQLException e) {
                    System.out.println(e);
                }
            }
        } else if (ae.getSource() == exit) {
            setVisible(false);
        }



    }


    public static void main(String[] args) {
        new withdrawal("");
    }
}




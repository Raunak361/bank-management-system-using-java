import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class deposit extends JFrame implements ActionListener {
JTextField amountField;
JButton deposite , exit;
String cn;
    deposit(String cn) {
        this.cn = cn;
        //setLayout(null);
        setSize(850,800);
        setLocation(350,20);
        setTitle("deposit page");
        getContentPane().setBackground(Color.lightGray);

        ImageIcon I1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image I2 = I1.getImage().getScaledInstance(850,800,Image.SCALE_DEFAULT);
        ImageIcon I3 = new ImageIcon(I2);
        JLabel label = new JLabel(I3);
        label.setBounds(0,0,850,800);
        add(label);




        JLabel depositAmount = new JLabel("Enter the amount you want to deposit");
        depositAmount.setBounds(180,332,300,10);
        depositAmount.setFont(new Font("Aerial",Font.BOLD,10));
        depositAmount.setForeground(Color.white);
        label.add(depositAmount);


        amountField = new JTextField();
        amountField.setBounds(180,300,260,30);
        amountField.setFont(new Font("Aerial",Font.BOLD,30));
        label.add(amountField);

        deposite = new JButton("Enter");
        deposite.setBounds(180,390,120,30);
        deposite.setFont(new Font("Aerial",Font.BOLD,20));
        deposite.setBackground(Color.green);
        deposite.addActionListener(this);
        label.add(deposite);

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
        if (ae.getSource() == deposite) {
            if (amountField.equals("")) {
                JOptionPane.showMessageDialog(null, "Amount required");
            } else {

                con c = new con();

                String query1 = "update accounts set totalBalance = totalBalance + " + amount + " where cardno = '" + cn + "'";
                try {

                    c.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null, "updated successfully");


                } catch (SQLException e) {
                    System.out.println(e);
                }
            }
        } else if (ae.getSource() == exit) {
            setVisible(false);
        }


    }


    public static void main(String[] args) {
            new deposit("");
    }
}


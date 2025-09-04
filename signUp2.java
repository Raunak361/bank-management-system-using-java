import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class signUp2 extends JFrame implements ActionListener{
    JLabel title ,type ,cardNo, pinNo,DcardNo,DpinNo,services;
    JRadioButton current , saving ,fixed, recurring ;
    JCheckBox c1,c2,c3,c4,c5,c6;
    JButton submit , cancel;
    String cardNO,pinNO;

    signUp2(){

        setLayout(null);
        setSize(850,800);
        setLocation(350,20);
        setTitle("signUp2");
        setVisible(true);
        getContentPane().setBackground(Color.lightGray);


        title = new JLabel("Final SignUp Page");
        title.setBounds(260, 20, 800, 50);
        title.setFont(new Font("Raleway",Font.BOLD,40));
        add(title);


        type = new JLabel("Account Type");
        type.setBounds(150, 140, 140, 20);
        type.setFont(new Font("Arial", Font.BOLD, 15));
        add(type);
        
        current = new JRadioButton("Current Account");
        current.setBounds(200,180,240,20);
        current.setFont(new Font("Arial", Font.BOLD,15));
        add(current);

        saving = new JRadioButton("Saving Account");
        saving.setBounds(450,180,240,20);
        saving.setFont(new Font("Arial", Font.BOLD,15));
        add(saving);


        fixed = new JRadioButton("Fixed Account");
        fixed.setBounds(200,220,240,20);
        fixed.setFont(new Font("Arial", Font.BOLD,15));
        add(fixed);


        recurring = new JRadioButton("Recurring Account");
        recurring.setBounds(450,220,240,20);
        recurring.setFont(new Font("Arial", Font.BOLD,15));
        add(recurring);

        ButtonGroup account = new ButtonGroup();
        account.add(saving);
        account.add(fixed);
        account.add(recurring);
        account.add(current);

        
        cardNo = new JLabel("Card No.");
        cardNo.setBounds(150,280,200,20);
        cardNo.setFont(new Font("Aerial", Font.BOLD,15));
        add(cardNo);

        pinNo = new JLabel("Pin No.");
        pinNo.setBounds(150,320,200,20);
        pinNo.setFont(new Font("Aerial", Font.BOLD,15));
        add(pinNo);

        DcardNo = new JLabel("XXXX-XXXX-XXXX- 4567");
        DcardNo.setBounds(240,280,200,20);
        DcardNo.setFont(new Font("Aerial", Font.BOLD,15));
        add(DcardNo);

        DpinNo = new JLabel("XXXX");
        DpinNo.setBounds(240,320,200,20);
        DpinNo.setFont(new Font("Aerial", Font.BOLD,15));
        add(DpinNo);

        services = new JLabel("Services Required");
        services.setBounds(150,360,200,20);
        services.setFont(new Font("Aerial", Font.BOLD,15));
        add(services);
        
        c1 = new JCheckBox("ATM Services");
        c1.setBounds(200,400,200,20);
        c1.setFont(new Font("Aerial", Font.BOLD,15));
        add(c1);

        c2 = new JCheckBox(" Internet Banking");
        c2.setBounds(450,400,200,20);
        c2.setFont(new Font("Aerial", Font.BOLD,15));
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBounds(200,440,200,20);
        c3.setFont(new Font("Aerial", Font.BOLD,15));
        add(c3);

        c4 = new JCheckBox("Emails & SMS Services");
        c4.setBounds(450,440,200,20);
        c4.setFont(new Font("Aerial", Font.BOLD,15));
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBounds(200,480,200,20);
        c5.setFont(new Font("Aerial", Font.BOLD,15));
        add(c5);

        c6 = new JCheckBox("E Statement");
        c6.setBounds(450,480,200,20);
        c6.setFont(new Font("Aerial", Font.BOLD,15));
        add(c6);
        
        submit = new JButton("Submit");
        submit.setBounds(450,560,100,40);
        submit.setFont(new Font("Aerial", Font.BOLD , 20));
        submit.setBackground(Color.PINK);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(260,560,100,40);
        cancel.setFont(new Font("Aerial", Font.BOLD , 20));
        cancel.setBackground(Color.PINK);
        cancel.addActionListener(this);
        add(cancel);

    }

    public void actionPerformed(ActionEvent ae){

        if ( ae.getSource() == submit){
            String accountType = null;   //current , saving ,fixed, recurring
            if(current.isSelected()){
                accountType = "current account";

            }
            else if(saving.isSelected()){
                accountType = "saving account";
            }
            else if(fixed.isSelected()){
                accountType = "fixed account";
            }
            else if(recurring.isSelected()){
                accountType = "recurring account";
            }

            Random rand = new Random();
            cardNO = "" + (1_0000_0000_0000_000L + (Math.abs(rand.nextLong()) % 9_0000_0000_0000_000L));
            pinNO = "" + (1000 + (Math.abs(rand.nextInt()) % 9000));
            String services = "";
            if(c1.isSelected()){
                services =services + "ATM service";
            }
            if(c2.isSelected()){
                services =services + "  internet service";
            }

            if(c3.isSelected()) {
                services = services + "  Mobile Bankinng";

            }
            if(c4.isSelected()){
                services =services + "  Email and SMS Alerts";
            }
            if(c5.isSelected()){
                services =services + "  Cheque Book";

            }
            if(c6.isSelected()){
                services =services + "  E- Statement";
            }

            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type required");

                }
                else{
                    con c = new con();
                    String query = "Select max(formno) from customerdata;";
                    ResultSet rs = c.s.executeQuery(query);
                    String formno = null;
                    if(rs.next()){
                        formno ="" + rs.getInt(1);
                    }
                    String query1 = "INSERT INTO customerdata2 (formno, accounttype, cardno, pinno, services) " +
                            "VALUES (" + formno + ", '" + accountType + "', '" + cardNO + "', '" + pinNO + "', '" + services + "')";

                    String query2 = "Insert into login(cardno,pinno)"+ "values('"+cardNO+"','"+pinNO+"')";
                    String query3 = "insert into accounts(cardno )" + "values('"+cardNO+"')";

                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    c.s.executeUpdate(query3);
                    rs.close();
                    JOptionPane.showMessageDialog(null, "Card no:  " + cardNO +"\n"+ "Pin no:  " + pinNO);
                    setVisible(false);
                }
            }
            catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        else if (ae.getSource() == cancel){

        }



    }

    public static void main(String[] args) {
        signUp2 a = new signUp2();
    }
}

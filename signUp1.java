import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.sql.ResultSet;

public class signUp1 extends JFrame implements ActionListener{
    JButton submit,clear,prev,next;
    JTextField nameTF,fatherNameTF,stateTF,pinCodeTF,addressTF,emailTF,cityTF;
    JRadioButton male_genderTF,female_genderTF,married,unmarried,other;
    JDateChooser dateChooser;

    
    public int i ; //it stores form no. retrieved from database.

    signUp1() {
        try {
            con c = new con();
            ResultSet j = c.s.executeQuery("select formno from customerdata order by formno desc limit 1");
            if (j.next()) {
                i = j.getInt("formno") + 1;
            } else {
                i = 1; // First form
            }
        } catch (Exception e) {
            System.out.println(e);
            i = 1; // Fallback
        }
        setSize(850, 800);
        setLocation(350, 20);
        setTitle("Sign UP Frame 1");
        getContentPane().setBackground(Color.lightGray);
        setLayout(null);

        JLabel formNo = new JLabel("Application No. " + i);
        formNo.setBounds(350, 20, 800, 50);
        formNo.setFont(new Font("Arial", Font.BOLD, 40));
        add(formNo);

        JLabel page1 = new JLabel("Page 1 : Personal Details");
        page1.setBounds(350, 80, 500, 20);
        page1.setFont(new Font("Arial", Font.BOLD, 15));
        add(page1);

        JLabel name = new JLabel("Name:");
        name.setBounds(150, 140, 140, 20);
        name.setFont(new Font("Arial", Font.BOLD, 15));
        add(name);

         nameTF = new JTextField();
        nameTF.setBounds(350, 140, 400, 20);
        nameTF.setFont(new Font("Arial", Font.BOLD, 15));
        add(nameTF);

        JLabel fatherName = new JLabel("Father's Name:");
        fatherName.setBounds(150, 180, 400, 20);
        fatherName.setFont(new Font("Arial", Font.BOLD, 15));
        add(fatherName);

        fatherNameTF = new JTextField();
        fatherNameTF.setBounds(350, 180, 400, 20);
        fatherNameTF.setFont(new Font("Arial", Font.BOLD, 15));
        add(fatherNameTF);

        JLabel dateOfBirth = new JLabel("Date of Birth:");
        dateOfBirth.setBounds(150, 220, 400, 20);
        dateOfBirth.setFont(new Font("Arial", Font.BOLD, 15));
        add(dateOfBirth);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(350, 220, 400, 20);
        add(dateChooser);



        JLabel gender = new JLabel("Gender:");
        gender.setBounds(150, 260, 400, 20);
        gender.setFont(new Font("Arial", Font.BOLD, 15));
        add(gender);

        male_genderTF = new JRadioButton("Male");
        male_genderTF.setBounds(350, 260, 60, 20);
        male_genderTF.setBackground(Color.white);
        add(male_genderTF);

        female_genderTF = new JRadioButton("Female");
        female_genderTF.setBounds(440, 260, 90, 20);
        female_genderTF.setBackground(Color.white);
        add(female_genderTF);

        ButtonGroup genderTF = new ButtonGroup();
        genderTF.add(male_genderTF);
        genderTF.add(female_genderTF);



        JLabel email = new JLabel("Email address:");
        email.setBounds(150, 300, 400, 20);
        email.setFont(new Font("Arial", Font.BOLD, 15));
        add(email);

        emailTF = new JTextField();
        emailTF.setBounds(350, 300, 400, 20);
        emailTF.setFont(new Font("Arial", Font.BOLD, 15));
        add(emailTF);

        JLabel maritalStatus = new JLabel("Marital Status:");
        maritalStatus.setBounds(150, 340, 400, 20);
        maritalStatus.setFont(new Font("Arial", Font.BOLD, 15));
        add(maritalStatus);



        married = new JRadioButton("married");
        married.setBounds(350, 340, 100, 20);
        married.setBackground(Color.white);
        add(married);

        unmarried = new JRadioButton("unmarried");
        unmarried.setBounds(470, 340, 100, 20);
        unmarried.setBackground(Color.white);
        add(unmarried);

        other = new JRadioButton("other");
        other.setBounds(590, 340, 100, 20);
        other.setBackground(Color.white);
        add(other);

        ButtonGroup maritalStatusTF = new ButtonGroup();
        maritalStatusTF.add(married);
        maritalStatusTF.add(unmarried);
        maritalStatusTF.add(other);


        JLabel address = new JLabel("Address:");
        address.setBounds(150, 380, 400, 20);
        address.setFont(new Font("Arial", Font.BOLD, 15));
        add(address);

        addressTF = new JTextField();
        addressTF.setBounds(350, 380, 400, 20);
        addressTF.setFont(new Font("Arial", Font.BOLD, 15));
        add(addressTF);

        JLabel city = new JLabel("City:");
        city.setBounds(150, 420, 80, 20);
        city.setFont(new Font("Arial", Font.BOLD, 15));
        add(city);

        cityTF = new JTextField();
        cityTF.setBounds(350, 420, 400, 20);
        cityTF.setFont(new Font("Arial", Font.BOLD, 15));
        add(cityTF);

        JLabel state = new JLabel("State:");
        state.setBounds(150, 460, 400, 20);
        state.setFont(new Font("Arial", Font.BOLD, 15));
        add(state);

        stateTF = new JTextField();
        stateTF.setBounds(350, 460, 400, 20);
        stateTF.setFont(new Font("Arial", Font.BOLD, 15));
        add(stateTF);

        JLabel pinCode = new JLabel("Pin Code:");
        pinCode.setBounds(150, 500, 400, 20);
        pinCode.setFont(new Font("Arial", Font.BOLD, 15));
        add(pinCode);

        pinCodeTF = new JTextField();
        pinCodeTF.setBounds(350, 500, 400, 20);
        pinCodeTF.setFont(new Font("Arial", Font.BOLD, 15));
        add(pinCodeTF);

       /* submit = new JButton("Submit");
        submit.setBounds(500,550,100,40);
        submit.setFont(new Font("Arial",Font.BOLD,20));
        submit.addActionListener(this);
        submit.setBackground(Color.pink);
        add(submit);*/

        clear = new JButton("Clear");
        clear.setBounds(400,550,100,40);
        clear.setFont(new Font("Ariel",Font.BOLD,20));
        clear.addActionListener(this);
        clear.setBackground(Color.pink);
        add(clear);

        prev = new JButton("Prev");
        prev.setBounds(600,550,100,40);
        prev.setFont(new Font("Ariel",Font.BOLD,20));
        prev.addActionListener(this);
        prev.setBackground(Color.pink);
        add(prev);

        next = new JButton("Next");
        next.setBounds(500,550,100,40);
        next.setFont(new Font("Ariel",Font.BOLD,20));
        next.addActionListener(this);
        next.setBackground(Color.pink);
        add(next);


        setVisible(true); // Should be called after adding components
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == prev){
           new Login();
        }
        else if (ae.getSource() == clear){
            nameTF.setText("");
        }
        else if (ae.getSource() == next){


            String name =  nameTF.getText();
            String father =  fatherNameTF.getText();
            String state = stateTF.getText();
            String pincode = pinCodeTF.getText();
            String address = addressTF.getText();
            String email = emailTF.getText();
            String city = cityTF.getText();
            String date=((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
            String gender = "null";
            if (male_genderTF.isSelected()){
                gender = "male";

            }
            else if (female_genderTF.isSelected()){
                gender = "female";
            }
            String maritalStatus = "other";
            if (married.isSelected()){
                maritalStatus = "married";
            }
            else if (unmarried.isSelected()){
                maritalStatus = "unmarried";
            }
            try {
                if (name.equals("")) {
                    JOptionPane.showMessageDialog(null, "Name is required");

                }
                else {
                    con c = new con();
                    String query ="insert into customerdata(name,fathername,gender,marrige,dateofbirth,email,pincode,state,city,address) values('"+ name + "','" +father+"','"+gender+"','"+maritalStatus+"','"+date+"','"+email+"','"+pincode+"','"+state+"','"+city+"','"+address+"')";
                    c.s.executeUpdate(query);

                    JOptionPane.showMessageDialog(null,"Page one saved");
                    setVisible(false);
                    new signUp2();
                }



            }
            catch(Exception e){
                System.out.println(e);
            }
        }

    }

    public static void main(String[] args) {
        new signUp1();
    }
}



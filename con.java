import java.sql.*;
public class con {
    Connection c;
    Statement s;
    public con(){
        try{
            //Class.forName(com.mysql.cj.jdbc.Driver);
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","1234");
            s = c.createStatement();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}







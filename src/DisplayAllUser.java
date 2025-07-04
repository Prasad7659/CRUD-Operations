package src;
import java.sql.*;

public class DisplayAllUser {
    public void displayallusers(){
        ConnectDB db = new ConnectDB();
        String query = "SELECT * FROM user";
        try{
            Class.forName(db.Driver);
            Connection con = DriverManager.getConnection(db.url, db.user, db.pass);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                System.out.println(rs.getString("Name")+" "+rs.getString("UserID")+" "+rs.getInt("Age")+" "+rs.getString("email"));
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    
}

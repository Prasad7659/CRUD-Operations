package src;
import java.util.*;
import java.sql.*;

public class DisplayUser {
    public void displayuser(){
        String query = "SELECT * FROM user where UserID = ?";
        Scanner in = new Scanner(System.in);
        System.out.println("Enter User ID");
        String id = in.nextLine();
        ConnectDB db = new ConnectDB();
        try{
            Class.forName(db.Driver);
            Connection con = DriverManager.getConnection(db.url,db.user,db.pass);
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, id);
            ResultSet res = pstmt.executeQuery();
            while(res.next()){
                System.out.println(res.getString("Name")+" "+res.getString("UserID")+" "+res.getInt("Age")+" "+res.getString("email"));
            }
            con.close();
        }
        catch(Exception e){
            System.out.println("Driver not found");
        }
        in.close();
    }
    
}

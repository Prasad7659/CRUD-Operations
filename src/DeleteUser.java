package src;
import java.util.*;
import java.sql.*;

public class DeleteUser {
    public void deleteuser(){
        String Dquery = "DELETE FROM user WHERE UserID = ?;";
        String Squery = "Select * from user;";
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the id of the user you want to delete");
        String id = in.nextLine();
        ConnectDB db = new ConnectDB();
        try{
            Class.forName(db.Driver);
            Connection con = DriverManager.getConnection(db.url,db.user,db.pass);
            PreparedStatement pstmt = con.prepareStatement(Dquery);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(Squery);
            while(res.next()){
                System.out.println(res.getString(1)+" "+res.getString(2)+" "+res.getInt(3)+" "+res.getString(4));
            }
            con.close();
        }
        catch(Exception e){
            System.out.println("Error");
            System.err.println(e);
        }
        in.close();
        
    }
}

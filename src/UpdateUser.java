package src;
import java.util.*;
import java.sql.*;
public class UpdateUser {
    public void updateuser(){
        ConnectDB db = new ConnectDB();
        String uquery = "Update User Set Name = ?, Age = ? where UserID = ?;";
        String squery = "Select * from user where UserID = ?;";
        Scanner in = new Scanner(System.in);
        System.out.println("Enter User ID");
        String UserID = in.nextLine();
        System.out.println("Enter Updated name");
        String Name = in.nextLine();
        System.out.println("Enter Updated Age");
        int Age = in.nextInt();
        try{
            Class.forName(db.Driver);
            Connection con = DriverManager.getConnection(db.url, db.user, db.pass);
            PreparedStatement upstmt = con.prepareStatement(uquery);
            upstmt.setString(1, Name);
            upstmt.setInt(2, Age);
            upstmt.setString(3, UserID);
            upstmt.executeUpdate();
            PreparedStatement sstmt = con.prepareStatement(squery);
            sstmt.setString(1, UserID);
            ResultSet rs = sstmt.executeQuery();
            while(rs.next()){
                System.out.println("User Updated");
                System.out.println(rs.getString("Name")+" "+rs.getString("UserID")+" "+ rs.getInt("Age")+" "+rs.getString("email"));
            }
            con.close();
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        in.close();
    }
    
}

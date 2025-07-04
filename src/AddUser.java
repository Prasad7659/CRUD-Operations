package src;
import java.sql.*;
import java.util.*;

public class AddUser{
    ConnectDB db = new ConnectDB();
    Scanner in = new Scanner(System.in);
    public void adduser() {
        System.out.println("EnterName: ");
        String name = in.nextLine();
        System.out.println("Enter UserID: ");
        String id = in.nextLine();
        System.out.println("EnterAge: ");
        int age = in.nextInt();
        in.nextLine();
        System.out.println("EnterEmail: ");
        String email = in.nextLine();
        System.out.println("Enter Password: ");
        String password = in.nextLine();
        try {
            Class.forName(db.Driver);
            Connection con = DriverManager.getConnection(db.url, db.user, db.pass);
            String query = "insert into user values(?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, id);
            pstmt.setInt(3, age);
            pstmt.setString(4, email);
            pstmt.setString(5, password);
            pstmt.executeUpdate();
            con.close();
            System.out.println("Added Successfully");
        }
        catch (Exception e) {
            System.out.println("Error");
            System.out.println(e);
        }
    }
}


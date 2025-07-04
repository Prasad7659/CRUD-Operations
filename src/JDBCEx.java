package src;
import java.util.*;
public class JDBCEx{
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        System.out.println("1. Add new User");
        System.out.println("2. Delete User");
        System.out.println("3. Update User");
        System.out.println("4. Display User");
        System.out.println("5. Display All Users");
        int n = in.nextInt();
        
        switch(n){
            case 1: 
                    AddUser newuser = new AddUser();
                    newuser.adduser();
                    break;
            case 2: DeleteUser ru = new DeleteUser();
                    ru.deleteuser();
                    break;
            case 3: UpdateUser uu = new UpdateUser();
                    uu.updateuser();
                    break;
            case 4: DisplayUser du = new DisplayUser();
                    du.displayuser();
                    break;
            case 5: DisplayAllUser da = new DisplayAllUser();
                    da.displayallusers();
                    break;
                    
        }
        in.close();
    }
}
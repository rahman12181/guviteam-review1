import java.util.Scanner;

public class LogOut {

    public void logout(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Are You Sure Want To Loging out...!");
        System.out.println("1.Yes");
        System.out.println("2.NO");
        System.out.println("LogOut Enter(yes) And Enter (NO) For Stay");
        int logout=scanner.nextInt();

        switch (logout) {
            case 1:
                YesLogout logoutconfirm=new YesLogout();
                logoutconfirm.yesLogout();
                return;
            case 2:
               OnlineHealthcareManagementSystem no=new OnlineHealthcareManagementSystem();
               
                break;
            default:
            System.out.println("Getting some problem to logout.....");
                break;
        }
    }
}

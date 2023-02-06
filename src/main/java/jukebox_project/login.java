package jukebox_project;
import java.sql.*;
import java.util.Scanner;

public class login extends  database {
    Connection con;
    Users details;
    Scanner sc = new Scanner(System.in);
    String useremail = "";
    String userpassword = "";
    String username = "";

    public void registerNewUser() throws Exception {
        details = new Users();
        con = getConnection();

        System.out.println("--->Please Create Your ID: ");
        int id = sc.nextInt();
        details.setUserId(id);
        System.out.println("--->Please Enter Your Name : ");
        String nameOfUser = sc.next();
        details.setUserName(nameOfUser);
        ;
        System.out.println("--->Please Enter Your E-Mail ID : ");
        String userName = sc.next();
        details.setUserName(userName);
        System.out.println("--->Please Create Your Password: ");
        String pass = sc.next();
        details.setPassword(pass);
        try {
            Statement st = con.createStatement();
            //get users id,name,password,mail
            int result = st.executeUpdate("insert into user values(" + details.getUserId() + ", '" + details.getUserName() + "', '" + details.getUserName() + "', '" + details.getPassword() + "');");
            System.out.println(result + " Registration is completed. Please use username and password for login purpose.");
        } catch (SQLException e) {
            throw new Exception("Registration failed: " + e.getMessage());

        }

    }

    public String loginUser() throws Registration {
        con = getConnection();
        System.out.println(" --->Please Enter Your E-Mail : ");
        String userEmail = sc.next();
        System.out.println(" ---> Please Enter Your Password : ");
        String pass = sc.next();
        try {
            String loginDet = "select * from user";
            con = getConnection();
            PreparedStatement stmt = con.prepareStatement(loginDet);
            ResultSet rs = stmt.executeQuery();

            String email = "";
            String pword = "";
            String name = "";
            while (rs.next()) {
                email = rs.getString("useremail");
                pword = rs.getString("userpassword");
                name = rs.getString("username");
                if (userEmail.equals(email) && pass.equals(pword)) {
                    System.out.println(name + " has logged in successfully.");
                    return name;
                }
            }

            System.out.println("Check username and password again, Login Failed!!");

            System.out.println("Press 1 to Enter Details Again or Press 2 to Exit");
            int ans = sc.nextInt();
            switch (ans) {
                case 1:
                    return loginUser();
                case 2:
                    System.exit(0);
            }
            //handle exceptions
        } catch (SQLException e) {
            throw new Registration("Login failed: " + e.getMessage());
        }

        return null;
    }
}



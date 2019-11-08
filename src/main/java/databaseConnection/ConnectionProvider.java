package databaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionProvider {


    //Vi anvender kode fra denne her side i porjektet https://stackoverflow.com/questions/37909487/how-can-i-connect-to-mariadb-using-java

    //start medat erklære attributter:
    private static Connection con = null;
    private static String databasenavn, url, user, password;
    private Statement stmt = null;
    private static final String driver = "org.mariadb.jdbc.Driver";
//vores skema hedder ejournal
    // private String databasenavn, url,user,password;


    public static void main(String[] args) {
//ConnectionProvider cp =new ConnectionProvider();
//cp.connectToLocal("127.0.0.1");
        connectToLocal("130.225.170.222");
        //Husk at når I tilgår en anden IP, så ændrer I følgende i jeres nye connection:
        //IP, username, password og databasenavnet

    }


    public static Connection connectToLocal(String ipaddress) {
        try {
//for lokale maskiness
            //String  driver = "org.sqlite.JDBC";
//definer din drve til at være Mariadb i stedet for SQLITE
            Class.forName(driver);
            System.out.println("Forbinder ....");
            databasenavn = "ejournal";
            url = "jdbc:mariadb://" + ipaddress + ":3306/" + databasenavn;
            System.out.println("Ip er" + ipaddress);
            user = "server07";
            //for atconnectetil
            password = "eze";


            con = DriverManager.getConnection(url, user, password);
            System.out.println("Hej");
        } catch (SQLException | ClassNotFoundException sqe) {

            // url = "jdbc:mariadb://"+"localhost"+"/"+databasenavn;
            // con = DriverManager.getConnection(url,user,password);
            sqe.printStackTrace();
        }
        return con;
    }



   /* public static Connection getConnection() {

        if (con != null)
            return con;
        else {
            try {
//for lokale maskine
                String driver = "org.sqlite.JDBC";
                String url = "jdbc:sqlite:C:/sqlite/db/raziasDB";
                String user = "server07";
                String password = "eze2qDuBAwxnTQC2";
                Class.forName(driver);
                con = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException cnfe) {
                System.out.println(cnfe);
                cnfe.printStackTrace();
            } catch (SQLException sqe) {
                System.out.println(sqe);
                sqe.printStackTrace();
            }
            return con;
        }

    }*/


}
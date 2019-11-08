package daoClasses;

import databaseConnection.ConnectionProvider;
import entitites.Appointment;
import org.mariadb.jdbc.internal.logging.Logger;
import org.mariadb.jdbc.internal.logging.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {

    private Connection conn;
    private Statement statement;

    public AppointmentDAO() {
        conn = ConnectionProvider.connectToLocal("130.225.170.222");
    }
    public List<Appointment> getAllAppointmentsForId(int personId) throws SQLException {
        statement = conn.createStatement();
        //String query = "select * from Appointment where personid="+personId+";";
        String query = "select * from Appointment where personid in (select id from Person where CPR = "+personId+");";
        ResultSet set = statement.executeQuery(query);

        List<Appointment> allAppointments = new ArrayList<>();
        while(set.next()){
            int id = Integer.parseInt(set.getString("ID"));
            Date dato = Date.valueOf(set.getString("Dato"));
            int varighed = Integer.parseInt(set.getString("Varighed"));
            String type = set.getString("UndersoegelseType");
            int sygehusID = Integer.parseInt(set.getString("SygehusId"));
            Appointment appointment = new Appointment(id, dato, varighed, type, sygehusID, personId);
            allAppointments.add(appointment);
        }
        return allAppointments;
    }

    public void removeAppointment(int appointmentID) throws SQLException {
        statement = conn.createStatement();
        String query = "delete from Appointment where id="+appointmentID+";";
        statement.executeUpdate(query);
    }
}

package servlets;

import daoClasses.AppointmentDAO;
import entitites.Appointment;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/appointment/*")
public class AppointmentServlet extends HttpServlet {

    AppointmentDAO appointmentDAO = new AppointmentDAO();

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        HttpSession session = request.getSession(true);

      // int userID =  Integer.parseInt(session.getAttribute("currentUserId"));
        int userID = (Integer) session.getAttribute("currentUserId");
        try {
            List<Appointment> curentAppointments = appointmentDAO.getAllAppointmentsForId(userID);
            request.setAttribute("allAppointments",curentAppointments);

            //Dispatching request

            RequestDispatcher dispatcher = request.getRequestDispatcher("appointment-page.jsp");

            if (dispatcher != null) {
                dispatcher.forward(request, response);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

package servlets;

import daoClasses.AppointmentDAO;
import entitites.Appointment;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
@WebServlet("/delete/*")
public class DeleteServlet {

    AppointmentDAO appointmentDAO = new AppointmentDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {

        try {
           int id = Integer.parseInt(request.getParameter("id"));
           appointmentDAO.removeAppointment(id);

            ServletContext servletContext = request.getSession().getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/appointment");
            requestDispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

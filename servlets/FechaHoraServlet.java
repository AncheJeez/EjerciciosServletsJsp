/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AndJe
 */
@WebServlet(name = "FechaHoraServlet", urlPatterns = {"/FechaHoraServlet"})
public class FechaHoraServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FechaHoraServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FechaHoraServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        // Obtener la cabecera "Accept-Language" del navegador
        String lenguaje = request.getHeader("Accept-Language");
        Locale localeCliente;
        if (lenguaje != null && !lenguaje.isEmpty()) {
            localeCliente = Locale.forLanguageTag(lenguaje.split(",")[0]); // Tomamos el primer lenguaje preferido
        } else {
            localeCliente = request.getLocale(); // Fallback a la configuración del request
        }

        // Obtener fecha y hora actual
        ZonedDateTime ahora = ZonedDateTime.now();

        // Formatear fecha y hora según el locale del cliente
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("EEEE, d MMMM yyyy HH:mm:ss z", localeCliente);

        String fechaFormateada = ahora.format(formato);

        // Generar respuesta HTML
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Fecha y Hora del Servidor</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Fecha y hora actual del servidor</h1>");
            out.println("<p>" + fechaFormateada + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

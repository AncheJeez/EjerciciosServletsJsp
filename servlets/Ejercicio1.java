/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.ModeloPIN;

/**
 *
 * @author jose
 */
@WebServlet(name = "Ejercicio1", urlPatterns = {"/Ejercicio1"})
public class Ejercicio1 extends HttpServlet {

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
        boolean validado = false;
        boolean completado = false;
        HttpSession sesion = request.getSession();
        ModeloPIN modelo = (ModeloPIN)sesion.getAttribute("modelo");
        // Si no hay modelo en la sesión, lo creamos
        if (modelo == null) {
            modelo = new ModeloPIN("123456");
            sesion.setAttribute("modelo", modelo);
        }
        // Si se recibe "aceptar"
        if (request.getParameter("aceptar") != null) {
            completado = true;
            if (modelo.validar()) {
                validado = true;
                sesion.invalidate();
            }
        // Si se recibe "borrar"
        } else if (request.getParameter("borrar") != null) {
            modelo.borrarIntento();
        // Si se recibe una posición
        } else if (request.getParameter("posicion") != null) {
            modelo.insertarPosicion(Integer.parseInt(request.getParameter("posicion")));
        }
        // obtenemos el pin para mostrarlo
        List<Integer> pin = modelo.getPin();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login</title>");            
            out.println("</head>");
            out.println("<body>");
            // Si se ha validado correctamente
            if (validado) {
                out.println("<h1>Validación Correcta</h1>");
            // Si se ha validado incorrectamente
            } else if (completado) { 
                out.println("<h1>Validación Incorrecta</h1>");
            // en otro caso, mostramos los botones con los números
            } else {
                out.println("<h2>Introduzca PIN</h2>");
                out.println("<table><tr>");
                for (int i = 0; i < pin.size(); i++) {
                    out.println("<td>");
                    out.println("<form method='post'>");
                    out.println("<input type='hidden' name='posicion' value='" + i + "'>");
                    out.println("<input type='submit' value='" + pin.get(i) + "'>");
                    out.println("</form>");
                    out.println("</td>");
                }
                out.println("</table>");
                out.println("<form method='post'>");
                out.println("<input type='submit' name='aceptar' value='Aceptar'>");
                out.println("</form>");
                out.println("<form method='post'>");
                out.println("<input type='submit' name='borrar' value='Borrar'>");
                out.println("</form>");
            }

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
        processRequest(request, response);
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

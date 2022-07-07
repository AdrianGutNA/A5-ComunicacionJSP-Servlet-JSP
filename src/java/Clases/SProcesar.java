package Clases;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SProcesar", urlPatterns = {"/SProcesar"})
public class SProcesar extends HttpServlet 
{
    
    private Alumnos alumno[] = new Alumnos[10];
    private int cont = 0;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        
         if (request.getParameter("btnGuardar") != null) 
         {
            alumno[cont] = new Alumnos("", "", "", "", "", "", "", 0.0);
            alumno[cont].setMatricula(request.getParameter("tfMatricula"));
            alumno[cont].setNombre(request.getParameter("tfNombre"));
            alumno[cont].setApellidoPaterno(request.getParameter("tfApellidoPaterno"));
            alumno[cont].setApellidoMaterno(request.getParameter("tfApellidoMaterno"));
            alumno[cont].setDdi(request.getParameter("tfDdi"));
            alumno[cont].setDwi(request.getParameter("tfDwi"));
            alumno[cont].setEcbd(request.getParameter("tfEcbd"));
            cont++;
             
            request.setAttribute("datos", alumno);            
            request.setAttribute("cont", cont);
             
            if(cont == 10)
            {
                cont = 0;
            }
            
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
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

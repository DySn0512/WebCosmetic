package demo.demoweb.Servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "product", value = "/product")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String url = "/product.jsp";
        if (action == null) {

        }
        else if (action.equals("find")) {

        }
        else if (action.equals("add")) {
            url = "/product_info.jsp";
        }
        else if(action.equals("update")){

        }
        else{

        }
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}

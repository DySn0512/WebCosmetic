/*
package com.example.webcosmetic.Authentication;

import com.example.webcosmetic.Entity.User;
import com.example.webcosmetic.EntityDB.AccountDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Date;

@WebServlet(urlPatterns = {"/register"})
public class Register {
    public class register extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            String message = null;
            String url = "/login_customer.jsp";

            String name = req.getParameter("name");
            String phone = req.getParameter("phone");
            String email = req.getParameter("email");
            String address = req.getParameter("address");
            String password = req.getParameter("password");

            User user = new User();
            user.setName(name);
            user.setPhone(phone);
            user.setRoles(1);
            user.setUserStatus(1);
            user.setPassword(password);
            user.setEmail(email);

            Date date = new Date();
            user.setCreatedDate(date);

            try{
                if (AccountDB.getInstance().checkUserByEmail(email)){
                    System.out.println("!1");
                    message = "This email has already registered";
                }
                else if(AccountDB.getInstance().checkUserByPhone(phone)) {
                    System.out.println("!2");
                    message = "This phone number has already registered";
                }
                */
/*else {
                    System.out.println("!3");
                    SendMail.sendMail(email);
                    message = "OTP has been sent to " + email;
                    url = "/view/register_OTP.jsp";
                }*//*

            } catch (Exception e) {
                e.printStackTrace();
            }

            HttpSession session = req.getSession();
            session.setAttribute("user", user);

            req.setAttribute("user", user);
            req.setAttribute("message", message);
            getServletContext().getRequestDispatcher(url).forward(req, resp);
        }


}
*/

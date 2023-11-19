package com.example.webcosmetic.Servlet;


import com.example.webcosmetic.Entity.Brand;
import com.example.webcosmetic.EntityDB.BrandDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "brand", value = "/admin/brand")
public class BrandServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String url = "/admin/brand.jsp";
        if (action == null) {
            List<Brand> brands = BrandDB.selectAll();
            req.setAttribute("brands", brands);
            getServletContext().getRequestDispatcher(url).forward(req, resp);
        } else if (action.equals("Lưu")) {
            String newName = req.getParameter("newName");
            Long id = Long.parseLong(req.getParameter("id"));
            Brand brand = BrandDB.select(id);
            brand.setName(newName);
            BrandDB.update(brand);
        } else if (action.equals("Thêm")) {
            String newName = req.getParameter("newName");
            Brand brand = new Brand(newName);
            BrandDB.insert(brand);
        }
        else if (action.equals("Xoá")) {
            Long id = Long.parseLong(req.getParameter("id"));
            Brand brand = BrandDB.select(id);
            BrandDB.delete(brand);
        }
        url = "brand";
        resp.sendRedirect(url);
    }
}

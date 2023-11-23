package com.example.webcosmetic.Servlet.admin;


import com.example.webcosmetic.Entity.Brand;
import com.example.webcosmetic.EntityDB.BrandDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
        if (action == null) {
            showBrandList(req, resp);
        } else {
            processAction(action, req, resp);
        }
    }

    private void showBrandList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Brand> brands = BrandDB.selectAll();
        req.setAttribute("brands", brands);
        getServletContext().getRequestDispatcher("/admin/brand.jsp").forward(req, resp);
    }

    private void processAction(String action, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (action.equals("add")) {
            addBrand(req);
        } else {
            long id = Long.parseLong(req.getParameter("id"));
            Brand brand = BrandDB.select(id);
            if (action.equals("update")) {
                updateBrand(req, brand);
            } else if (action.equals("remove")) {
                deleteBrand(brand);
            }
        }
        resp.sendRedirect("brand");
    }

    private void addBrand(HttpServletRequest req) {
        String newName = req.getParameter("newName");
        Brand brand = new Brand(newName);
        BrandDB.insert(brand);
    }

    private void updateBrand(HttpServletRequest req, Brand brand) {
        String newName = req.getParameter("newName");
        brand.setName(newName);
        BrandDB.update(brand);
    }

    private void deleteBrand(Brand brand) {
        BrandDB.delete(brand);
    }


}

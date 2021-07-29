package controllers;

import configurations.MyConnection;
import daoModel.CityDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.City;

@WebServlet(name = "CityController", urlPatterns = {"/CityController"})
public class CityController extends HttpServlet {

    String listCity = "views/city/List.jsp";
    String addCity = "views/city/Add.jsp";
    String updateCity = "views/city/Update.jsp";
    City city = new City();
    CityDAO cityDAO = new CityDAO();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CityController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CityController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String access = "";
        String option = request.getParameter("option");
        if(option.equalsIgnoreCase("list")){
            access=listCity;
        }else if(option.equalsIgnoreCase("add")){
            access=addCity;
        }else if (option.equalsIgnoreCase("Submit")){
            String cityName = request.getParameter("txtCityName");
            String cityCountryCode = request.getParameter("txtCityCountryCode");
            String cityDistrict = request.getParameter("txtCityDistrict");
            int population = Integer.parseInt(request.getParameter("txtCityPopulation"));
            
            city.setName(cityName);
            city.setCountryCode(cityCountryCode);
            city.setDistrict(cityDistrict);
            city.setPopulation(population);
            
            cityDAO.addCity(city);
            
            access = listCity;
            
        }else if(option.equalsIgnoreCase("edit")){
            request.setAttribute("cityID", request.getParameter("id"));
            access = updateCity;
        }else if(option.equalsIgnoreCase("Update")){
            int id = Integer.parseInt(request.getParameter("txtId"));
            String cityName = request.getParameter("txtCityName");
            String cityCountryCode = request.getParameter("txtCityCountryCode");
            String cityDistrict = request.getParameter("txtCityDistrict");
            int population = Integer.parseInt(request.getParameter("txtCityPopulation"));
            
            city.setId(id);
            city.setName(cityName);
            city.setCountryCode(cityCountryCode);
            city.setDistrict(cityDistrict);
            city.setPopulation(population);
            
            cityDAO.editCity(city);
            
            access = listCity;
        }else if (option.equalsIgnoreCase("delete")){
           int id = Integer.parseInt(request.getParameter("id")); 
            city.setId(id);
            cityDAO.deleteCity(id);
            access = listCity;
            
        }
        RequestDispatcher view = request.getRequestDispatcher(access);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("ID"));
        String name = request.getParameter("Name");
        String countrycode = request.getParameter("CountryCode");
        String district = request.getParameter("District");
        int population = Integer.parseInt(request.getParameter("Population"));

        City city = new City();
        city.setName(name);
        city.setCountryCode(countrycode);
        city.setDistrict(district);
        city.setPopulation(population);

        MyConnection myConnection = new MyConnection();
        Connection conn = myConnection.connect();
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        if (id == 0) {
            String sql = "insert into city (Name, District, Population)"
                    + "values(?,?,?,)";
            try {
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, city.getName());
                preparedStatement.setString(2, city.getCountryCode());
                preparedStatement.setString(3, city.getDistrict());
                preparedStatement.setInt(4, city.getPopulation());
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("SQL Error" + ex.getMessage());
            } finally {
                myConnection.disconnect();
            }
            response.sendRedirect("CityController");
        }

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

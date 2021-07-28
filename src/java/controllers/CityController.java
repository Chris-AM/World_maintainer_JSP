package controllers;

import configurations.MyConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        String option;
        option = (request.getParameter("option") != null)
                ? request.getParameter("option")
                : "list";
        ArrayList<City> listCity = new ArrayList<City>();

        MyConnection myConnection = new MyConnection();
        Connection conn = myConnection.connect();

        PreparedStatement preparedStatement;
        ResultSet resultSet;

        if (option.equals("list")) {
            try {
                String sql = "select * from city";
                preparedStatement = conn.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    City city = new City();
                    city.setId(resultSet.getInt("ID"));
                    city.setName(resultSet.getString("Name"));
                    city.setCountryCode(resultSet.getString("CountryCode"));
                    city.setDistrict(resultSet.getString("District"));
                    city.setPopulation(resultSet.getInt("Population"));

                    listCity.add(city);
                }
                request.setAttribute("list", listCity);
                request.getRequestDispatcher(this.listCity).forward(request, response);
            } catch (SQLException e) {
                System.out.println("Mysql Error" + e.getMessage());
            } finally {
                myConnection.disconnect();
            }
        }
        if (option.equals("new")) {
            City city = new City();
            request.setAttribute("city", city);
            request.getRequestDispatcher(this.addCity).forward(request, response);
        }
        if (option.equals("update")){
            City city = new City();
            request.setAttribute("city", city);
            request.getRequestDispatcher(this.updateCity).forward(request, response);
        }
        if (option.equals("delete")) {
            try {
                int id = Integer.parseInt(request.getParameter("ID"));
                String sql = "delete from city where ID = ?";
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("SQL error" + ex);
            } finally {
                myConnection.disconnect();
            }
            response.sendRedirect("CityController");
        }
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
        
        if (id == 0 ){
            String sql = "insert into city (Name, District, Population)"
                    + "values(?,?,?,)"; 
            try{
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, city.getName());
            preparedStatement.setString(2, city.getCountryCode());
            preparedStatement.setString(3, city.getDistrict());
            preparedStatement.setInt(4, city.getPopulation());  
            preparedStatement.executeUpdate();
            }catch(SQLException ex){
                System.out.println("SQL Error" + ex.getMessage());
            }finally{
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

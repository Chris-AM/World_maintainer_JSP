<%-- 
    Document   : List
    Created on : 27-07-2021, 21:54:01
    Author     : Acid Labs
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="model.City"%>
<%@page import="daoModel.CityDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <hi>Cities</hi>
            <table border="1">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Country Code</th>
                        <th>District</th>
                        <th>Population</th>
                    </tr>
                </thead>
                <%
                    CityDAO cityDAO = new CityDAO();
                    List<City> listCity = cityDAO.list();
                    Iterator<City> iterator = listCity.iterator();
                    City city = null;
                    while(iterator.hasNext()){
                        city = iterator.next();
                    
                %>
                <tbody>
                    <tr>
                        <td><%= city.getName() %></td>
                        <td><%= city.getCountryCode()%></td>
                        <td><%= city.getDistrict()%></td>
                        <td><%= city.getPopulation()%></td>
                        <td>
                            <a>Edit</a>
                            <a>Remove</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>

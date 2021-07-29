<%-- 
    Document   : Update
    Created on : 27-07-2021, 21:54:32
    Author     : Acid Labs
--%>

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
        <h1>Update City</h1>
        <div>
            <%
              CityDAO cityDAO = new CityDAO();
              int id = Integer.parseInt((String)request.getAttribute("cityID"));
              City city = (City)cityDAO.listCity(id);
            %>
            <form class="cityForm" action="CityController">
                <p>Name</p>
                <input type="text" name="txtCityName" value="<%= city.getName() %>">
                <p>Country Code (ISO code)</p>
                <input type="text" name="txtCityCountryCode" value="<%= city.getCountryCode()%>">
                <p>District</p>
                <input type="text" name="txtCityDistrict" value="<%= city.getDistrict()%>">
                <p>Population</p>
                <input type="text" name="txtCityPopulation" value="<%= city.getPopulation()%>">
                <input type="hidden" name="txtId" value="<%= city.getId()%>">
                <input type="submit" name="option" value="Update">
                <a href="CityController?option=list">Cancel</a>
            </form>
        </div>
    </body>
</html>

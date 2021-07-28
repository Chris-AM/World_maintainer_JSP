<%-- 
    Document   : List
    Created on : 27-07-2021, 21:54:01
    Author     : Acid Labs
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="model.City"%>
<%@page import="daoModel.CityDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%List<City> listCity = (List<City>) request.getAttribute("list");%>
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
                <c:forEach var="item" items="${list}">
                <tbody>
                    <tr>
                        <td>${item.name}</td>
                        <td>${item.countryCode}</td>
                        <td>${item.district}</td>
                        <td>${item.population}</td>
                        <td>
                            <a>Edit</a>
                            <a>Remove</a>
                        </td>
                    </tr>
                </tbody>
                </c:forEach>
            </table>
        </div>
    </body>
</html>

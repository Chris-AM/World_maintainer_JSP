<%-- 
    Document   : Add
    Created on : 27-07-2021, 21:54:14
    Author     : Acid Labs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="../../styles.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <h1>Add a new city</h1>
        <div>
            <form class="cityForm" action="CityController">
                <p>Name</p>
                <input type="text" name="txtCityName">
                <p>Country Code (ISO code)</p>
                <input type="text" name="txtCityCountryCode">
                <p>District</p>
                <input type="text" name="txtCityDistrict">
                <p>Population</p>
                <input type="text" name="txtCityPopulation">
                <input type="submit" name="option" value="Submit">
            </form>
        </div>
        
    </body>
</html>

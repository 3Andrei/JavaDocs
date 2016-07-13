<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="ro.teamnet.zth.appl.dao.LocationDao" %>
<%@ page import="ro.teamnet.zth.appl.domain.Location" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Locations List</title>
</head>
<body>
  <%
        String idStr=request.getParameter("id");
        Integer id=Integer.parseInt(idStr);
        LocationDao locationDao=new LocationDao();
        Location location =locationDao.getLocationById(id);
    %>
    <span><%=id %></span>
<table border="1">
    <thead>
    <tr>
        <td>Id</td>
        <td>Street address</td>
        <td>Postal code</td>
        <td>City</td>
        <td>State province</td>
    </tr>
    </thead>
    <tbody>
    <%
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    %>
   <tr>
           <td>
               <%=location.getId()%>
           </td>
           <td>
               <%=location.getStreetAddress()%>
           </td>
           <td>
               <%=location.getPostalCode()%>
           </td>
           <td>
               <%=location.getCity()%>
           </td>
           <td>
               <%=location.getStateProvince()%>
           </td>
       </tr>

    </tbody>
</table>
<a href="locationList.jsp">Locations List</a>
</body>
</html>

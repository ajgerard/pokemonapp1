
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css.css" />
        <title>JSP Page</title>
    </head>

    <% String table = (String) request.getAttribute("table");%>

    <body>  
        <div class="wrap">

            <%@ include file="include/header.jsp" %>

            <%@ include file="include/menu.jsp" %>

            <div class="main">


                <h1>Strong Pokemon</h1>
                <%= table%>

                <br><br>

            </div>

            <%@ include file="include/footer.jsp" %>

        </div>
    </body>
</html>

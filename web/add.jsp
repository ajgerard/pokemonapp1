
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add A New Pokemon</title>
    </head>
    <body>
        <h1>Add a new Pokemon</h1>
        
        <form name="addForm" action="addPokemon" method="get">
            
            <label>Pokemon Name:</label>
            <input type="text" name="name" value="" />
            <br>
            <label>Type:</label>
            <input type="text" name="type" value="" />
            <br>
            <label>Location:</label>
            <input type="text" name="location"  value="" />
            <br>
            <label>Strength Rating:</label>
            <input type="text" name="strength" value="" />
            <br>
            <input type="submit" name="submit" value="Submit" />
        </form>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Pokemon"%>
<% Pokemon pokemon = (Pokemon) request.getAttribute("pokemon"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css.css" />
        <title>Update A Pokemon</title>
    </head>
    <body>
        <h1>Update a Pokemon Record</h1>
        
        <form name="updateForm" action="updatePokemon" method="get">
            
            <label>Pokemon ID:</label>
            <input type="text" name="ID" value="<%= pokemon.getPokemonID() %>" />
            <label>Pokemon Name:</label>
            <input type="text" name="name" value="<%= pokemon.getPokemonName() %>" />
            <br>
            <label>Type:</label>
            <input type="text" name="type" value="<%= pokemon.getType() %>" />
            <br>
            <label>Location:</label>
            <input type="text" name="location"  value="<%= pokemon.getLocation() %>" />
            <br>
            <label>Strength Rating:</label>
            <input type="text" name="strength" value="<%= pokemon.getStrengthRating() %>" />
            <br>
            <input type="submit" name="submit" value="Submit" />
            
        </form>
    </body>
</html>

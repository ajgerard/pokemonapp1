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
            
            <table class="update">
                <tr>
                    <th>Update Pokemon</th>
                </tr>
                
                <tr>
                    <td class="right">Pokemon ID:</td>
                    <td><input type="text" name="id" value="<%= pokemon.getPokemonID() %>" readonly/></td>
                </tr>
                
                <tr>
                    <td class="right">Pokemon Name:</td>
                    <td><input type="text" name="name" value="<%= pokemon.getPokemonName() %>" /></td>
                </tr>
                
                <tr>
                    <td class="right">Type:</td>
                    <td><input type="text" name="type" value="<%= pokemon.getType() %>" /></td>
                </tr>
                
                <tr>
                    <td class="right">Location:</td>
                    <td><input type="text" name="location"  value="<%= pokemon.getLocation() %>" /></td>
                </tr>
                
                <tr>
                    <td class="right">Strength Rating:</td>
                    <td><input type="text" name="strength" value="<%= pokemon.getStrengthRating() %>" /></td>
                </tr>
            </table>    
              
                <input type="submit" name="submit" value="Submit" />
                
        </form>
    </body>
</html>

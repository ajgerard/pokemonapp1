
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css.css" />
        <title>Add A New Pokemon</title>
    </head>
    <body>
        <h1>Add a new Pokemon</h1>
        
        <form name="addForm" action="addPokemon" method="get">
            
            <table class="add">
                <tr>
                    <td class="right">Pokemon Name:</td>
                    <td><input type="text" name="name" value="" /></td>
                </tr>
                
                <tr>
                    <td class="right">Type:</td>
                    <td><input type="text" name="type" value="" /></td>
                </tr>
            
                <tr>
                    <td class="right">Location:</td>
                    <td><input type="text" name="location"  value="" /></td>
                </tr>
                
                <tr>
                    <td class="right">Strength Rating:</td>
                    <td><input type="text" name="strength" value="" /></td>
                </tr>
            </table>
            <input type="submit" name="submit" value="Submit" />
        </form>
    </body>
</html>

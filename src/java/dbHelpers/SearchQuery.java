
package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Pokemon;


public class SearchQuery {
    
    private Connection conn;
    private ResultSet results;
    
    public SearchQuery(){
    
     Properties props = new Properties();
    InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    String driver = props.getProperty("driver.name");
    String url = props.getProperty("server.name");
    String username = props.getProperty("user.name");
    String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doSearch(String PokemonName){
    
        try {
            String query = "SELECT * FROM StrongPokemon WHERE UPPER(PokemonName) LIKE ? ORDER BY PokemonID ASC";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + PokemonName.toUpperCase() + "%");
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public String getHTMLtable(){
     
        String table = "";
        
        table += "<table>";
        
        table += "<tr>";
        table += "<th>";
        table += "PokemonID";
        table += "</th>";
        
        table += "<th>";
        table += "Pokemon Name";
        table += "</th>";
        
        table += "<th>";
        table += "Type";
        table += "</th>";
        
        table += "<th>";
        table += "Location";
        table += "</th>";
        
        table += "<th>";
        table += "Strength Rating";
        table += "</th>";
        
        table += "<th>";
        table += "";
        table += "</th>";
        table += "</tr>";
              
        
        try {
            while(this.results.next()){
                
                Pokemon pokemon = new Pokemon();
                pokemon.setPokemonID(this.results.getInt("PokemonID"));
                pokemon.setPokemonName(this.results.getString("PokemonName"));
                pokemon.setType(this.results.getString("Type"));
                pokemon.setLocation(this.results.getString("Location"));
                pokemon.setStrengthRating(this.results.getInt("StrengthRating"));
                
                table += "<tr>";
                table += "<td>";
                table += pokemon.getPokemonID();
                table += "</td>" ; 
                
                table += "<td>";
                table += pokemon.getPokemonName();
                table += "</td>" ;    
                
                table += "<td>";
                table += pokemon.getType();
                table += "</td>" ;    
                
                table += "<td>";
                table += pokemon.getLocation();
                table += "</td>" ;    
                
                table += "<td>";
                table += pokemon.getStrengthRating();
                table += "</td>" ;   
                
                table += "<td>";
                table += "<a href=update?PokemonID=" + pokemon.getPokemonID() + "> Update </a>" + "<a href=delete?PokemonID=" + pokemon.getPokemonID() +"> Delete </a>";
                table += "</td>";
                
                table += "</tr>";
                
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        table += "</table>";
        
        return table;
    
    
    }
    
}

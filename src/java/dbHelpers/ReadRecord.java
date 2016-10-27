
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


public class ReadRecord {
    
    private Connection conn;
    private ResultSet results;
    
    private Pokemon pokemon = new Pokemon();
    private int PokemonID;
    
    public ReadRecord (int PokemonID){

      Properties props = new Properties();
      InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    String driver = props.getProperty("driver.name");
    String url = props.getProperty("server.name");
    String username = props.getProperty("user.name");
    String passwd = props.getProperty("user.password");
    
    this.PokemonID = PokemonID;
    
    
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public void doRead() {
    
        try {
            String query = "SELECT * FROM StrongPokemon WHERE PokemonID =?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setInt(1, PokemonID);
            
            this.results = ps.executeQuery();
            
            this.results.next();
            
            pokemon.setPokemonID(this.results.getInt("PokemonID"));
            pokemon.setPokemonName(this.results.getString("PokemonName"));
            pokemon.setType(this.results.getString("Type"));
            pokemon.setLocation(this.results.getString("Location"));
            pokemon.setStrengthRating(this.results.getInt("StrengthRating"));
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
}
     
    public Pokemon getPokemon(){
                return this.pokemon;
    }
}

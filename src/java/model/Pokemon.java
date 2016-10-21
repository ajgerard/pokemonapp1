
package model;


public class Pokemon {
    
   private int PokemonID;
   private String PokemonName;
   private String Type;
   private String Location;
   private int StrengthRating;
   
    public Pokemon() {
        this.PokemonID = 0;
        this.PokemonName = "";
        this.Type = "";
        this.Location = "";
        this.StrengthRating = 0;
    }

    public Pokemon(int PokemonID, String PokemonName, String Type, String Location, int StrengthRating) {
        this.PokemonID = PokemonID;
        this.PokemonName = PokemonName;
        this.Type = Type;
        this.Location = Location;
        this.StrengthRating = StrengthRating;
    }

    public int getPokemonID() {
        return PokemonID;
    }

    public void setPokemonID(int PokemonID) {
        this.PokemonID = PokemonID;
    }

    public String getPokemonName() {
        return PokemonName;
    }

    public void setPokemonName(String PokemonName) {
        this.PokemonName = PokemonName;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public int getStrengthRating() {
        return StrengthRating;
    }

    public void setStrengthRating(int StrengthRating) {
        this.StrengthRating = StrengthRating;
    }

    @Override
    public String toString() {
        return "Pokemon{" + "PokemonID=" + PokemonID + ", PokemonName=" + PokemonName + ", Type=" + Type + ", Location=" + Location + ", StrengthRating=" + StrengthRating + '}';
    }
   
    
}

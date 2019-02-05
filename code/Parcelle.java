import java.util.*;

public class Parcelle {

  private int row;
  private int col;
  private int nbPlaces;
  private ArrayList<Personnage> personnages;

  public Parcelle(int col, int row){
    this.row = row;
    this.col = col;
  }
  
  public ArrayList<Personnage> getPerso() {
    return this.personnages;
  }

}
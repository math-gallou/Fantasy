import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Gnome extends Personnage {

  public AutomateGnome controleur;

  public Gnome(Parcelle p, String nom){
    this.nom = nom;
    this.setParcelle(p);
    this.controleur = new AutomateGnome(this);
    this.tribu = null;
  }

  public Shape dessiner(Color couleur){
    Rectangle res = new Rectangle();
    res.setHeight(5);
    res.setWidth(5);
    return res;
  }
  
  public void fuirGnome() {
  }

  public void deserterGnome() {
  }

  public void refugierGnome() {
  }

  public boolean memeParcelleChef() {
    return false;
  }

  public boolean isElfe(){
    return false;
  }

  public boolean isGnome(){
    return true;
  }

  public String toString(){
    return "G"+this.nom;
  }
  
}
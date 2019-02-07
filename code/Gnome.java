import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class Gnome extends Personnage {

  public AutomateGnome controleur;

  public Gnome(Parcelle p, String nom){
    this.nom = nom;
    this.setParcelle(p);
    this.controleur = new AutomateGnome(this);
  }

  public Shape dessiner(){
    return new Circle();
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

}
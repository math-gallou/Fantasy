import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Elfe extends Personnage {

  private IStrategie role;

  public Elfe(Parcelle p, String name){
    this.parcelle = p;
    this.nom = name;
    this.role = new Normal();
  }

  public Shape dessiner(){
    return new Rectangle();
  }

  public void seDeplacer() {
  }

  public void repondSollicitation() {
  }

  public void formeTribu() {
  }

  public void sollicite() {
  }

  public void sEmancipe() {
  }

  public void negocie(Elfe chef) {
  }

  public void devenirChef() {
  }

  public void isChefSupreme() {
  }

  public boolean isElfe(){
    return true;
  }

  public boolean isGnome(){
    return false;
  }

}
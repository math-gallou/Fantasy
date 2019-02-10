import javafx.scene.shape.Shape;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import java.util.*;

public class Elfe extends Personnage {

  private IStrategie role;

  public Elfe(Parcelle p, String name){
    this.parcelle = p;
    this.nom = name;
    this.role = new Normal();
  }

  public Shape dessiner(Color couleur){
    return this.role.dessiner(couleur);
  }

  public void seDeplacer(Monde m) {
    this.parcelle = this.choisirDeplacement(m);
    this.parcelle.ajouterPerso(this);
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

  public String toString(){
    return "l'elfe "+this.nom;
  }

  public Parcelle choisirDeplacement(Monde m){
    Parcelle p_res = null;
    Alert alert = new Alert(AlertType.CONFIRMATION);
    alert.setTitle("Déplacement");
    alert.setHeaderText("Choisissez la nouvelle parcelle");

    Parcelle pgauche = null;
    Parcelle pdroit = null;
    Parcelle pbas = null;
    Parcelle phaut = null;

    ButtonType gauche = new ButtonType("La parcelle de gauche");
    ButtonType droite = new ButtonType("La parcelle de droite");
    ButtonType haut = new ButtonType("La parcelle du haut");
    ButtonType bas = new ButtonType("La parcelle du bas");

    alert.getButtonTypes().setAll(gauche, droite, haut, bas);
    alert.getDialogPane().lookupButton(gauche).setDisable(true);
    alert.getDialogPane().lookupButton(droite).setDisable(true);
    alert.getDialogPane().lookupButton(haut).setDisable(true);
    alert.getDialogPane().lookupButton(bas).setDisable(true);

    for (Parcelle p : m.getParcelles()){
      if (this.parcelle.isAGauche(p)){
        pgauche = p;
        alert.getDialogPane().lookupButton(gauche).setDisable(false);
      } else if (this.parcelle.isADroite(p)){
        pdroit = p;
        alert.getDialogPane().lookupButton(droite).setDisable(false);
      } else if (this.parcelle.isEnHaut(p)){
        phaut = p;
        alert.getDialogPane().lookupButton(haut).setDisable(false);
      } else if (this.parcelle.isEnBas(p)){
        pbas = p;
        alert.getDialogPane().lookupButton(bas).setDisable(false);
      }
    }

    Optional<ButtonType> result = alert.showAndWait();
    if (result.get() == gauche){
      System.out.println("La parcelle de gauche");
      p_res = pgauche;
    } else if (result.get() == droite) {
      System.out.println("La parcelle de droite");
      p_res = pdroit;
    } else if (result.get() == haut) {
      System.out.println("La parcelle du haut");
      p_res = phaut;
    } else if (result.get() == bas){
      System.out.println("La parcelle du bas");
      p_res = pbas;
    }
    return p_res;
  }

  public boolean isChef(){
    return this.role.isChef();
  }
}
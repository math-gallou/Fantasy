import javafx.scene.shape.Shape;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.*;

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

  public void seDeplacer(Monde m) {
    this.parcelle = this.choisirDeplacement(m);
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

    ArrayList<ButtonType> choix = new ArrayList<>();

    for (Parcelle p : m.getParcelles()){
      if (this.parcelle.isAGauche(p)){
        pgauche = p;
        choix.add(gauche);
      } else if (this.parcelle.isADroite(p)){
        pdroit = p;
        choix.add(droite);
      } else if (this.parcelle.isENHaut(p)){
        phaut = p;
        choix.add(haut);
      } else if (this.parcelle.isEnBas(p)){
        pbas = p;
        choix.add(bas);
      }
    }

    alert.getButtonTypes().setAll(choix);

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

}
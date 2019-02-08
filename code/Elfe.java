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
    this.choisirDeplacement(m);
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
    Alert alert = new Alert(AlertType.CONFIRMATION);
    alert.setTitle("Déplacement");
    alert.setHeaderText("Choisissez la nouvelle parcelle");

    ButtonType gauche = new ButtonType("La parcelle de gauche");
    ButtonType droite = new ButtonType("La parcelle de droite");
    ButtonType haut = new ButtonType("La parcelle du haut");
    ButtonType bas = new ButtonType("La parcelle du bas");

    alert.getButtonTypes().setAll(gauche, droite, haut, bas);

    Optional<ButtonType> result = alert.showAndWait();
    if (result.get() == gauche){
      System.out.println("La parcelle de gauche");
    } else if (result.get() == droite) {
      System.out.println("La parcelle de droite");
    } else if (result.get() == haut) {
      System.out.println("La parcelle du haut");
    } else if (result.get() == bas){
      System.out.println("La parcelle du bas");
    }
    return new Parcelle();
  }

}
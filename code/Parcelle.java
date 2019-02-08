import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.*;

public class Parcelle {

  private int row;
  private int col;
  private int nbPlaces;
  private ArrayList<Personnage> personnages;
  private StackPane dessin;

  public Parcelle(){

  }

  public Parcelle(int col, int row){
    this.row = row;
    this.col = col;
    this.personnages = new ArrayList<Personnage>();
    this.dessin = new StackPane();
  }

  public StackPane dessiner(){
    Rectangle r = new Rectangle();
    r.setWidth(100);
    r.setHeight(100);
    r.setFill(Color.RED);
    r.setStroke(Color.BLACK);
    this.dessin.getChildren().add(r);
    return this.dessin;
  }

  public void dessinerPersonnages(){
    VBox texte = new VBox(5);
    texte.getChildren().add(new Label(String.valueOf(this.getElfes().size())+" elfes."));
    texte.getChildren().add(new Label(String.valueOf(this.getGnomes().size())+" gnomes."));
    this.dessin.getChildren().add(texte);
  }
  
  public ArrayList<Personnage> getPerso() {
    return this.personnages;
  }

  public void ajouterPerso(Personnage p){
    this.personnages.add(p);
  }

  public void enleverPerso(Personnage p){
    this.personnages.remove(p);
  }

  public ArrayList<Personnage> getElfes(){
    ArrayList<Personnage> res = new ArrayList<>();
    for (Personnage p : this.personnages){
      if (p.isElfe()){
        res.add(p);
      }
    }
    return res;
  }

  public ArrayList<Personnage> getGnomes(){
    ArrayList<Personnage> res = new ArrayList<>();
    for (Personnage p : this.personnages){
      if (p.isGnome()){
        res.add(p);
      }
    }
    return res;
  }

  public boolean isAGauche(Parcelle p){
    return true;
  }

  public boolean isADroite(Parcelle p){
    return true;
  }

  public boolean isENHaut(Parcelle p){
    return true;
  }

  public boolean isEnBas(Parcelle p){
    return true;
  }

}
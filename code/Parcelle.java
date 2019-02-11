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
  private ArrayList<Tribu> tribus;

  public Parcelle(int col, int row){
    this.row = row;
    this.col = col;
    this.personnages = new ArrayList<>();
    this.dessin = new StackPane();
    this.nbPlaces = 0;
    this.tribus = new ArrayList<>();
  }

  public void setNbPlaces(int i){
    this.nbPlaces = i;
  }

  public StackPane dessiner(){
    Rectangle r = new Rectangle();
    r.setWidth(250);
    r.setHeight(250);
    r.setFill(Color.RED);
    r.setStroke(Color.BLACK);
    this.dessin.getChildren().add(r);

    VBox test = new VBox(5);
    for (Tribu b : this.tribus){
      test.getChildren().add(b.dessiner(this));
    }

    int nbgnomes = 0;
    Label seuls = new Label();
    for (Personnage e : this.getGnomes()){
      if (!e.hasTribu()){
        nbgnomes ++;
      }
    }
    if (nbgnomes > 0){
      seuls.setText(seuls.getText()+" gnomes seuls : "+nbgnomes);
    }
    test.getChildren().add(seuls);
    this.dessin.getChildren().add(test);

    return this.dessin;
  }
  
  public ArrayList<Personnage> getPerso() {
    return this.personnages;
  }

  public void ajouterPerso(Personnage p){
    this.personnages.add(p);
    if (p.getTribu()!=null && !this.tribus.contains(p.getTribu())){
      this.tribus.add(p.getTribu());
    }
  }

  public void enleverPerso(Personnage p){
    this.personnages.remove(p);
    int i = 0;
    boolean present = false;
    while (i < this.personnages.size() && !present){
      if (this.personnages.get(i).hasTribu()){
        if (this.personnages.get(i).getTribu().equals(p.getTribu())){
          present = true;
        }
      }
      i++;
    }
    if (!present){
      this.tribus.remove(p.getTribu());
    }
  }

  public ArrayList<Elfe> getElfes(){
    ArrayList<Elfe> res = new ArrayList<>();
    for (Personnage p : this.personnages){
      if (p.isElfe()){
        res.add((Elfe) p);
      }
    }
    return res;
  }

  public ArrayList<Gnome> getGnomes(){
    ArrayList<Gnome> res = new ArrayList<>();
    for (Personnage p : this.personnages){
      if (p.isGnome()){
        res.add((Gnome) p);
      }
    }
    return res;
  }

  public boolean isAGauche(Parcelle p){
    return (this.row == p.getRow()) && (this.col - p.getCol() == 1) && this.restePlace();
  }

  public boolean isADroite(Parcelle p){
    return (this.row == p.getRow()) && (p.getCol() - this.col == 1) && this.restePlace();
  }

  public boolean isEnHaut(Parcelle p){
    return (this.col == p.getCol()) && (this.row - p.getRow() == 1) && this.restePlace();
  }

  public boolean isEnBas(Parcelle p){
    return (this.col == p.getCol()) && (p.getRow() - this.row == 1) && this.restePlace();
  }

  public int getRow(){
    return this.row;
  }

  public int getCol(){
    return this.col;
  }

  public int getNbPlaces(){
    return this.nbPlaces;
  }

  public boolean restePlace(){
    return this.nbPlaces - this.personnages.size() > 0;
  }

  public void ajouterTribu(Tribu a){
    this.tribus.add(a);
  }

  public ArrayList<Tribu> getTribus(){
    return this.tribus;
  }

  public boolean equals(Parcelle p){
    return p.getRow() == this.row && p.col == this.getCol();
  }

  public Parcelle getDroite(ArrayList<Parcelle> parcelles){
    int nb = (int)Math.sqrt(parcelles.size());
    if (this.col+1 <= nb-1){
      return parcelles.get((this.col+1) + this.row*nb);
    }
    return null;
  }

  public Parcelle getGauche(ArrayList<Parcelle> parcelles){
    int nb = (int)Math.sqrt(parcelles.size());
    if (this.col-1 >= 0){
      return parcelles.get((this.col - 1) + this.row*nb);
    }
    return null;
  }

  public Parcelle getHaut(ArrayList<Parcelle> parcelles){
    int nb = (int)Math.sqrt(parcelles.size());
    if (this.row-1 >= 0){
      return parcelles.get((this.row-1)*nb + this.col);
    }
    return null;
  }

  public Parcelle getBas(ArrayList<Parcelle> parcelles){
    int nb = (int)Math.sqrt(parcelles.size());
    if (this.row + 1 < nb-1){
      return parcelles.get((this.row + 1)*nb + this.col);
    }
    return null;
  }

  public String toString(){
    return "P"+this.col+this.row+this.personnages;
  }

  public boolean isACote(Parcelle p){
    return this.isEnBas(p) || this.isEnHaut(p) || this.isADroite(p) || this.isAGauche(p);
  }

  public ArrayList<Parcelle> getVoisinsDispo(ArrayList<Parcelle> parcelles){
    ArrayList<Parcelle> res = new ArrayList<>();
    if (this.getBas(parcelles) != null){
      if (this.getBas(parcelles).restePlace()){
        res.add(this.getBas(parcelles));
      }
    }
    if (this.getHaut(parcelles) != null){
      if (this.getBas(parcelles).restePlace()){
        res.add(this.getHaut(parcelles));
      }
    }
    if (this.getDroite(parcelles) != null){
      if (this.getDroite(parcelles).restePlace()){
        res.add(this.getDroite(parcelles));
      }
    }
    if (this.getGauche(parcelles) != null){
      if (this.getGauche(parcelles).restePlace()){
        res.add(this.getGauche(parcelles));
      }
    }
    return res;
  }

  public boolean unSeulElfe(){
    return this.getElfes().size() == 1;
  }
}
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.Random;

public class Gnome extends Personnage implements IEventGnome {

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

  public AutomateGnome getControleur(){
      return this.controleur;
  }
  
  public void fuirGnome(ArrayList<Parcelle> parcelles) {
      Random rand = new Random();
      ArrayList<Parcelle> voisins = this.parcelle.getVoisinsDispo(parcelles);
      if (voisins.size() > 0){
          int choix = rand.nextInt(voisins.size());
          this.parcelle.enleverPerso(this);
          voisins.get(choix).ajouterPerso(this);
          this.setParcelle(voisins.get(choix));
      }
      System.out.println(this + " fuit en " + this.parcelle);
  }

  public void deserterGnome(Tribu nouvelle_tribu) {
      System.out.println(this + " déserte " + this.tribu + " pour " + nouvelle_tribu);
      this.tribu.enleverEnfant(this);
      this.setTribu(nouvelle_tribu);
  }

  public void refugierGnome() {
      if (this.tribu.getChef().getParcelle().isACote(this.parcelle)){
          this.parcelle.enleverPerso(this);
          this.tribu.getChef().getParcelle().ajouterPerso(this);
          this.setParcelle(this.tribu.getChef().getParcelle());
          System.out.println(this + " se réfugie en " + this.parcelle);
      }
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

  public void deplacementElfe(){
      this.controleur.deplacementElfe();
  }

  public void elfeRepondSollicitation(){
      this.controleur.elfeRepondSollicitation();
  }

  public void elfeFormeTribu(){
      this.controleur.elfeFormeTribu();
  }

  public void elfeSollicite(Tribu nouvelle_tribu, ArrayList<Parcelle> parcelles){
      this.controleur.elfeSollicite(nouvelle_tribu, parcelles);
  }

  public void elfeSEmancipe(){
      this.controleur.elfeSEmancipe();
  }

  public void elfeNegocie(){
      this.controleur.elfeNegocie();
  }
}
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
  
  public void fuirGnome(ArrayList<Parcelle> parcelles, Parcelle parcelle_eviter) {
      Random rand = new Random();
      ArrayList<Parcelle> voisins = this.parcelle.getVoisinsDispo(parcelles);
      voisins.remove(parcelle_eviter);
      if (voisins.size() > 0){
          this.deplacementPerso(voisins.get(rand.nextInt(voisins.size())));
          System.out.println(this + " fuit en " + this.parcelle);
      } else {
          System.out.println(this + " n'a pas pu fuir !");
      }
  }

  public void deserterGnome(Tribu nouvelle_tribu) {
      System.out.println(this + " déserte " + this.tribu + " pour " + nouvelle_tribu);
      if (this.hasTribu()){
          this.tribu.enleverEnfant(this);
      }
      this.setTribu(nouvelle_tribu);
      nouvelle_tribu.ajouterEnfant(this);
      this.deplacementPerso(this.parcelle);
  }

  public void refugierGnome() {
      if (this.tribu.getChef().getParcelle().isACote(this.parcelle)){
          this.deplacementPerso(this.tribu.getChef().getParcelle());
          System.out.println(this + " se réfugie en " + this.parcelle);
      }
  }

  public boolean memeParcelleChef() {
    return this.tribu.getChef().getParcelle().equals(this.parcelle);
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
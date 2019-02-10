import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.util.*;

public class Tribu extends Element {

  private static int cpt = 1;

  private String name;
  private Tribu parent;
  private ArrayList<Element> enfantsDomines;
  private Elfe chef;

  public Tribu(Elfe chef, ArrayList<Personnage> premiers_domines){
    this.chef = chef;
    this.enfantsDomines = new ArrayList<>();
    this.enfantsDomines.addAll(premiers_domines);
    this.name = String.valueOf(cpt);
    cpt ++;
  }

  public boolean isElfe(){
    return false;
  }

  public boolean isGnome(){
    return false;
  }

  public boolean isTribu(){
    return true;
  }

  public void ajouterEnfant(Element enfant){
    this.enfantsDomines.add(enfant);
  }
  
  public ArrayList<Element> getEnfants() {
    return this.enfantsDomines;
  }

  public Elfe getChef() {
    return this.chef;
  }

  public ArrayList<Tribu> getTribuesDominees() {
    ArrayList<Tribu> res = new ArrayList<>();
    for (Element e : this.enfantsDomines){
      if (e.isTribu()){
        res.add((Tribu) e);
      }
    }
    return res;
  }

  public ArrayList<Gnome> getGnomes() {
    ArrayList<Gnome> res = new ArrayList<>();
    for (Element e : this.enfantsDomines){
      if (e.isGnome()){
        res.add((Gnome)e);
      }
    }
    return res;
  }

  public ArrayList<Elfe> getElfes(){
    ArrayList<Elfe> res = new ArrayList<>();
    for (Element e : this.enfantsDomines){
      if (e.isElfe()){
        Elfe a = (Elfe) e;
        if (!a.isChef()){
          res.add(a);
        }
      }
    }
    return res;
  }

  public String toString(){
    return "T"+this.name;
  }

  public String affichage(){
    return "tribu " + this.name + " chef elfe " + this.chef + "\nelfes " + this.getElfes() + "\n" + this.getGnomes().size() + " gnomes\ntribus " + this.getTribuesDominees();
  }

  public boolean isDominante(){
    return this.getTribuesDominees().size() == 0;
  }

  public Node dessiner(){
    Text res = new Text(this.affichage());
    return res;
  }
}
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

  public void enleverEnfant(Element enfant){
    this.enfantsDomines.remove(enfant);
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
    return "tribu " + this.name + " chef elfe " + this.chef + "\nelfes " + this.getElfes() + "\n" + this.getGnomes().size() + " gnomes\ntribus dominées " + this.getTribuesDominees() + "\n\n";
  }

  public boolean isDominante(){
    return this.getTribuesDominees().size() == 0;
  }

  public Node dessiner(Parcelle p){
    Text res = new Text(" Tribu " + this.name + " :\n");
    ArrayList<Elfe> elfes_presents = new ArrayList<>();
    for (Elfe e : this.getElfes()){
      if (e.isSurParcelle(p)){
        elfes_presents.add(e);
      }
    }
    int nb_gnomes = 0;
    for (Gnome g : this.getGnomes()){
      if (g.isSurParcelle(p)){
        nb_gnomes ++;
      }
    }
    if (elfes_presents.size()>0){
      res.setText(res.getText()+ "  - elfes : " + elfes_presents + "\n");
    }
    if (nb_gnomes > 0){
      res.setText(res.getText()+ "  - gnomes : " + nb_gnomes + "\n");
    }
    return res;
  }

  public String getName(){
    return this.name;
  }

  public boolean equals(Tribu t){
    return this.name.equals(t.getName());
  }
}
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
  
  public void getEnfants() {
  }

  public void getChef() {
  }

  public void getTribuesDominees() {
  }

  public void getGnomes() {
  }

  public String toString(){
    return "tribu " + this.name + this.enfantsDomines;
  }

}
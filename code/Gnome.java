public class Gnome extends Personnage {

  public AutomateGnome controleur;

  public Gnome(){
    this.controleur = new AutomateGnome();
  }
  
  public void fuirGnome() {
  }

  public void deserterGnome() {
  }

  public void refugierGnome() {
  }

  public boolean memeParcelleChef() {
    return false;
  }

}
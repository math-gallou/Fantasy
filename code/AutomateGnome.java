public class AutomateGnome implements IEventGnome {

  private IEtatGnome etatCourant;
  private Gnome controle;

  public AutomateGnome(Gnome controle){
    this.controle = controle;
    this.etatCourant = new GnomeVulnerable();
  }

  public Gnome getControle() {
    return this.controle;
  }

  public void changerEtat(IEtatGnome etat) {
  }

  public void deplacementElfe(){}

  public void elfeRepondSollicitation(){}

  public void efleFormeTribu(){}

  public void efleSollicite(){}

  public void elfeSEmancipe(){}

  public void elfeNegocie(){}

}
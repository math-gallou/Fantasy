import java.util.ArrayList;

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
    this.etatCourant = etat;
  }

  public void deplacementElfe(){
    this.etatCourant.deplacementElfe(this);
  }

  public void elfeRepondSollicitation(){
    this.etatCourant.elfeRepondSollicitation(this);
  }

  public void elfeFormeTribu(){
    this.etatCourant.elfeFormeTribu(this);
  }

  public void elfeSollicite(Tribu nouvelle_tribu, ArrayList<Parcelle> parcelles){
    this.etatCourant.elfeSollicite(this, nouvelle_tribu, parcelles);
  }

  public void elfeSEmancipe(){
    this.etatCourant.elfeseSEmancipe(this);
  }

  public void elfeNegocie(){
    this.etatCourant.elfeNegocie(this);
  }

}